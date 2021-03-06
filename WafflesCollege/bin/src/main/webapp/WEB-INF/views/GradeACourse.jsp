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
<title>Waffles College Lecturer Portal</title>
</head>
<body>


	<header>
		<img src="../../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h3>Waffles College Lecturer Portal</h3>

	</header>

	<section>
		<div class="col-container">
			<nav>
				<a href="ViewCoursesTaught.jsp" class="sidebar-button">View
					Courses Taught</a> <a href="ViewCourseeErolment.jsp"
					class="sidebar-button">View Course Enrollment</a> <a
					href="GradeACourse.jsp" class="sidebar-button"><b>Grade a
						Course</b></a> <a href="ViewAStudentPerformance.jsp"
					class="sidebar-button">View a Student Performance</a> <a
					href="../main/MainPage.jsp" class="sidebar-button">Log Out</a>
			</nav>

			<article>
				<h1>Grade a Student under Course ${cseId}</h1>
				<table>
					<tbody>

						<tr>

							<td>Studentgrade ID: </td>
							<td><form:input size="16" path="stgId" readonly="true" value= "${stgId}" />
								<form:errors path="stgId" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td>Student ID: </td>
							<td><form:input disabled="true" size="10" path="student.stuId" readonly="true"
									value= "${studentgrade.student.stuId}" /></td>
							<td><form:errors path="student.stuId" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td>Student First Name: </td>
							<td><form:input path="student.stuFirstmidname" readonly="true"
									value= "${studentgrade.student.stuFirstmidname}"
									size="10" /></td>
							<td><form:errors path="student.stuFirstmidname" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td>Student Last Name: </td>
							<td><form:input path="student.stuLastname" readonly="true"
									value= "${studentgrade.student.stuFirstmidname}"
									size="10" /></td>
							<td><form:errors path="student.stuLastname" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td>Course ID: </td>
							<td><form:input path="course.cseId" readonly="true"
									value= "${studentgrade.student.stuFirstmidname}"
									size="10" /></td>
							<td><form:errors path="course.cseId" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td>Course Name: </td>
							<td><form:input path="course.cseDesc" readonly="true"
									value= "${studentgrade.course.cseDesc}"
									size="10" /></td>
							<td><form:errors path="course.cseDesc" cssStyle="color: red;" /></td>
						</tr>
	                    <tr>
							<td>Course Grade: </td>
							<td><form:select path="stgGrade" items="${sidlist}"
									size="10" /></td>
							<td><form:errors path="stgGrade" cssStyle="color: red;" /></td>
						</tr>
						<tr>
							<td><form:button name="submit" type="submit" value="Submit">

								</form:button></td>
							<form:button name="clear" type="reset" value="Reset">

							</form:button>
							</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>

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
