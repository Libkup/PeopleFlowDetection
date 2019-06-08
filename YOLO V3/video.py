from __future__ import division
import time
import torch 
import torch.nn as nn
from torch.autograd import Variable
import numpy as np
import cv2 
from util import *
import argparse
import os 
import os.path as osp
from darknet import Darknet
import pickle as pkl
import pandas as pd
import random
import threading
import time
import requests
import subprocess as sp
from PIL import Image

process_image = (np.ones((540, 960, 3), dtype=np.uint8) * 255).astype(np.uint8)
# command = ['ffmpeg',
#             '-y',
#             '-f', 'rawvideo',
#             '-vcodec','rawvideo',
#             '-acodec', 'copy',
#             '-f', 'flv',
#             'rtmp://localhost:1935/live/home']
command = ['ffmpeg',
    '-y',
    '-f', 'rawvideo',
    '-vcodec','rawvideo',
    '-pix_fmt', 'bgr24',
    '-s', '960x540',
    '-r', str(4),
    '-i', '-',
    '-c:v', 'libx264',
    '-pix_fmt', 'yuv420p',
    '-preset', 'ultrafast',
    '-f', 'flv',
    'rtmp://localhost:1935/live/home']


class PushThread(threading.Thread):
    def __init__(self):
        super(PushThread, self).__init__()  # 注意：一定要显式的调用父类的初始化函数。
        # self.arg=arg

    def run(self):  # 定义每个线程要运行的函数
        print('push thread is run!')
        global process_image
        global count
        url = "http://localhost:8080/PeopleFlowDetection/PeopleCount"
        # time.sleep(5)
        while True:
            ###########################图片采集
            #print(process_image)
            #print(pipe)
            #print(pipe.stdin)
            # print(process_image)
            # pipe.stdin.write(process_image.tostring())  # 存入管道
            # print('push!')
            param = {'id1': '1','account1':str(count)}
            try:
                r = requests.post(url=url, data=param)
            except:
                pass
            # print(count)
            
            time.sleep(0.5)





def arg_parse():
    """
    Parse arguements to the detect module
    
    """
    
    parser = argparse.ArgumentParser(description='YOLO v3 Detection Module')
    parser.add_argument("--bs", dest = "bs", help = "Batch size", default = 1)
    parser.add_argument("--confidence", dest = "confidence", help = "Object Confidence to filter predictions", default = 0.5)
    parser.add_argument("--nms_thresh", dest = "nms_thresh", help = "NMS Threshhold", default = 0.4)
    parser.add_argument("--cfg", dest = 'cfgfile', help = 
                        "Config file",
                        default = "cfg/yolov3.cfg", type = str)
    parser.add_argument("--weights", dest = 'weightsfile', help = 
                        "weightsfile",
                        default = "yolov3.weights", type = str)
    parser.add_argument("--reso", dest = 'reso', help = 
                        "Input resolution of the network. Increase to increase accuracy. Decrease to increase speed",
                        default = "416", type = str)
    parser.add_argument("--video", dest = "videofile", help = "Video file to     run detection on", default = "video.avi", type = str)
    
    return parser.parse_args()
    
args = arg_parse()
batch_size = int(args.bs)
confidence = float(args.confidence)
nms_thesh = float(args.nms_thresh)
start = 0
CUDA = torch.cuda.is_available()



num_classes = 80
classes = load_classes("data/coco.names")



#Set up the neural network
print("Loading network.....")
model = Darknet(args.cfgfile)
model.load_weights(args.weightsfile)
print("Network successfully loaded")

model.net_info["height"] = args.reso
inp_dim = int(model.net_info["height"])
assert inp_dim % 32 == 0 
assert inp_dim > 32

#If there's a GPU availible, put the model on GPU
if CUDA:
    model.cuda()


#Set the model in evaluation mode
model.eval()


count = 0

