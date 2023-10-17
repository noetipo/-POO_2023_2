package com.example.sistemaventas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public Connection connection;
    private String dbName = "ventas.db";

    public ConexionDB() {

        try {
            String url = "jdbc:sqlite:" + dbName;
            connection = DriverManager.getConnection(url);
            System.out.println("Conecion exitosa a SQLite");
        } catch (SQLException e) {
            System.out.println("Error al conectar a SQLite: " + e.getMessage());
        }
    }

    public void cerrarConexionDB() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexion cerrada");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }

    }
}
