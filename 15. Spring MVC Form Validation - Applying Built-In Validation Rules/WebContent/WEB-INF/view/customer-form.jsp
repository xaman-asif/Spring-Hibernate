<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>
			Customer Registration Form
		</title>
		<style>
			.error {
				color:red
			}
		</style>
		
	</head>
	<body>
		<form:form action="processForm" modelAttribute="customer">
			First name: <form:input path="firstName"/>
			<form:errors path="firstName" cssClass="error"/>
			<br/>
			Last name: <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			<br/>
			Free passes: <form:input path="freePasses"/>
			<form:errors path="freePasses" cssClass="error"/>
			<br/>
			<input type="submit" value="Submit" />
			
		</form:form>
	</body>
</html>