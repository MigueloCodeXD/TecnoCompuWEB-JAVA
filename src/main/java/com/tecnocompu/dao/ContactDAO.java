package com.tecnocompu.dao;

import com.tecnocompu.model.Contact;
import com.tecnocompu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para interactuar con la tabla 'contactos' en la base de datos.
 */
public class ContactDAO {

    /**
     * Guarda un nuevo mensaje de contacto en la base de datos.
     *
     * @param contact Objeto Contact con los datos del mensaje.
     * @return true si el mensaje fue guardado exitosamente, false en caso contrario.
     */
    public boolean saveContactMessage(Contact contact) {
        String SQL = "INSERT INTO contactos (nombre, correo, telefono, tipo_mensaje, mensaje) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getPhone());
            pstmt.setString(4, contact.getMessageType());
            pstmt.setString(5, contact.getMessage());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar mensaje de contacto: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }
}
