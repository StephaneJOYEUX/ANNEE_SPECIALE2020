<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OK</title>
</head>
<body>
	BIENVENUE
	<br>
	<s:text name="clientConnecte.nom"></s:text>
	/
	<s:text name="clientConnecte.prenom"></s:text>
	/
	<s:text name="clientConnecte.adresse"></s:text>
	<br>
	<s:text name="message"></s:text>
	<br>
	<br> Voici les comptes du client :
	<br>
	<table border="1px solid black">
		<s:iterator value="clientConnecte.comptes">
			<tr>
				<td><s:text name="numCompte"></s:text></td>
				<td><s:text name="solde"></s:text></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>