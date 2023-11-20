package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.CategoriaDao;
import com.example.sistemaventas.modelo.dao.ProductoDao;
import com.example.sistemaventas.modelo.dominio.Categoria;
import com.example.sistemaventas.modelo.dominio.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ProductoController implements Initializable {
    @FXML
    private TableView<Producto> tablaproductos;
    @FXML
    private TableColumn<Producto, String> colCodigoProducto;
    @FXML
    public TableColumn<Producto, String> colNombreProducto;
    @FXML
    public TableColumn<Producto, String> colDescripcionProducto;
    @FXML
    public TableColumn<Producto, String> colFechaCreacionProducto;
    @FXML
    public TableColumn<Producto, String> colCodigoCategoria;
    @FXML
    public TableColumn<Producto, String> colNombreCategoria;
    @FXML
    private TextField codigoText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField descripcionText;
    @FXML
    private TextField precioText;
    @FXML
    private ComboBox categoriaBox;

    @FXML
    public Button guardarBtn;
    Integer idProducto = 0;
    private ObservableList<Producto> productosObservableList = FXCollections.observableArrayList();
    private ObservableList<Categoria> categorirasObservableList = FXCollections.observableArrayList();
    Categoria categoriaSeleccionada = new Categoria();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarProductos();
        listarCategorias();

    }

    public void listarCategorias() {

        CategoriaDao categoriaDao = new CategoriaDao();
        List<Categoria> categorias = categoriaDao.listarCategorias();
        categorirasObservableList.addAll(categorias);
        categoriaBox.setPromptText("Selecciona una opción");
        categoriaBox.setItems(categorirasObservableList);
        categoriaBox.setConverter(new StringConverter<Categoria>() {
            @Override
            public String toString(Categoria categoria) {
                return categoria.getNombre();
            }


            @Override
            public Categoria fromString(String string) {
                return null;
            }
        });
        categoriaBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                seleccionarCategoria((Categoria) newValue);
            }
        });


    }

    private void seleccionarCategoria(Categoria newValue) {
        categoriaSeleccionada = newValue;
    }

    public void listarProductos() {
        tablaproductos.getItems().clear();

        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.listarProductos();
        productosObservableList.addAll(productos);
        colCodigoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoProducto()));
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        colDescripcionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcionProducto()));

        colCodigoCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colNombreCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacionProducto())));
        tablaproductos.setItems(productosObservableList);

        tablaproductos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarProducto(newValue);
                    }
                }
        );

    }

    public void onInsertarButtonClick(ActionEvent actionEvent) {
        System.out.println("click boton guardar");
        ProductoDao productoDao = new ProductoDao();
        Producto producto = new Producto();
        if (idProducto == 0) {
            producto.setCodigoProducto(codigoText.getText());
            producto.setNombreProducto(nombreText.getText());
            producto.setDescripcionProducto(descripcionText.getText());
            producto.setFechaCreacionProducto(new Date());
            producto.setId(categoriaSeleccionada.getId());
            producto.setPrecioProducto(Double.valueOf(precioText.getText()));
            productoDao.insertarProducto(producto);
        } else {
            producto.setIdProducto(idProducto);
            producto.setCodigoProducto(codigoText.getText());
            producto.setNombreProducto(nombreText.getText());
            producto.setDescripcionProducto(descripcionText.getText());
            producto.setFechaCreacionProducto(new Date());
            producto.setId(categoriaSeleccionada.getId());
            producto.setPrecioProducto(Double.valueOf(precioText.getText()));
            productoDao.actulizarCategoria(producto);


        }
        idProducto = 0;
        onLimpiarButtonClick(null);
        listarProductos();
        guardarBtn.setText("Guardar");
    }


    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        codigoText.clear();
        nombreText.clear();
        descripcionText.clear();
        precioText.clear();
        categoriaBox.getSelectionModel().clearSelection();
    }

    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        ProductoDao productoDao = new ProductoDao();
        Producto producto = productoDao.productoPorId(idProducto);
        codigoText.setText(producto.getCodigoProducto());
        nombreText.setText(producto.getNombreProducto());
        descripcionText.setText(producto.getDescripcionProducto());
        precioText.setText(Double.toString(producto.getPrecioProducto()));
        Categoria categoria = new Categoria();
        categoria.setId(producto.getId());
        categoria.setNombre(producto.getNombre());
        categoriaBox.getSelectionModel().select(categoria);
        guardarBtn.setText("Guardar Editar");
    }

    private void seleccionarProducto(Producto producto) {
        idProducto = producto.getIdProducto();
    }

    public void eliminarButtonClick(ActionEvent actionEvent) {
        ProductoDao productoDao = new ProductoDao();
        productoDao.eliminarProductoPorId(idProducto);
        listarProductos();
    }

}