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
     <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
      
     <script type="text/javascript">
         function userReg()
         {
                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
                var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
         }
        
         
         function userLogout()
         {
            document.getElementById("indicator11").style.display="block";
            loginService.userLogout(callback123);
         }
         function callback123(data)
		 {
		    document.getElementById("indicator11").style.display="none";
		    if(data=="no")
		    {
		        alert("系统错误，请联系管理员");
		    }
		    if(data=="yes")
		    {   
		        alert("安全退出系统");
		        var url="<%=path %>/qiantai/default.jsp";
		        window.location.href=url;
		    }
		 }
      </script>
  </head>
  
  <body>
        <div id="header-content">
            <br/><br/><br/>
			<span style="font-size: 21px;color: #FFF;font-family: 微软雅黑;">物流快递管理系统</span>	
			<ul>
				<li><a href="<%=path %>/gonggaoAll.action" style="font-family: 微软雅黑;">系统公告</a></li>
				<li><a href="<%=path %>/qiantai/order/orderSea.jsp" style="font-family: 微软雅黑;">物流信息查询</a></li>
				<li><a href="#" onclick="userReg()" style="font-family: 微软雅黑;">注册用户</a></li>
				<li><a href="<%= path%>/liuyanAll.action" style="font-family: 微软雅黑;">客户服务</a></li>
				
				<c:if test="${sessionScope.userType !=1}">
				<li><a href="<%= path%>/qiantai/userinfo/userLogin.jsp" style="font-family: 微软雅黑;">用户登陆</a></li>
				</c:if>
				
				<c:if test="${sessionScope.userType ==1}">
				<li><a href="#" style="font-family: 微软雅黑;">欢迎您：${sessionScope.user.userName}</a></li>
				<li><a href="#" style="font-family: 微软雅黑;" onclick="userLogout()">注销退出</a><img id="indicator11" src="<%=path %>/img/loading.gif" style="display:none"/></li>
				</c:if>
			</ul>					
		</div>
  </body>
</html>
