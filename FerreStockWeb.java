<page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Productos - FerreStock</title>
</head>
<body>
    <h2>Registro de Nuevo Producto</h2>
    <!-- Formulario utilizando el método POST para enviar datos al Servlet -->
    <form action="ProductoServlet" method="POST">
        <input type="hidden" name="accion" value="registrar">
        
        <label for="nombre">Nombre del Producto:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="precio">Precio:</label><br>
        <input type="number" step="0.01" id="precio" name="precio" required><br><br>

        <label for="stock">Stock Inicial:</label><br>
        <input type="number" id="stock" name="stock" required><br><br>

        <button type="submit">Guardar Producto</button>
    </form>

    <hr>

    <h2>Consultar Producto por ID (Método GET)</h2>
    <!-- Formulario utilizando el método GET -->
    <form action="ProductoServlet" method="GET">
        <input type="hidden" name="accion" value="buscar">
        <label for="id">ID del Producto:</label>
        <input type="number" id="id" name="id" required>
        <button type="submit">Buscar</button>
    </form>
</body>
</html>