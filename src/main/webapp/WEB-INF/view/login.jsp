<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("path", path);
//System.out.println("basepath");
//System.out.println(basepath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<h2>这是单点登录页面!</h2>

<%--     <form>
        <input type="hidden" id="ctx" value="${path}" />
        <span>用户名：</span><input id="username_input" type="text" name="username" value="user"/>
        <span>密    码：</span><input id="password_input" type="password" name="password" value="123"/>
        <input id="login_button" type="button" value="登录">
    </form> --%>
    
    <form target="dataIframe" action="${path}/doLogin" enctype="multipart/form-data" method="post">
        <span>用户名：</span><input id="username_input" type="text" name="username" value="user"/>
        <span>密    码：</span><input id="password_input" type="password" name="password" value="123"/>
        <span>文    件：<input type="file" name="uploadFile"></span>
        <input id="login_button" type="submit" value="登录">
        <iframe name="dataIframe" id="dataIframe" style="display:none"></iframe>
    </form>    
       
</body>
<script type="text/javascript" src="${ path }/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ path }/static/js/jquery.cookie.js"></script>
<script type="text/javascript">
/**
 * 登录js
 */
$(function(){
/* 	console.log($("#ctx"));
    var ctx = $("#ctx").val(); */
    $("#login_button").click(function(){
        //login();
    });
    
/*     $("#dataIframe").load(function(){

    		console.log(2354567);
    	      var text = $(this).contents().find("body").text();      //获取到的是json的字符串

    	     var j = $.parseJSON(text);                                         //json字符串转换成json对象

    	     console.log(j)

    	})  */ 
    	
	$("#dataIframe").on("load", function(){
		var text = $(this).contents().find("body").text();      //获取到的是json的字符串
		
		var j = JSON.parse(text);                                         //json字符串转换成json对象
		
		console.log(j)
	});
});

function login(){
    // 获取登录信息
    var username=$("#username_input").val();
    var password=$("#password_input").val();
    var contextpath = $("#ctx").val();
    
    var requesturl=contextpath+"/doLogin";
    $.ajax({
        type:"POST",
        async:true,
        url:requesturl,
        //data:"username="+username+"&password="+password,
        data:{username:username, password:password},
        success:function(result){
			console.log("success");
			console.log(result);
        },
        error:function(error){
        	console.log("error");
        	console.log(error);
        }
    });
}
</script>
</html>