<%@page import="javax.persistence.Tuple"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>

<% 
if (session.getAttribute("renderizarVista") == "index") {
	List<Object[]> productos = (List<Object[]>)session.getAttribute("productos");
%>
<h1>FindAllFK</h1>
	<h3>Permite buscar uno o varios registros en base a una condición, pero cambiando la clave foranea (Mostrar otra columna de la tabla agena, en lugar de su clave primaria), si no se entregan parámetros al método se muestran las claves primarias por defecto</h3>
	
	<form action="ProductoControlador" method="GET">
		<label for="columnaCategoria">Columna Tabla Categoria</label>
		<input type="text" name="columnaCategoria" placeholder="Por defecto es: id"/>
		<label for="columna">Columna</label>
		<select name="columna">
			<option value="id">ID</option>
			<option value="nombre">Nombre</option>
			<option value="descripcion">Descripcion</option>
			<option value="precio">Precio</option>
			<option value="stock">Stock</option>
			<option value="imagen">Imagen</option>
			<option value="categoriaFK">Categoria</option>
		</select>
		<label for="valor">Valor</label>
		<input type="text" name="valor" required/>
		<button name="opcion" value="1">Ejecutar Método</button>
	</form>
	
    <table border="1">
        <tr>
        	<th>ID</th>
        	<th>Nombre</th>
        	<th>Descripcion</th>
        	<th>Precio</th>
        	<th>Stock</th>
        	<th>Imagen</th>
        	<th>Categoria</th>
        </tr>
        
	    <c:forEach items="${productos}" var="p">
		    <tr>
		    	<td>${p[0]}</td>
		    	<td>${p[1]}</td>
		    	<td>${p[2]}</td>
		    	<td>${p[3]}</td>
		    	<td>${p[4]}</td>
		    	<td>${p[5]}</td>
		    	<td>${p[6]}</td>
		    </tr>
		</c:forEach>
	</table>
<%
	session.removeAttribute("renderizarVista");
	session.removeAttribute("productos");
}
else {
	response.sendRedirect(request.getContextPath() + "/ProductoControlador?vista=index");
}
%>	
</body>
</html>