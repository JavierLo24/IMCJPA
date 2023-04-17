<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicacion Gestión de Pacientes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
	<nav class"navbar navbar-expand-md navbar-dark">
		<div>
			<a href="#" class="navbar-brand">Gestión de Pacientes</a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Lista de Pacientes</a></li>
		</ul>
	</nav>
	</header>
	<br/>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Pacientes</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Paciente</a>
			</div>
			<br>
			<table class="table table-bordered">
			<jsp:useBean id="pDao" class="services.PacienteDao" scope="request">
		</jsp:useBean>

				<thead>
					<tr>
						<th>ID</th>
						<th>Documento</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Email</th>
						<th>Genero</th>
						<th>Fecha de Nacimiento</th>
						<th>Direccion</th>
						<th>Peso</th>
						<th>Estatura</th>
						<th>IMC</th>
						<th>Estado</th>
						<th>Acciones</th>
					<tr/>
				</thead>
				<tbody>
					<c:forEach var="paciente" items="${pDao.list()}">
						<tr>
							<td>
								<c:out value="${paciente.id}"/>
							</td>
							<td>
								<c:out value="${paciente.documento}"/>
							</td>
							<td>
								<c:out value="${paciente.nombre}"/>
							</td>
							<td>
								<c:out value="${paciente.apellido}"/>
							</td>
							<td>
								<c:out value="${paciente.email}"/>
							</td>
							<td>
								<c:out value="${paciente.genero}"/>
							</td>
							<td>
								<c:out value="${paciente.fechanacimiento}"/>
							</td>
							<td>
								<c:out value="${paciente.direccion}"/>
							</td>
							<td>
								<c:out value="${paciente.peso}"/>
							</td>
							<td>
								<c:out value="${paciente.estatura}"/>
							</td>
							<td>
								<c:out value="${paciente.imc}"/>
							</td>
							<td>
								<c:out value="${paciente.estado}"/>
							</td>
							<td> <a href="<%=request.getContextPath()%>/edit?id=${paciente.id}">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value='${paciente.id}'/>">Borrar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="imc?id=<c:out value='${paciente.id}'/>">Calcular IMC</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
