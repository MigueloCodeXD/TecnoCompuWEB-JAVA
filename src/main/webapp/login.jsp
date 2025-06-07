<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TecnoCompu - Iniciar Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"
</head>
<body>
    <div class="container">
        <div class="form-card">
            <h1>Iniciar Sesión</h1>
            <img src="https://placehold.co/100x100/8A2BE2/FFFFFF?text=TC" alt="Logo TecnoCompu" class="logo">
            
            <%-- Mostrar mensajes de error o éxito --%>
            <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% String successMessage = (String) request.getAttribute("successMessage"); %>
            
            <% if (errorMessage != null) { %>
                <div class="message error-message">
                    <%= errorMessage %>
                </div>
            <% } %>
            <% if (successMessage != null) { %>
                <div class="message success-message">
                    <%= successMessage %>
                </div>
            <% } %>

            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Usuario:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
            </form>
            <p class="form-link">¿No tienes una cuenta? <a href="register.jsp">Regístrate aquí</a></p>
        </div>
    </div>
</body>
</html>
