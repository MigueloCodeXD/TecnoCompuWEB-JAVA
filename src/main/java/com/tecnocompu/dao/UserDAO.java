package com.tecnocompu.dao;

import com.tecnocompu.model.User;
import com.tecnocompu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para interactuar con la tabla 'usuarios' en la base de datos.
 */
public class UserDAO {

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param user Objeto User con los datos del nuevo usuario.
     * @return true si el registro fue exitoso, false en caso contrario (ej. usuario ya existe).
     */
    public boolean registerUser(User user) {
        String SQL = "INSERT INTO usuarios (usuario, contrasena, nombre, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword()); // En una aplicación real, se usaría hashing para la contraseña
            pstmt.setString(3, user.getFullName());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getAddress());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Manejar errores de SQL, como usuario duplicado
            if (e.getErrorCode() == 23505) { // Código de error para restricción de unicidad en H2
                System.err.println("Error: El usuario '" + user.getUsername() + "' ya existe.");
            } else {
                System.err.println("Error al registrar usuario: " + e.getMessage());
            }
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }

    /**
     * Autentica un usuario verificando sus credenciales.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return Un objeto User si las credenciales son correctas, null en caso contrario.
     */
    public User authenticateUser(String username, String password) {
        String SQL = "SELECT id, usuario, contrasena, nombre, telefono, correo, direccion FROM usuarios WHERE usuario = ? AND contrasena = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password); // En una aplicación real, se compararía con la contraseña hasheada

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("usuario"));
                user.setPassword(rs.getString("contrasena"));
                user.setFullName(rs.getString("nombre"));
                user.setPhone(rs.getString("telefono"));
                user.setEmail(rs.getString("correo"));
                user.setAddress(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al autenticar usuario: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBUtil.close(conn, pstmt);
        }
        return user;
    }
}