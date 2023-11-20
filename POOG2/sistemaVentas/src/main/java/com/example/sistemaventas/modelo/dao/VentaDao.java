package com.example.sistemaventas.modelo.dao;

import com.example.sistemaventas.modelo.dominio.Venta;
import com.example.sistemaventas.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;


    public VentaDao() {
        this.conexionDB = new ConexionDB();
    }


    public void creaTablaVentaVentaDetalle() {
        String sqlTablaVenta = "create table if not exists venta\n" +
                "(\n" +
                "    id             integer primary key,\n" +
                "    serie          text,\n" +
                "    numero         integer,\n" +
                "    base_imponible real,\n" +
                "    igv            real,\n" +
                "    total          real,\n" +
                "    fecha_creacion DATE,\n" +
                "    id_cliente     integer,\n" +
                "    foreign key (id_cliente) references cliente (id)\n" +
                "\n" +
                ")";


        String sqlTablaVentaDetalle = "create table if not exists venta_detalle\n" +
                "(\n" +
                "    id             integer primary key,\n" +
                "    base_imponible real,\n" +
                "    igv            real,\n" +
                "    total          real,\n" +
                "    producto_id    integer,\n" +
                "    id_venta       integer,\n" +
                "    foreign key (id_venta) references venta (id)\n" +
                ")";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaVenta);
            preparedStatement.execute();
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaVentaDetalle);
            preparedStatement.execute();
            System.out.println("Tabla venta y venta detalle  creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Venta> listarVentas() {
        creaTablaVentaVentaDetalle();
        List<Venta> ventas = new ArrayList<>();
        String consultaListarVentas = "select v.id,\n" +
                "       v.serie,\n" +
                "       v.numero,\n" +
                "       v.base_imponible,\n" +
                "       v.igv,\n" +
                "       v.total,\n" +
                "       v.fecha_creacion,\n" +
                "       v.id_cliente,\n" +
                "       c.dni,\n" +
                "       c.nombre\n" +
                // "       c.apellidos\n" +
                "from venta v\n" +
                "         left join main.cliente c on c.id = v.id_cliente";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarVentas);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(resultSet.getInt(1));
                venta.setSerieVenta(resultSet.getString(2));
                venta.setNumeroVenta(resultSet.getInt(3));
                venta.setBaseImponibleVenta(resultSet.getDouble(4));
                venta.setIgvVenta(resultSet.getDouble(5));
                venta.setTotalVenta(resultSet.getDouble(6));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                venta.setFechaCreacionVenta(formatter.parse(resultSet.getString(7)));
                venta.setId(resultSet.getInt(8));
                venta.setDni(resultSet.getString(9));
                venta.setNombre(resultSet.getString(10));
                //venta.setApellidos(resultSet.getString(11));
                ventas.add(venta);
            }
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar venta correctamente");
        return ventas;
    }


    public boolean insertarVenta(Venta venta) {
        creaTablaVentaVentaDetalle();
        try {
            String consultaInsertarVenta = "INSERT INTO venta(serie, numero, base_imponible, igv, total, fecha_creacion, id_cliente) VALUES(?,?,?,?,?,?,?)";
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarVenta);
            preparedStatement.setString(1, venta.getSerieVenta());
            preparedStatement.setInt(2, venta.getNumeroVenta());
            preparedStatement.setDouble(3, venta.getBaseImponibleVenta());
            preparedStatement.setDouble(4, venta.getIgvVenta());
            preparedStatement.setDouble(5, venta.getTotalVenta());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(6, formatter.format(venta.getFechaCreacionVenta()));
            preparedStatement.setInt(7, venta.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        double generatedId = generatedKeys.getLong(1);
                        venta.getVentaDetalles().forEach(ventaDetalle -> {
                            String consultaInsertarVentaDetalle = "INSERT INTO venta_detalle(base_imponible, igv, total, producto_id, id_venta ) VALUES(?,?,?,?,?)";
                            try {
                                preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarVentaDetalle);
                                preparedStatement.setDouble(1, ventaDetalle.getBaseImponibleVentaDetalle());
                                preparedStatement.setDouble(2, ventaDetalle.getIgvVentaDetalle());
                                preparedStatement.setDouble(3, ventaDetalle.getTotalVentaDetalle());
                                preparedStatement.setDouble(4, ventaDetalle.getIdProducto());
                                preparedStatement.setDouble(5, generatedId);
                                preparedStatement.execute();
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                        });


                    } else {
                        System.out.println("id generado correctamente.");
                    }
                }
            } else {
                System.out.println("No se inserto registros");
            }


            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}