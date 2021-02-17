<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  
  <c:if test="${sessionScope.userType==0}">
  <body>
        <P class="menu_head" style="font-size: 15px;">修改个人密码</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A  href="<%=path %>/admin/userinfo/userPw.jsp" target="main">修改个人密码</A> 
	    </DIV>
	    
	    
	    <P class="menu_head" style="font-size: 15px;">系统公告管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/admin/gonggao/gonggaoAdd.jsp" target="main">添加系统公告</A> 
			<A href="<%=path %>/gonggaoMana.action" target="main">系统公告管理</A> 
	    </DIV>
	    
	    
	    <P class="menu_head" style="font-size: 15px;">员工信息管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/songhuoyuanMana.action" target="main">员工信息管理</A> 
			<A href="<%=path %>/admin/songhuoyuan/songhuoyuanAdd.jsp" target="main">添加员工信息</A> 
	    </DIV>
	    
	    
	    
	    
	    
	    <P class="menu_head" style="font-size: 15px;">业务信息管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/orderMana.action" target="main">业务信息管理</A> 
			<A href="<%=path %>/admin/order/orderAdd.jsp" target="main">录入业务信息</A> 
	    </DIV>
	    
	    
	    
	    <P class="menu_head" style="font-size: 15px;">友情连接管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/lianjieMana.action" target="main">友情连接管理</A> 
			<A href="<%=path %>/admin/lianjie/lianjieAdd.jsp" target="main">添加友情连接</A> 
	    </DIV>
	    
	    
	    
	    <P class="menu_head" style="font-size: 15px;">客户服务管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/liuyanMana.action" target="main">客户服务管理</A> 
	    </DIV>
	    
	    
	    
	    <P class="menu_head" style="font-size: 15px;">注册信息管理</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/userMana.action" target="main">注册信息管理</A> 
	    </DIV>
	       
  </body>
  </c:if>
  
  
  
  
  
  
  
  
  
  
  
  <c:if test="${sessionScope.userType==1}">
  <body>
	    
  </body>
  </c:if>
  
  
  
  
  
  
  <c:if test="${sessionScope.userType==2}">
        <P class="menu_head" style="font-size: 15px;">修改我的信息</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A  href="<%=path %>/admin/userinfo/songhuoyuaninfo.jsp" target="main">修改我的信息</A> 
	    </DIV>
	    
	    
	    <P class="menu_head" style="font-size: 15px;">浏览我的任务</P>
		<DIV style="DISPLAY: none" class=menu_body>
			<A href="<%=path %>/orderMana_songhuoyuan.action" target="main">浏览我的任务</A> 
	    </DIV>
  </c:if>
</html>
