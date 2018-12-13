<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<title>Waffles College Online Portal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="../../css/overall.css" rel="stylesheet" type="text/css" media="all" /> -->
</head>
<body>
<header>

<h3>Waffles College Online Portal</h3>
</header>

<section>
<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/Login" > 
	<table class="framed" >
		<tr>
			<td>
			<spring:message code="fieldLabel.username" /></td>
			<td colspan="3"><form:input path="useId" size="40" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.password" /></td>
			<td colspan="3"><form:password path="usePassword" size="40" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<form:button name="submit" type="submit" value="s">
					<img src="${pageContext.request.contextPath}/image/button_login.gif" alt="" align="middle">
				</form:button></td>
			<td>
			<form:button name="clear" type="reset" value="r">
					<img src="${pageContext.request.contextPath}/image/button_clear.gif" alt="" align="middle">
				</form:button>
				</td>
		</tr>
	</table>
</form:form>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace</br>
  <i class='fas fa-phone'></i>  +65 6888 8888</br>
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com</br>
</footer>

</body>
</html>
