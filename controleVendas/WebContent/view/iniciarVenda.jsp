<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>
<jsp:useBean id="produto" class="br.com.ifpe.vendas.model.Cliente" />


<jsp:useBean id="dao" class="br.com.ifpe.vendas.model.ClienteDAO" />


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="inciarVenda" method="POST">
		<table border='1'>
			<tr>

				<td>Nome</td>

			</tr>
			<c:forEach var="cliente" items="${dao.listar()}">

			<tr>
				<td>${produto.nome}</td>
				
				<input type='radio' name='iniciar' value='Prosseguir'> <input
							type='submit' value="Prosseguir">
			</tr>
</c:forEach>
		</table>


	</form>




</body>
</html>