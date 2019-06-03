<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${requestScope.test}

<a id="number">0</a>
<a id="cg2"></a>
<script src="./vendor/jquery/jquery.min.js"></script>
<script>
function reloadView(x) {
	 $.ajax({
         type: 'GET', // 请求类型, 默认为 GET
         url: "PeopleCount", // 	必需。规定把请求发送到哪个 URL。
         //data: "info="+value, // 可选。映射或字符串值。规定连同请求发送到服务器的数据。
         success: function(result){ // 可选。请求成功时执行的回调函数。
             // 展示结果
             $("#number").html(result);
         }
     });
};
        setInterval('reloadView()', 200);
        
</script>
</body>
</html>