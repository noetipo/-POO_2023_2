package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.ProductoDao;
import com.example.sistemaventas.modelo.dominio.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class PruebaControlador implements Initializable {
    public TextField total;
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
    private TableView<Producto> tablaproductosSelect = new TableView<>();
    @FXML
    private TableColumn<Producto, String> colCodigoProductoSelect= new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colNombreProductoSelect= new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colDescripcionProductoSelect= new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colFechaCreacionProductoSelect= new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colCodigoCategoriaSelect= new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colNombreCategoriaSelect= new TableColumn<>();


    private ObservableList<Producto> productosObservableList = FXCollections.observableArrayList();
    private ObservableList<Producto> productosSeleccionadosObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarProductos();
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

    private void seleccionarProducto(Producto producto) {
        productosSeleccionadosObservableList.add(producto);

        colCodigoProductoSelect.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoProducto()));
        colNombreProductoSelect.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        colDescripcionProductoSelect.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcionProducto()));

        colCodigoCategoriaSelect.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colNombreCategoriaSelect.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacionProductoSelect.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacionProducto())));
        tablaproductosSelect.setItems(productosSeleccionadosObservableList);


    }

}
