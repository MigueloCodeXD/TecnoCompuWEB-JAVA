<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TecnoCompu - Contacto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="header">
        <div class="header-content">
            <div class="logo-container">
                <img src="https://placehold.co/80x80/8A2BE2/FFFFFF?text=TC" alt="Logo TecnoCompu" class="logo-header">
                <span class="site-title">TecnoCompu</span>
            </div>
            <nav class="main-nav">
                <a href="index.jsp" class="nav-item">Inicio</a>
                <a href="#" class="nav-item">Productos</a>
                <a href="#" class="nav-item">Ofertas</a>
                <a href="contact.jsp" class="nav-item active">Contacto</a>
            </nav>
            <%-- Simple link back to login for demonstration if not logged in --%>
            <% if (session.getAttribute("currentUser") == null) { %>
                <a href="login.jsp" class="btn btn-secondary btn-small">Iniciar Sesión</a>
            <% } else { %>
                <a href="login.jsp" class="btn btn-secondary btn-small">Cerrar Sesión</a>
            <% } %>
        </div>
    </header>

    <main class="main-content">
        <div class="container contact-container">
            <div class="form-card contact-form-card">
                <h1>Contacto</h1>
                <p>¿Tienes alguna pregunta, sugerencia o necesitas soporte? ¡Estamos aquí para ayudarte!</p>

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

                <form action="contact" method="post">
                    <div class="form-group">
                        <label for="name">Nombre:</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Correo Electrónico:</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Teléfono (opcional):</label>
                        <input type="tel" id="phone" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="messageType">Tipo de Mensaje:</label>
                        <select id="messageType" name="messageType" required>
                            <option value="">Selecciona un tipo</option>
                            <option value="sugerencia">Sugerencia</option>
                            <option value="queja">Queja</option>
                            <option value="soporte">Soporte Técnico</option>
                            <option value="general">General</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="message">Mensaje:</label>
                        <textarea id="message" name="message" rows="6" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar Mensaje</button>
                </form>
                <p class="form-link"><a href="index.jsp">Volver a la Tienda</a></p>
            </div>
        </div>
    </main>

    <footer class="footer">
        <p>&copy; 2023 TecnoCompu. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
