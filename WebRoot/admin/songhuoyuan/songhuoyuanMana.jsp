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
           function songhuoyuanDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/songhuoyuanDel.action?id="+id;
               }
           }
           
           function songhuoyuanAdd()
           {
                 var url="<%=path %>/admin/songhuoyuan/songhuoyuanAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
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
					
					<td width="15%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.songhuoyuanList}" var="songhuoyuan" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${songhuoyuan.name}
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
					
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="songhuoyuanDel(${songhuoyuan.id})" />
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加员工信息" style="width: 120px;" onclick="songhuoyuanAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
