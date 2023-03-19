<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>
			Customer Confirmation
		</title>
	</head>
	<body>
		The customer is confirmed: 
		<br/>
		Firstname: ${customer.firstName }
		<br/>
		Lastname: ${customer.lastName }
		<br/>
		Freepass: ${customer.freePasses }
		<br/>
		PostalCode: ${customer.postalCode }
	</body>
</html>