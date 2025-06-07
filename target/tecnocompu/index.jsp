<%@ page import="com.tecnocompu.model.User" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TecnoCompu - Tienda Online</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- Font Awesome para iconos si es necesario, aunque se pueden usar emojis/SVG -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <%
        // Verificar si hay una sesión activa, si no, redirigir a login.jsp
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return; // Detener la ejecución del resto de la página JSP
        }
    %>
    <header class="header">
        <div class="header-content">
            <div class="logo-container">
                <img src="https://placehold.co/80x80/8A2BE2/FFFFFF?text=TC" alt="Logo TecnoCompu" class="logo-header">
                <span class="site-title">TecnoCompu</span>
            </div>
            <nav class="main-nav">
                <a href="index.jsp" class="nav-item active">Inicio</a>
                <a href="#" class="nav-item">Productos</a>
                <a href="#" class="nav-item">Ofertas</a>
                <a href="contact.jsp" class="nav-item">Contacto</a>
            </nav>
            <div class="user-info">
                <span>Bienvenido, <%= currentUser.getFullName() != null && !currentUser.getFullName().isEmpty() ? currentUser.getFullName() : currentUser.getUsername() %>!</span>
                <a href="login.jsp" class="btn btn-secondary btn-small">Cerrar Sesión</a>
            </div>
        </div>
    </header>

    <main class="main-content">
        <section class="hero-banner">
            <h2 class="hero-title">Domina el Juego con TecnoCompu</h2>
            <p class="hero-subtitle">Tu destino para la tecnología gamer más avanzada.</p>
        </section>

        <section class="products-section">
            <h3 class="section-title">Productos Destacados</h3>
            <div class="product-grid">
                <!-- Producto 1: Laptop Gamer -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Laptop+Gamer" alt="Laptop Gamer" class="product-image">
                    <h4 class="product-title">Laptop Gamer Hyperion Z1</h4>
                    <p class="product-description">Potencia inigualable para tus juegos más exigentes. Core i9, RTX 4090.</p>
                    <span class="product-price">$2,999.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>

                <!-- Producto 2: Teclado Mecánico -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Teclado+Mecanico" alt="Teclado Mecánico" class="product-image">
                    <h4 class="product-title">Teclado Mecánico RGB Spectrum</h4>
                    <p class="product-description">Switches Cherry MX RGB, retroiluminación personalizable, durabilidad extrema.</p>
                    <span class="product-price">$149.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>

                <!-- Producto 3: Tarjeta Gráfica -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Tarjeta+Grafica" alt="Tarjeta Gráfica" class="product-image">
                    <h4 class="product-title">GPU QuantumFlow RTX 5080</h4>
                    <p class="product-description">Rendimiento gráfico de próxima generación, ray tracing hiperrealista.</p>
                    <span class="product-price">$1,299.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>

                <!-- Producto 4: Monitor Gamer -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Monitor+Gamer" alt="Monitor Gamer" class="product-image">
                    <h4 class="product-title">Monitor Curvo UltraWide Blaze</h4>
                    <p class="product-description">34 pulgadas, 144Hz, 1ms respuesta. Inmersión total.</p>
                    <span class="product-price">$699.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>

                <!-- Producto 5: Auriculares Gaming -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Auriculares+Gaming" alt="Auriculares Gaming" class="product-image">
                    <h4 class="product-title">Auriculares Gaming Vortex Pro</h4>
                    <p class="product-description">Sonido envolvente 7.1, micrófono retráctil con cancelación de ruido.</p>
                    <span class="product-price">$99.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>

                <!-- Producto 6: Ratón Gaming -->
                <div class="product-card">
                    <img src="https://placehold.co/300x200/300050/FFFFFF?text=Raton+Gaming" alt="Ratón Gaming" class="product-image">
                    <h4 class="product-title">Ratón Gaming G-Strike Elite</h4>
                    <p class="product-description">Sensor óptico de 20,000 DPI, 12 botones programables, iluminación RGB.</p>
                    <span class="product-price">$79.99</span>
                    <button class="btn btn-purple">Ver Detalles</button>
                </div>
            </div>
        </section>
        
        <section class="contact-cta">
            <p>¿Tienes alguna pregunta o sugerencia?</p>
            <a href="contact.jsp" class="btn btn-primary btn-large">¡Contáctanos!</a>
        </section>
    </main>

    <footer class="footer">
        <p>&copy; 2023 TecnoCompu. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
