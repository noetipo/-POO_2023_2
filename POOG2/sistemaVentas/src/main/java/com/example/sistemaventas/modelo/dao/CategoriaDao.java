package com.example.sistemaventas.modelo.dao;

import com.example.sistemaventas.modelo.dominio.Categoria;
import com.example.sistemaventas.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;

    public CategoriaDao() { this.conexionDB = new ConexionDB(); }

    public void creaTablaCategoria() {
        String sqlTablaCategoria = "CREATE TABLE IF NOT EXISTS categoria (id integer primary key,codigo text,nombre text, descripcion text,fecha_creacion DATE)";

        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaCategoria);
            preparedStatement.execute();
            System.out.println("Tabla categoria creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarCategorias() {
        creaTablaCategoria();
        List<Categoria> categorias = new ArrayList<>();
        String consultaListarCategorias = "select id, codigo, nombre, descripcion, fecha_creacion from categoria";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarCategorias);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt(1));
                categoria.setCodigo(resultSet.getString(2));
                categoria.setNombre(resultSet.getString(3));
                categoria.setDescripcion(resultSet.getString(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                categoria.setFechaCreacion(formatter.parse(resultSet.getString(5)));
                categorias.add(categoria);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar categoria correctamente");
        return categorias;
    }
    public boolean insertarCategoria(Categoria categoria) {
        creaTablaCategoria();
        String consultaInsertarCategoria = "INSERT INTO categoria(codigo,nombre,descripcion,fecha_creacion) VALUES(?,?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCategoria);
            preparedStatement.setString(1, categoria.getCodigo());
            preparedStatement.setString(2, categoria.getNombre());
            preparedStatement.setString(3, categoria.getDescripcion());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(4, formatter.format(categoria.getFechaCreacion()));
            preparedStatement.execute();
            System.out.println("Insertar categoria correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Categoria categoriaPorId(Integer id) {
        creaTablaCategoria();
        String consultaCategoriaPorId = "select id, codigo, nombre, descripcion, fecha_creacion from categoria where id =?";
        Categoria categoria = new Categoria();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaCategoriaPorId);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                categoria.setId(resultSet.getInt(1));
                categoria.setCodigo(resultSet.getString(2));
                //categoria.setCodigo(resultSet.getString(2));
                categoria.setNombre(resultSet.getString(3));
                categoria.setDescripcion(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("categoriaPorId de id = " + id + " devuelto correctamente");
        return categoria;
    }

    public boolean actulizarCategoria(Categoria categoria) {
        creaTablaCategoria();
        String consultaInsertarCategoria = "UPDATE categoria SET codigo =?,nombre=?,descripcion=? WHERE id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCategoria);
            preparedStatement.setString(1, categoria.getCodigo());
            preparedStatement.setString(2, categoria.getNombre());
            preparedStatement.setString(3, categoria.getDescripcion());
            preparedStatement.setInt(4, categoria.getId());
            preparedStatement.execute();
            System.out.println("Actualizar categoria correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarCategoriaPorId(Integer id) {
        creaTablaCategoria();
        String consultaCategoriaPorId = "delete  from categoria where id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaCategoriaPorId);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("eliminacion correcta");


    }

}
