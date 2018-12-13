<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.5.0/css/all.css'
	integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU'
	crossorigin='anonymous'>
<link href="../../css/overall.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Waffles College Admin Portal</title>
</head>
<body>


	<header>
		<img src="../../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h3>Waffles College Admin Portal</h3>

	</header>

	<section>
		<div class="col-container">
			<nav>
				<a href="ManageStudents.jsp" class="sidebar-button">Manage
					Students</a> <a href="ManageLecturers.jsp" class="sidebar-button">Manage
					Lecturers</a> <a href="ManageCourses.jsp" class="sidebar-button">Manage
					Courses</a> <a href="ManageEnrolment.jsp" class="sidebar-button"><b>Manage
						Enrolment</b></a> <a href="../main/MainPage.jsp" class="sidebar-button">Log
					Out</a>
			</nav>

			<article>
				<h1>Manage Enrollment</h1>

				<h1>This is new Enrollment page</h1>


				<form:form method="POST" modelAttribute="enrollment"
					action="${pageContext.request.contextPath}/admin/manageenrollment/edit/${enrollmentId}">
					<table>
						<tbody>
							<tr>
								<td>Enrollment ID:</td>
								<td><form:input path="enrId" size="10" readonly="true" /></td>
								<td><form:errors path="enrId" cssStyle="color: red;" /></td>
							</tr>
							<tr>

								<td>Enrollment Date:</td>
								<td><form:input size="10" path="enrDate" readonly="true"  />
									<form:errors path="enrDate" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Enrollment Status:</td>
								<td><form:select path="enrStatus" items="${statuslist}"
										size="10" /></td>
								<td><form:errors path="enrStatus" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Course ID:</td>
								<td><form:input path="course.cseId" 
										size="10" readonly="true"/></td>
								<td><form:errors path="course.cseId" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Student ID:</td>
								<td><form:input path="student.stuId" 
										size="10" readonly="true"/></td>
								<td><form:errors path="student.stuId"
										cssStyle="color: red;" /></td>
							</tr>

							<tr>
								<td><form:button name="submit" type="submit" value="submit">

									</form:button></td>
								<form:button name="clear" type="reset" value="clear">

								</form:button>
								</td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form:form>

			</article>
		</div>
	</section>

	<footer>
		<p>Contact Us:</p>
		<i class='fas fa-school'></i> 88 Keng Mui Heng Terrace</br> <i
			class='fas fa-phone'></i> +65 6888 8888</br> <i class='fas fa-envelope'></i>
		hello@wafflescollege.com</br>
	</footer>

</body>
</html>