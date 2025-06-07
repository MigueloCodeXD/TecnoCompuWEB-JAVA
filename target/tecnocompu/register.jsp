<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TecnoCompu - Registro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <div class="form-card">
            <h1>Registrarse</h1>
            <img src="https://placehold.co/100x100/8A2BE2/FFFFFF?text=TC" alt="Logo TecnoCompu" class="logo">
            
            <%-- Mostrar mensajes de error --%>
            <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <div class="message error-message">
                    <%= errorMessage %>
                </div>
            <% } %>

            <form action="register" method="post">
                <div class="form-group">
                    <label for="username">Usuario:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirmar Contraseña:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>
                <div class="form-group">
                    <label for="fullName">Nombre Completo:</label>
                    <input type="text" id="fullName" name="fullName">
                </div>
                <div class="form-group">
                    <label for="phone">Teléfono:</label>
                    <input type="tel" id="phone" name="phone">
                </div>
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="address">Dirección:</label>
                    <input type="text" id="address" name="address">
                </div>
                <button type="submit" class="btn btn-primary">Registrarse</button>
            </form>
            <p class="form-link">¿Ya tienes una cuenta? <a href="login.jsp">Volver a Iniciar Sesión</a></p>
        </div>
    </div>
</body>
</html>
