<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Registration</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<c:url var="rcss" value="resources/css"></c:url>
<c:url var="rimages" value="resources/images"></c:url>

<form:errors path ="user.*"></form:errors>
<%-- <c:if test="${msg != null}">
	<div class="alert col-md-offset-3 col-md-6 alert-info text-center">
  		 <c:out value="${msg }"></c:out>
	</div>
	<div class="alert col-md-offset-3 col-md-6 alert-danger text-center">
	  		 
	</div>

</c:if> --%>

<div class="col-sm-12 text-center" >
	<span id="message"></span>
</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center"><spring:message code='label.header'></spring:message></h2>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" method="post" action="registerationform" onsubmit="return(check())">
							<div class="form-group">

								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">  <spring:message code='label.name'></spring:message> </label>
								<div class="col-sm-10">
									<input type="text" placeholder="Enter Your Name" name="name"
										required="true" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message code='label.email'></spring:message> </label>
								<div class="col-sm-10">
									<input type="email" class="form-control"
										placeholder="Enter Your Email" required="true" name="email"
										id="inputPassword3" />
								</div>
							</div>


							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message code='label.username'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Enter Your Username" required="true"
										name="username" id="inputPassword3" />
								</div>
							</div>

							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message code='label.password'></spring:message></label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										placeholder="Enter Your password" required="true"
										name="password" id="password" />
								</div>
							</div>

							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message code='label.password'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										placeholder="Enter Your password Again" required="true"
										name="cpassword" id="confirmpassword" />
								</div>
							</div>







							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message code='label.contact'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="number" pattern="[7-9]{1}[0-9]{9}"
										class="form-control" placeholder="Enter Your Contact"
										required="true" name="contact" id="inputPassword3" />
								</div>
							</div>


							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 la">
									<spring:message code='label.dob'></spring:message>
									 </label>
								<div class="col-sm-10">
									<input type="date" class="form-control" required="true"
										name="dob" id="inputPassword3" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">  <spring:message code='label.address'></spring:message> </label>
								<div class="col-sm-10">
									<input type="text" placeholder="Please Enter Complete Address" name="address.address"
										required="true" class="form-control" id="inputEmail3" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">  <spring:message code='label.address.city'></spring:message> </label>
								<div class="col-sm-10">
									<input type="text" placeholder="Enter Your City" name="address.city"
										required="true" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">   <spring:message code='label.address.country'></spring:message>  </label>
								<div class="col-sm-10">
									<input type="text" placeholder="Enter Your Country" name="address.country"
										required="true" class="form-control" id="inputEmail3" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">   <spring:message code='label.address.pin'></spring:message>  </label>
								<div class="col-sm-10">
									<input type="number" placeholder="Enter Your Pin" name="address.pin"
										required="true" class="form-control" id="inputEmail3" />
								</div>
							</div>
							
							
							

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">

									<button type="submit" class="btn btn-success">
										<i class="fa fa-address-book fa-lg fa-2x"></i> &nbsp;
										Register
									</button>
								</div>


							</div>

							<div class="form-group"></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


	<script>
	var check = function() {
  if (document.getElementById('password').value == document.getElementById('confirmpassword').value) {
  document.getElementById('message').style.color = 'green';
  document.getElementById('message').innerHTML = 'Passwords Matched';
    return true;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Password Not matching';
    return false;
  }
}
	</script>
</body>
</html>