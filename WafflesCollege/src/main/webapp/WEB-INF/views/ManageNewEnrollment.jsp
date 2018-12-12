<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link href="../../css/overall.css" rel="stylesheet" type="text/css" media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
<title>Waffles College Admin Portal</title>
</head>
<body>


<header>
<img src="../../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Admin Portal</h3>

</header>

<section>
<div class="col-container">
  <nav>
       <a href="ManageStudents.jsp" class="sidebar-button">Manage Students</a>
       <a href="ManageLecturers.jsp" class="sidebar-button">Manage Lecturers</a>
       <a href="ManageCourses.jsp" class="sidebar-button">Manage Courses</a>
       <a href="ManageEnrolment.jsp" class="sidebar-button"><b>Manage Enrolment</b></a>
       <a href="../main/MainPage.jsp" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
    <h1>Manage Enrollment</h1>
    <p>Codes go here.</p>
    <c:forEach var="enrollment" items="${pageContext.request.contextPath}">
		<c:if test="${fn:length(entry.value) gt 0}">
			<spring:message code="fieldLabel.name" /> : <c:out
				value="${entry.key.name}" />
			<br />
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr>
					<th><spring:message code="fieldLabel.enrollment.enrId" /></th>
					<th><spring:message code="fieldLabel.enrollment.student" /></th>
					<th><spring:message code="fieldLabel.enrollment.course" /></th>
					<th><spring:message code="fieldLabel.enrollment.enrDate" /></th>
					<th><spring:message code="fieldLabel.enrollment.enrStatus" /></th>

				</tr>
				<c:forEach var="enrollment" items="${enrollment}" varStatus="status">
					<tr>
						<td>${enrollment.enrId}</td>
						<td>${enrollment.student}</td>
						<td>${enrollment.course}</td>
						<td>${enrollment.enrDate}</td>
						<td>${enrollment.enrStatus}</td>

					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:forEach>

   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace</br>
  <i class='fas fa-phone'></i>  +65 6888 8888</br>
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com</br>
</footer>

</body>
</html>
