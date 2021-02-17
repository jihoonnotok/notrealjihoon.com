<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
            function a(id,name)
            {
                 document.getElementById("songhuoyuanId").value=id;
                 document.ff.submit();
            }
        </script>
	</head>

	<body style="margin: 0px;">
		 <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="41" background="<%=path %>/img/tbg.gif" align="center" style="color: red;font-family: 微软雅黑">点击姓名即可选择</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="4%">序号</td>
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">年龄</td>
					
					<td width="15%">电话</td>
					<td width="10%">住址</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
		        </tr>	
				<c:forEach items="${requestScope.songhuoyuanList}" var="songhuoyuan" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="a('${songhuoyuan.id}','${songhuoyuan.name}')" style="color: green;font-family: 微软雅黑;font-size: 15px;">${songhuoyuan.name}</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${songhuoyuan.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${songhuoyuan.age}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${songhuoyuan.tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${songhuoyuan.address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${songhuoyuan.loginname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${songhuoyuan.loginpw}
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
			<form action="<%=path %>/songhuoyuanFenpai.action" name="ff" method="post">
			     <input type="hidden" name="id" value="<%=request.getParameter("id") %>"/>
			     <input type="hidden" name="songhuoyuanId" value=""/>
			</form>
	</body>
</html>
