<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyBank</title>
</head>
<body>
	Bienvenu dans la banque de l'IUT de METZ :
	<h1>Login :</h1>
	<s:form name="myForm"
		action="controller.LoginController.connection.action" method="POST">
		<s:textfield label="Code user" name="userCde" />
		<s:password label="Password" name="userPwd" />
		<s:submit name="submit" />
	</s:form>
	<s:form name="myFormRetour" action="retourAccueil" method="POST">
		<s:submit name="Retour" value="Retour à l'accueil" />
	</s:form>
</body>
</html>
