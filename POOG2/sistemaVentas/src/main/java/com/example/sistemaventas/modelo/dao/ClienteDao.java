package com.example.sistemaventas.modelo.dao;

import com.example.sistemaventas.modelo.dominio.Cliente;
import com.example.sistemaventas.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;

    public ClienteDao() {
        this.conexionDB = new ConexionDB();
    }

    public void creaTablaCliente() {
        String sqlTablaCliente = "CREATE TABLE IF NOT EXISTS cliente (id integer primary key,dni text, nombre text, direccion text,fecha_creacion DATE)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaCliente);
            preparedStatement.execute();
            System.out.println("Tabla cliente creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarClientes() {
        creaTablaCliente();
        List<Cliente> clientes = new ArrayList<>();
        String consultaListarcliente = "select id, dni, nombre, direccion, fecha_creacion from cliente";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarcliente);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt(1));
                cliente.setDni(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(3));
                cliente.setDireccion(resultSet.getString(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                cliente.setFechaCreacion(formatter.parse(resultSet.getString(5)));
                clientes.add(cliente);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar categoria correctamente");
        return clientes;
    }

    public boolean insertarCliente(Cliente cliente) {
        creaTablaCliente();
        String consultaInsertarCliente = "INSERT INTO cliente(dni,nombre,direccion,fecha_creacion) VALUES(?,?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCliente);
            preparedStatement.setString(1, cliente.getDni());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(4, formatter.format(cliente.getFechaCreacion()));
            preparedStatement.execute();
            System.out.println("Insertar cliente correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente clientePorId(Integer id) {
        creaTablaCliente();
        String consultaClientePorId = "select id, dni, nombre, direccion, fecha_creacion from cliente where id =?";
        Cliente cliente = new Cliente();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaClientePorId);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente.setId(resultSet.getInt(1));
                cliente.setDni(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(3));
                cliente.setDireccion(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("cliente Por Id de id = " + id + " devuelto correctamente");
        return cliente;
    }

    public boolean actulizarCliente(Cliente cliente) {
        creaTablaCliente();
        String consultaActulizarCliente = "UPDATE cliente SET dni =?,nombre=?,direccion=? WHERE id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaActulizarCliente);
            preparedStatement.setString(1, cliente.getDni());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setInt(4, cliente.getId());
            preparedStatement.execute();
            System.out.println("Actualizar cliente correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarClientePorId(Integer id) {
        creaTablaCliente();
        String eliminarClientePorId = "delete  from cliente where id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(eliminarClientePorId);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("eliminacion correcta");


    }
}
