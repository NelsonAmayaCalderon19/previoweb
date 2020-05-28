<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" href="img/icono.png" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">   
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css">
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
                
        <!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
--><script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>  
<script src="js/mensajesjs.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/css/alertify.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/alertify.min.js"></script>   

<title>Listado de Mensajes</title>
  <link href="css/styles_mensajes.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img src="https://ww2.ufps.edu.co/public/archivos/elementos_corporativos/logo-horizontal.jpg" width="120px;" height="40px;"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
   
      
      <li class="nav-item">
        <a class="nav-link" href="carreraedit.jsp">Registrar_Mensaje</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
     <ul class="navbar-nav mr-auto">
      <a href="index.jsp" class="btn btn-danger"  id="volver">Cerrar Sesión</a>
      
    </ul>
    </form>
  </div>
</nav>
<h1>Listado de Mensajes</h1>
<jsp:useBean id="mDao" class="mensajeJPA.dao.MensajeDao" scope="request" />
<table id="minhatabela" class="display responsive table table-striped table-bordered table-hover" cellspacing="0" width="100%">
<thead>
<tr>
<th class="text-center">Nombre</th>
<th class="text-center">Email</th>
<th class="text-center">Mensaje</th>
<th class="text-center">Accion</th>
</tr>
</thead>
<tbody>
<c:forEach var="m" items="${mDao.list()}">
<tr>
<td><c:out value = "${m.nombre}"/></td>
<td><c:out value = "${m.email}"/></td>
<td><c:out value = "${m.mensaje}"/></td>

<td>
<a class="btn btn-warning" href="MensajeController?accion=editar&id=${m.id}"><span class="fa fa-pencil-square-o" style="color: white;"></span></a>
<a class="btn btn-danger" href="MensajeController?accion=eliminar&id=${m.id}"><span class="fa fa-minus-circle" style="color: white;"></span></a></td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>