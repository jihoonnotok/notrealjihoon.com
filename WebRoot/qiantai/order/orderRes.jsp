<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 


<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/qiantai.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/list-ui7.css" media="all"/>
	
	<style rel="stylesheet" type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
	
    <script type="text/javascript">
    </script>
    
  </head>
  
  <body>
	<div id="header-wrap">
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
	</div>
				
	<div id="content-wrap">
		<div id="content">	 
		    <div id="main">		
				<!-- 111 -->
				<!-- <h1>企业介绍</h1> -->
	            <p>
		                     <c:if test="${fn:length(orderList)==0}">
				                              您输入的订单号不存在，请重新输入
			                 </c:if>
			                 <c:if test="${fn:length(orderList) !=0}">
			                       <c:forEach items="${orderList}" var="order" varStatus="ss">
			                        <table width="98%" align="center" border="0" cellpadding="8" cellspacing="" bgcolor="#CBD8AC" style="margin-bottom:8px">
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         订单编号：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="danhao" size="50" value="${order.danhao }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物类型：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huoleixing" size="50" value="${order.huoleixing }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物名称：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huomingcheng" size="50" value="${order.huomingcheng }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物重量：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huozhong" size="50" value="${order.huozhong }"/>(KG)
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人姓名：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jixingming" size="50" value="${order.jixingming }"/> 
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人电话：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jidianhua" size="50" value="${order.jidianhua }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人地址：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jidizhi" size="50" value="${order.jidizhi }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人姓名：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shouxingming" size="50" value="${order.shouxingming }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人电话：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shoudianhua" size="50" value="${order.shoudianhua }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人地址：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shoudizhi" size="50" value="${order.shoudizhi }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         回单信息：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shoudizhi" size="50" value="${order.songhuoyuanHuidan }"/>
										    </td>
										</tr>
								    </table>
								    </c:forEach>
			                 </c:if>
	            </p>
	            <!-- 111 -->
			</div>
			<div id="sidebar">	
				<jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
			</div>			
		</div>
	</div>

	<div style="height: 10px;">
	    <br/><a style="color: white;" href="<%=path %>/login.jsp">系统后台</a>
	</div>
</body>
</html>
