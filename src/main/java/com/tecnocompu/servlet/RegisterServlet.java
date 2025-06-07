package com.tecnocompu.servlet;

import com.tecnocompu.dao.UserDAO;
import com.tecnocompu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet encargado del registro de nuevos usuarios.
 * Mapeado a la URL /register.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Validaciones básicas
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Crear objeto User
        User newUser = new User(username, password, fullName, phone, email, address);

        // Intentar registrar el usuario
        if (userDAO.registerUser(newUser)) {
            // Registro exitoso
            request.setAttribute("successMessage", "Registro exitoso. ¡Ahora puedes iniciar sesión!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // Fallo en el registro (ej. usuario ya existe)
            request.setAttribute("errorMessage", "Error al registrar el usuario. El nombre de usuario podría ya existir.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si se accede directamente via GET a /register, simplemente redirige a register.jsp
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