class detectThread(threading.Thread):
    def __init__(self):
        super(detectThread, self).__init__()  # 注意：一定要显式的调用父类的初始化函数。

    def run(self): 
        def write(x, results):
            c1 = tuple(x[1:3].int())
            c2 = tuple(x[3:5].int())
            img = results
            cls = int(x[-1])
            color = random.choice(colors)
            label = "{0}".format(classes[cls])
            global count
            if label == 'person':
                count = count +1
                cv2.rectangle(img, c1, c2,color, 1)
                t_size = cv2.getTextSize(label, cv2.FONT_HERSHEY_PLAIN, 1 , 1)[0]
                c2 = c1[0] + t_size[0] + 3, c1[1] + t_size[1] + 4
                cv2.rectangle(img, c1, c2,color, -1)
                cv2.putText(img, label, (c1[0], c1[1] + t_size[1] + 4), cv2.FONT_HERSHEY_PLAIN, 1, [225,255,255], 1);
            return img
        #Detection phase
        global process_image
        videofile = args.videofile #or path to the video file. 
        global count
        cap = cv2.VideoCapture(videofile)  
        time.sleep(4)
        #cap = cv2.VideoCapture(0)  for webcam

        assert cap.isOpened(), 'Cannot capture source'

        frames = 0  
        start = time.time()

        fps = cap.get(cv2.CAP_PROP_FPS)  
        video_size = (int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)),   
        int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))) 
        output_movie = cv2.VideoWriter('test.mp4', cv2.VideoWriter_fourcc('M', 'J', 'P', 'G'), fps, video_size) 
        detectflag = 0
        while cap.isOpened():
            # detectflag = detectflag + 1
            # if detectflag % 3 == 0:
            #     time.sleep(1)
            ret, frame = cap.read()
            
            if ret:   
                img = prep_image(frame, inp_dim)
        #        cv2.imshow("a", frame)
                im_dim = frame.shape[1], frame.shape[0]
                im_dim = torch.FloatTensor(im_dim).repeat(1,2)   
                            
                if CUDA:
                    im_dim = im_dim.cuda()
                    img = img.cuda()
                
                with torch.no_grad():
                    output = model(Variable(img, volatile = True), CUDA)
                output = write_results(output, confidence, num_classes, nms_conf = nms_thesh)


                if type(output) == int:
                    frames += 1
                    print("FPS of the video is {:5.4f}".format( frames / (time.time() - start)))
                    cv2.imshow("frame", frame)
                    key = cv2.waitKey(1)
                    if key & 0xFF == ord('q'):
                        break
                    continue
                
                im_dim = im_dim.repeat(output.size(0), 1)
                scaling_factor = torch.min(416/im_dim,1)[0].view(-1,1)
                
                output[:,[1,3]] -= (inp_dim - scaling_factor*im_dim[:,0].view(-1,1))/2
                output[:,[2,4]] -= (inp_dim - scaling_factor*im_dim[:,1].view(-1,1))/2
                
                output[:,1:5] /= scaling_factor

                for i in range(output.shape[0]):
                    output[i, [1,3]] = torch.clamp(output[i, [1,3]], 0.0, im_dim[i,0])
                    output[i, [2,4]] = torch.clamp(output[i, [2,4]], 0.0, im_dim[i,1])
            
                
                

                classes = load_classes('data/coco.names')
                colors = pkl.load(open("pallete", "rb"))

                
                count = 0
                list(map(lambda x: write(x, frame), output))
                # flag = flag + 1
                # if flag % 4 == 0:
                #     PeopleCount = count
                # if count > 3:
                #     print(count)
                font = cv2.FONT_HERSHEY_DUPLEX
                cv2.putText(frame, str(count), (50,100), font, 3, (0, 100, 0), 5)
                cv2.imshow("frame", frame)
                # process_image = cv2.fromarray(frame)
                # process_image = cv2.cvtColor(np.asarray(frame),cv2.COLOR_RGB2BGR)
                image = Image.fromarray(frame)
                image = image.resize((960, 540))
                process_image = np.array(image)
                global pipe
                pipe.stdin.write(process_image.tostring())
                output_movie.write(frame)
                key = cv2.waitKey(1)
                if key & 0xFF == ord('q'):
                    break
                frames += 1
                # print(time.time() - start)
                # print("FPS of the video is {:5.2f}".format( frames / (time.time() - start)))
            else:
                break    
        output_movie.release()
        cap.release()

detect_thread = detectThread()
detect_thread.start()

global pipe
pipe = sp.Popen(command, stdin=sp.PIPE)
push_thread = PushThread()
push_thread.start()







