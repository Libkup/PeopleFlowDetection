# People Flow Detection

## Introduction

We used Yolov3 to compute the number of people. 

If the number is beyond threshold, the program will transfer the data to our center platform and make a warning. The data includes the number of people as well as the video.

Our users can have access to the system through their browser.

## Install

### Requirements

#### Cloud
##### jdk 1.8
##### tomcat 8.0
##### mariadb-java-client-2.2.6.jar

#### Edge
##### python 3.6
##### torch 0.4
##### cuda 9.0(not necessary)
##### opencv (latest version)
##### some other python libs can see in import

#### Other
##### ffmpeg
##### nginx-rtmp
##### MariaDB DataBase
