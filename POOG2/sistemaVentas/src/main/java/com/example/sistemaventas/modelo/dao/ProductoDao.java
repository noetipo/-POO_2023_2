package com.example.sistemaventas.modelo.dao;

import com.example.sistemaventas.modelo.dominio.Producto;
import com.example.sistemaventas.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;

    public ProductoDao() {
        this.conexionDB = new ConexionDB();
    }

    public void creaTablaProducto() {
        String sqlTablaProducto = "create table if not exists producto( id int primary key, codigo text,nombre text, descripcion text,fecha_creacion DATE, id_categoria int , precio real)";

        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaProducto);
            preparedStatement.execute();
            System.out.println("Tabla producto creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listarProductos() {
        creaTablaProducto();
        List<Producto> productos = new ArrayList<>();
        String consultaListarproductos = "select p.id, p.codigo,p.nombre,p.descripcion,p.fecha_creacion,c.codigo,c.nombre, p.precio from producto p left join categoria c on p.id_categoria = c.id";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarproductos);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultSet.getInt(1));
                producto.setCodigoProducto(resultSet.getString(2));
                producto.setNombreProducto(resultSet.getString(3));
                producto.setDescripcionProducto(resultSet.getString(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                producto.setFechaCreacionProducto(formatter.parse(resultSet.getString(5)));
                producto.setCodigo(resultSet.getString(6));
                producto.setNombre(resultSet.getString(7));
                producto.setPrecioProducto(resultSet.getDouble(8));
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar categoria correctamente");
        return productos;
    }

    public List<Producto> listarProductosxNombre(String nombre) {
        creaTablaProducto();
        nombre = "%"+nombre+"%";
        List<Producto> productos = new ArrayList<>();
        String consultaListarproductos = "select p.id, p.codigo,p.nombre,p.descripcion,p.fecha_creacion,c.codigo,c.nombre, p.precio from producto p left join categoria c on p.id_categoria = c.id where p.nombre like ?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarproductos);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultSet.getInt(1));
                producto.setCodigoProducto(resultSet.getString(2));
                producto.setNombreProducto(resultSet.getString(3));
                producto.setDescripcionProducto(resultSet.getString(4));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                producto.setFechaCreacionProducto(formatter.parse(resultSet.getString(5)));
                producto.setCodigo(resultSet.getString(6));
                producto.setNombre(resultSet.getString(7));
                producto.setPrecioProducto(resultSet.getDouble(8));
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar categoria correctamente");
        return productos;
    }

    public boolean insertarProducto(Producto producto) {
        System.out.println(producto.toString());
        creaTablaProducto();
        String consultaInsertarProducto = "INSERT INTO producto(codigo, nombre, descripcion, fecha_creacion, id_categoria,precio) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarProducto);
            preparedStatement.setString(1, producto.getCodigoProducto());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setString(3, producto.getDescripcionProducto());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(4, formatter.format(producto.getFechaCreacionProducto()));
            preparedStatement.setInt(5, producto.getId());
            preparedStatement.setDouble(6, producto.getPrecioProducto());
            preparedStatement.execute();
            System.out.println("Insertar producto correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Producto productoPorId(Integer id) {
        creaTablaProducto();
        String consultarProductoPorId = "select p.id, p.codigo, p.nombre, p.descripcion, c.codigo, c.nombre, p.id_categoria,p.precio\n" +
                "from producto p\n" +
                "         left join categoria c on p.id_categoria = c.id where p.id=?";
        Producto producto = new Producto();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultarProductoPorId);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                producto.setIdProducto(resultSet.getInt(1));
                producto.setCodigoProducto(resultSet.getString(2));
                producto.setNombreProducto(resultSet.getString(3));
                producto.setDescripcionProducto(resultSet.getString(4));
                //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // producto.setFechaCreacionProducto(formatter.parse(resultSet.getString(5)));
                producto.setCodigo(resultSet.getString(5));
                producto.setId(resultSet.getInt(7));
                producto.setNombre(resultSet.getString(6));
                producto.setPrecioProducto(resultSet.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("categoriaPorId de id = " + id + " devuelto correctamente");
        return producto;
    }

    public boolean actulizarCategoria(Producto producto) {
        creaTablaProducto();
        String consultaInsertarCategoria = "UPDATE producto SET codigo=?, nombre=?, descripcion=?, id_categoria=?, precio=? WHERE id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCategoria);
            preparedStatement.setString(1, producto.getCodigoProducto());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setString(3, producto.getDescripcionProducto());
            preparedStatement.setInt(4, producto.getId());
            preparedStatement.setInt(5, producto.getIdProducto());
            preparedStatement.setDouble(6, producto.getPrecioProducto());
            preparedStatement.execute();
            System.out.println("Actualizar producto correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarProductoPorId(Integer id) {
        creaTablaProducto();
        String consultaProductoPorId = "delete  from producto where id=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaProductoPorId);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("eliminacion correcta");


    }
}
