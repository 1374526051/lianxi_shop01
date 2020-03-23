<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="./网上商城/index.htm">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="积云集团" width="180" height="65"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
			    <c:if test="${user==null }">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user/loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user/registPage.action">注册</a>|
					</li>
			    </c:if>
			    <c:if test="${user!=null }">
					<li id="headerUsername">
						<font color="red">欢迎会员-${user.username }</font>
					</li>
					<li id="headerLogout">
						<a href="${pageContext.request.contextPath }/user/exit.action">[退出]</a>|
					</li>
				</c:if>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="./购物车.htm">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath }/index.action">首页</a>
						|
					</li>
				<c:forEach var="c" items="${clist }">
				
					<li>
						<a href="${pageContext.request.contextPath }/product/findProductByCid.action?cid=${c.cid}">${c.cname }</a>
						|
					</li>
				</c:forEach>
		</ul>
	</div>


</div>
</body>
</html>