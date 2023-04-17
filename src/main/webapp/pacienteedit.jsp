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
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Gestión de Pacientes</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Pacientes</a></li>
			</ul>
		</nav>
	</header>
	<br>
<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<c:if test="${usuario != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${usuario == null}">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${usuario != null}">
							Editar Paciente
						</c:if>
						<c:if test="${usuario == null}">
							Agregar Nuevo Paciente
						</c:if>
					</h2>
				</caption>
				<c:if test="${paciente != null}">
					<input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Nombre de Paciente</label> <input type="text" value="<c:out value='${paciente.nombre}'/>" class="form-control" name="nombre" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Apellido del Paciente</label> <input type="text" value="<c:out value='${paciente.email}'/>" class="form-control" name="apellido">
				</fieldset>
				<fieldset class="form-group">
					<label>Documento del Paciente</label> <input type="text" value="<c:out value='${paciente.pais}'/>" class="form-control" name="documento">
				</fieldset>
				<fieldset class="form-group">
					<label>Email del Paciente</label> <input type="text" value="<c:out value='${paciente.nota1}'/>" class="form-control" name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Genero del Paciente</label> <input type="text" value="<c:out value='${paciente.nota2}'/>" class="form-control" name="genero">
				</fieldset>
				<fieldset class="form-group">
					<label>Fecha nacimiento de Paciente</label> <input type="text" value="<c:out value='${paciente.nombre}'/>" class="form-control" name="fechanacimiento">
				</fieldset>
				<fieldset class="form-group">
					<label>Direccion del Paciente</label> <input type="text" value="<c:out value='${paciente.email}'/>" class="form-control" name="direccion">
				</fieldset>
				<fieldset class="form-group">
					<label>Telefono del Paciente</label> <input type="text" value="<c:out value='${paciente.pais}'/>" class="form-control" name="telefono">
				</fieldset>
				<fieldset class="form-group">
					<label>Peso del Paciente</label> <input type="text" value="<c:out value='${paciente.nota1}'/>" class="form-control" name="peso">
				</fieldset>
				<fieldset class="form-group">
					<label>Estatura del Paciente</label> <input type="text" value="<c:out value='${paciente.nota2}'/>" class="form-control" name="estatura">
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
			</div>
		</div>
	</div>
</body>
</html>