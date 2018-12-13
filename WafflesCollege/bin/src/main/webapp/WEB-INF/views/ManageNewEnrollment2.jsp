<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

  	 <br />
    <br />

   		 
   		 
   		 <form:form method="POST" modelAttribute="approve"
   	 action="${pageContext.request.contextPath}/admin/managenewenrollment/new/edit/${enrollment.enrId}.html">
   	 <table>
   		 <tr>
   			 <td><form:radiobutton path="decision" value="APPROVED" id="decision"/> <spring:message
   					 code="caption.approve" /> &nbsp;&nbsp; <form:radiobutton
   					 path="decision" value="REJECTED" id="decision" /> <spring:message
   					 code="caption.reject" /></td>
   		 </tr>
   		 <tr>
   			 <td><spring:message code="label.approveComment" /><br>
   				 <form:textarea path="comment" cols="60" rows="4" id="comment"/></td>
   		 </tr>
   	 </table>
   	 <form:button name="submit" type="submit" value="s">
   	 </form:button>
    </form:form>


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
