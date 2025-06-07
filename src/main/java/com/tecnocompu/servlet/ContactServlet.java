package com.tecnocompu.servlet;

import com.tecnocompu.dao.ContactDAO;
import com.tecnocompu.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet encargado de manejar los envíos del formulario de contacto.
 * Mapeado a la URL /contact.
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    public void init() {
        contactDAO = new ContactDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String messageType = request.getParameter("messageType");
        String message = request.getParameter("message");

        // Validaciones básicas
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() ||
            messageType == null || messageType.trim().isEmpty() || message == null || message.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Por favor, completa todos los campos obligatorios.");
            request.getRequestDispatcher("contact.jsp").forward(request, response);
            return;
        }

        // Crear objeto Contact
        Contact newContact = new Contact(name, email, phone, messageType, message);

        // Intentar guardar el mensaje de contacto
        if (contactDAO.saveContactMessage(newContact)) {
            // Mensaje guardado exitosamente
            request.setAttribute("successMessage", "Tu mensaje ha sido enviado exitosamente. ¡Gracias!");
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        } else {
            // Fallo al guardar el mensaje
            request.setAttribute("errorMessage", "Hubo un error al enviar tu mensaje. Por favor, inténtalo de nuevo.");
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si se accede directamente via GET a /contact, simplemente redirige a contact.jsp
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }
}

