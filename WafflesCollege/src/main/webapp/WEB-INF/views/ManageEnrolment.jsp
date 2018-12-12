<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <p>
    <a href="${pageContext.request.contextPath}/admin/manageenrolment/create">Add
	Student</a>
<c:if test="${fn:length(students) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.student.index" /></th>
			<th><s:message code="label.student.name" /></th>
			<th><s:message code="label.student.nickName" /></th>
			<th><s:message code="label.student.nric" /></th>
			<th><s:message code="label.student.mark" /></th>

		</tr>
		<c:forEach var="enrollment" items="${enrollments}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${enrollment.enrStatus}</td>
				<td class="nowrap">${enrollment.course.cseDesc}</td>
				<td class="nowrap">${enrollment.student.stuLastname}</td>
				<td class="nowrap"><fmt:formatDate value="${student.enrDate}" pattern="MM.dd.yyyy" /></td>

				<td align="center"><a
					href="${pageContext.request.contextPath}/admin/manageenrolment/edit/${enrollment.enrId}">
						<s:message code="label.student.edit" />
				</a></td>
				

			</tr>
		</c:forEach>
	</table>
</c:if>
    </p>

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