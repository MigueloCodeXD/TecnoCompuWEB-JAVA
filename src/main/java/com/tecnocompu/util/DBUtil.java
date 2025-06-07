package com.tecnocompu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Clase de utilidad para gestionar la conexión a la base de datos H2.
 */
public class DBUtil {
    // URL de conexión a la base de datos H2 en modo archivo (~ indica el directorio de usuario)
    private static final String JDBC_URL = "jdbc:h2:~/tecnocompu";
    private static final String JDBC_USER = "sa"; // Usuario por defecto para H2
    private static final String JDBC_PASSWORD = ""; // Contraseña por defecto para H2

    /**
     * Establece una conexión con la base de datos H2.
     *
     * @return Objeto Connection si la conexión es exitosa, null en caso contrario.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el driver JDBC de H2
            Class.forName("org.h2.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Conexión a la base de datos H2 establecida correctamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de H2 no encontrado. Asegúrate de que la dependencia esté en el classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos H2: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Cierra una conexión, PreparedStatement y ResultSet.
     * Evita cerrar objetos nulos.
     *
     * @param connection La conexión a cerrar.
     * @param statement El Statement a cerrar (puede ser PreparedStatement).
     */
    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos de la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Inicializa el esquema de la base de datos ejecutando el archivo schema.sql.
     * Esto asegura que las tablas existan al iniciar la aplicación.
     */
    public static void initializeDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Leer el contenido de schema.sql
            // Utiliza getResourceAsStream para leer desde el classpath (src/main/resources)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    DBUtil.class.getClassLoader().getResourceAsStream("schema.sql")))) {
                StringBuilder schemaSql = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    schemaSql.append(line).append("\n");
                }
                // Ejecutar el script SQL
                statement.execute(schemaSql.toString());
                System.out.println("Esquema de la base de datos inicializado/verificado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al leer el archivo schema.sql: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.err.println("Error al inicializar el esquema de la base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Bloque estático para inicializar la base de datos cuando la clase se carga
    static {
        initializeDatabase();
    }
}

