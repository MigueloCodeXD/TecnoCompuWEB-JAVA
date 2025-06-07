package com.tecnocompu.servlet;

import com.tecnocompu.dao.UserDAO;
import com.tecnocompu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet encargado de la autenticación de usuarios.
 * Mapeado a la URL /login.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            // Autenticación exitosa
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user); // Guarda el objeto usuario en la sesión
            response.sendRedirect("index.jsp"); // Redirige a la página principal
        } else {
            // Autenticación fallida
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response); // Vuelve a login.jsp con un mensaje de error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si se accede directamente via GET a /login, simplemente redirige a login.jsp
        // O podrías mostrar la página de login.
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
