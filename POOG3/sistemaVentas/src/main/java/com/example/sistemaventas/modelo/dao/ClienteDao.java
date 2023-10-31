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

        String sqlTablaCategoria = "CREATE TABLE IF NOT EXISTS cliente (id integer primary key,dni text,nombre text, apellido text,direccion text,fecha_creacion DATE, fecha_actualizacion DATE)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaCategoria);
            preparedStatement.execute();
            System.out.println("Tabla cliente creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarClientes() {
        creaTablaCliente();
        List<Cliente> clientes = new ArrayList<>();
        String consultaListarClientes = "select id, dni, nombre, apellido, direccion, fecha_creacion, fecha_actualizacion from cliente";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarClientes);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt(1));
                cliente.setDni(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(3));
                cliente.setApellido(resultSet.getString(4));
                cliente.setDireccion(resultSet.getString(5));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                cliente.setFechaCreacion(formatter.parse(resultSet.getString(6)));
                cliente.setFechaActualizacion(formatter.parse(resultSet.getString(7)));
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
        String consultaInsertarCategoria = "INSERT INTO cliente(dni, nombre, apellido, direccion, fecha_creacion, fecha_actualizacion) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCategoria);
            preparedStatement.setString(1, cliente.getDni());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setString(4, cliente.getDireccion());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(5, formatter.format(cliente.getFechaCreacion()));
            preparedStatement.setString(6, formatter.format(cliente.getFechaActualizacion()));
            preparedStatement.execute();
            System.out.println("Insertar categoria correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente clientePorId(Integer id) {
        creaTablaCliente();
        String consultaClientePorId = "select id, dni, nombre, apellido, direccion, fecha_creacion, fecha_actualizacion from cliente where id =?";
        Cliente cliente = new Cliente();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaClientePorId);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente.setId(resultSet.getInt(1));
                cliente.setDni(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(2));
                cliente.setApellido(resultSet.getString(3));
                cliente.setDireccion(resultSet.getString(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                cliente.setFechaCreacion(formatter.parse(resultSet.getString(6)));
                cliente.setFechaActualizacion(formatter.parse(resultSet.getString(7)));
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Lista categoria por id correctamente");
        return cliente;
    }

    public boolean actulizarCliente(Cliente cliente) {
        creaTablaCliente();
        String consultaInsertarCategoria = "UPDATE cliente SET dni =?,nombre=?,apellido=?,direccion=?,fecha_actualizacion=? WHERE id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCategoria);
            preparedStatement.setString(1, cliente.getDni());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setString(4, cliente.getDireccion());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(5, formatter.format(cliente.getFechaActualizacion()));
            preparedStatement.setInt(6, cliente.getId());
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
        String consultaEliminarClientePorId = "delete  from cliente where id =?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaEliminarClientePorId);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("eliminacion correcta");


    }


}
