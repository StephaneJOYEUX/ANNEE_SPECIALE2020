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
	<s:if test="listeComptesOk">
		<br> Voici les comptes du client :
	<br>
		<table border="1px solid black">
			<s:iterator value="comptesClient">
				<tr>
					<td><s:text name="numCompte"></s:text></td>
					<td><s:text name="solde"></s:text></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>
	BIENVENUE DANS LA BANQUE
	<br>
		<s:text name="clientConnecte.nom"></s:text>
	/
	<s:text name="clientConnecte.prenom"></s:text>
	/
	<s:text name="clientConnecte.adresse"></s:text>
		<br>
		<br>
		<b><s:text name="message"></s:text></b>
		<br>

		<s:form name="myFormCompte" action="listeComptes" method="POST">
			<!-- Passage de la variable numeroClient dans le POST du formulaire qui contient le numéro du client -->
			<s:hidden name="numeroClient" value="%{clientConnecte.numeroClient}" />
			<!--<s:hidden name="client" value = "%{clientConnecte}"/>-->
			<s:submit name="Comptes" value="Voir la liste des comptes" />
		</s:form>
	</s:else>
</body>
</html>