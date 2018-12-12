<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link href="../../css/overall.css" rel="stylesheet" type="text/css" media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
<title>Waffles College Admin Portal</title>

<header>
<img src="../../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Admin Portal</h3>

</header>

<section>
<div class="col-container">
  <nav>
       <a href="ManageStudents.jsp" class="sidebar-button"><b>Manage Students</b></a>
       <a href="ManageLecturers.jsp" class="sidebar-button">Manage Lecturers</a>
       <a href="ManageCourses.jsp" class="sidebar-button">Manage Courses</a>
       <a href="ManageEnrolment.jsp" class="sidebar-button">Manage Enrolment</a>
       <a href="../main/MainPage.jsp" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/admin/managecourses/courses/edit/${course.cseId}">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="label.course.cseId" /> *</td>
				   <td><form:input path="Course ID"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.course.cseDesc" /></td>
				   <td><form:input path="Decription"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.course.cseCredit" /></td>
				   <td><form:input path="Credits"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.course.cseMaxSize" /></td>
				   <td><form:input path="Maximum Size"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.course.cseStartdate" /></td>
				   <td><form:input path="Course Start Date"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.course.cseStatus" /></td>
				   <td><form:input path="Course Status"/></td>
				 </tr>
				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace
  <i class='fas fa-phone'></i>  +65 6888 8888
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com
</footer>
