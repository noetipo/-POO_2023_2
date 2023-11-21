package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.ClienteDao;
import com.example.sistemaventas.modelo.dao.ProductoDao;
import com.example.sistemaventas.modelo.dao.VentaDao;
import com.example.sistemaventas.modelo.dominio.Cliente;
import com.example.sistemaventas.modelo.dominio.Producto;
import com.example.sistemaventas.modelo.dominio.Venta;
import com.example.sistemaventas.modelo.dominio.VentaDetalle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class VentaController2 implements Initializable {
    @FXML
    public TextField codigo;
    @FXML
    private TableView<VentaDetalle> tablaVentaDetalle = new TableView<>();
    @FXML
    private TableColumn<VentaDetalle, String> colCodigoProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colNombreCategoriaProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colNombreProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colBaseImponibleProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colIgvProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colCantidadProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colPrecioUnitarioProductoVentaDetalle = new TableColumn<>();
    @FXML
    private TableColumn<VentaDetalle, String> colTotalProductoVentaDetalle = new TableColumn<>();


    //


    @FXML
    private TableView<Producto> tablaProductos = new TableView<>();




    @FXML
    private TableColumn<Producto, String> colCodigoProducto = new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colNombreProducto = new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colDescripcionProducto = new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colFechaCreacionProducto = new TableColumn<>();
    @FXML
    public TableColumn<Producto, String> colPrecioProducto = new TableColumn<>();




    @FXML
    public TableColumn<Producto, String> colNombreCategoriaProducto = new TableColumn<>();
    private ObservableList<Producto> productosObservableList = FXCollections.observableArrayList();


    private ObservableList<VentaDetalle> ventaDetalleObservableList = FXCollections.observableArrayList();
    // venta
    @FXML
    private TableView<Venta> tablaVentas = new TableView<>();
    @FXML
    private TableColumn<Venta, String> colSerie = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colNumero = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colBaseImponible = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colIgv = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colTotal = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colFecha = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colDni = new TableColumn<>();
    @FXML
    public TableColumn<Venta, String> colNombre = new TableColumn<>();
    //@FXML
    //public TableColumn<Venta, String> colApellido = new TableColumn<>();
    @FXML
    private ComboBox clienteBox;
    @FXML
    private TextField baseImponibleText;
    @FXML
    private TextField igvText;
    @FXML
    private TextField totalText;

    @FXML
    private TextField txtBuscador;
    private ObservableList<Venta> ventasObservableList = FXCollections.observableArrayList();
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();
    int idCliente = 0;
    double baseImponible = 0.00;
    double igv = 0.00;
    double total = 0.00;
    Producto productoSeleccionado = new Producto();
    VentaDetalle ventaDetalleSelecionado = new VentaDetalle();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCodigoProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoProducto()));
        colNombreCategoriaProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colNombreProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        colBaseImponibleProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getBaseImponibleVentaDetalle())));
        colIgvProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getIgvVentaDetalle())));
        colTotalProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getTotalVentaDetalle())));
        colCantidadProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getCantidadVentaDetalle())));
        colPrecioUnitarioProductoVentaDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecioUnitarioVentaDetalle())));
        tablaVentaDetalle.setEditable(true);
        colCantidadProductoVentaDetalle.setCellFactory(TextFieldTableCell.forTableColumn());
        tablaVentaDetalle.setItems(ventaDetalleObservableList);
        tablaVentaDetalle.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        ventaDetalleSelecionado = newValue;


                    }
                }
        );
        listarVentas();
        listarProductos();
        listarClientes();
    }


    public void listarVentas() {
        tablaVentas.getItems().clear();
        VentaDao ventaDao = new VentaDao();
        List<Venta> ventas = ventaDao.listarVentas();
        ventasObservableList.addAll(ventas);
        colSerie.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSerieVenta()));
        colNumero.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getNumeroVenta())));
        colBaseImponible.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getBaseImponibleVenta())));
        colIgv.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getIgvVenta())));
        colTotal.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getTotalVenta())));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacionVenta())));
        colDni.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        //colApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        tablaVentas.setItems(ventasObservableList);
       /*tablaVentas.getSelectionModel().selectedItemProperty().addListener(
               (observable, oldValue, newValue) -> {
                   if (newValue != null) {
                       // seleccionarProducto(newValue);


                   }
               }
       );*/
    }


    public void listarProductos() {
        tablaProductos.getItems().clear();
        ProductoDao categoriaDao = new ProductoDao();
        List<Producto> productos = categoriaDao.listarProductos();
        productosObservableList.addAll(productos);
        colCodigoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoProducto()));
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        colDescripcionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcionProducto()));
        colPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecioProducto())));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacionProducto())));
        colNombreCategoriaProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tablaProductos.setItems(productosObservableList);
        tablaProductos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarProducto(newValue);
                    }
                }
        );
    }

    public void listarProductos_busqueda(){
        tablaProductos.getItems().clear();
        ProductoDao prodDao = new ProductoDao();
        List<Producto> productos = prodDao.listarProductosxNombre(txtBuscador.getText());
        productosObservableList.addAll(productos);
        colCodigoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoProducto()));
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        colDescripcionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcionProducto()));
        colPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecioProducto())));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacionProducto.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacionProducto())));
        colNombreCategoriaProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tablaProductos.setItems(productosObservableList);
        tablaProductos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarProducto(newValue);
                    }
                }
        );
    }


    public void listarClientes() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> Clientes = clienteDao.listarClientes();
        clientesObservableList.addAll(Clientes);
        clienteBox.setPromptText("Selecciona una cliente");
        clienteBox.setItems(clientesObservableList);
        clienteBox.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente.getNombre();
            }


            @Override
            public Cliente fromString(String string) {
                return null;
            }
        });
        clienteBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                seleccionarCliente((Cliente) newValue);
            }
        });
    }


    private void seleccionarProducto(Producto producto) {
        productoSeleccionado = producto;
    }


    private void seleccionarCliente(Cliente cliente) {
        idCliente = cliente.getId();
    }


    public void agregarProducto(ActionEvent actionEvent) {
        VentaDetalle ventaDetalle = new VentaDetalle();
        ventaDetalle.setIdProducto(productoSeleccionado.getIdProducto());
        ventaDetalle.setNombre(productoSeleccionado.getNombre());
        ventaDetalle.setCodigoProducto(productoSeleccionado.getCodigoProducto());
        ventaDetalle.setCantidadVentaDetalle(1.0);
        ventaDetalle.setPrecioUnitarioVentaDetalle(productoSeleccionado.getPrecioProducto() * ventaDetalle.getCantidadVentaDetalle());
        ventaDetalle.setNombreProducto(productoSeleccionado.getNombreProducto());
        ventaDetalle.setBaseImponibleVentaDetalle(productoSeleccionado.getPrecioProducto());
        ventaDetalle.setIgvVentaDetalle((productoSeleccionado.getPrecioProducto()) * (18.00 / 100.00));
        ventaDetalle.setTotalVentaDetalle((productoSeleccionado.getPrecioProducto()) + ((productoSeleccionado.getPrecioProducto()) * (18.00 / 100.00)));
        ventaDetalleObservableList.add(ventaDetalle);
        calculaTotales();




    }


    public void guardarVenta(ActionEvent actionEvent) {
        VentaDao ventaDao = new VentaDao();
        Venta venta = new Venta();
        venta.setId(idCliente);
        venta.setBaseImponibleVenta(baseImponible);
        venta.setIgvVenta(igv);
        venta.setTotalVenta(total);
        venta.setNumeroVenta(ventasObservableList.size() + 1);
        venta.setSerieVenta("F001");
        venta.setFechaCreacionVenta(new Date());
        venta.setVentaDetalles(ventaDetalleObservableList);
        ventaDao.insertarVenta(venta);
    }


    public void eliminarItemDetalle(ActionEvent actionEvent) {
        ventaDetalleObservableList.remove(ventaDetalleObservableList.indexOf(ventaDetalleSelecionado));
        calculaTotales();
    }


    private void calculaTotales() {
        baseImponible = 0;
        igv = 0;
        total = 0;
        ventaDetalleObservableList.forEach(data -> {
            baseImponible = baseImponible + data.getBaseImponibleVentaDetalle();
            igv = igv + data.getIgvVentaDetalle();
            total = total + data.getTotalVentaDetalle();
        });
        baseImponibleText.setText(Double.toString(baseImponible));
        igvText.setText(Double.toString(igv));
        totalText.setText(Double.toString(total));
    }


    public void onEditar(TableColumn.CellEditEvent<VentaDetalle, String> ventaDetalleStringCellEditEvent) {
        VentaDetalle ventaDetalle = new VentaDetalle();
        ventaDetalle = tablaVentaDetalle.getSelectionModel().getSelectedItem();
        int index = ventaDetalleObservableList.indexOf(ventaDetalle);
        ventaDetalleObservableList.get(index)
                .setCantidadVentaDetalle(Double.valueOf(ventaDetalleStringCellEditEvent.getNewValue()));
        ventaDetalleObservableList.get(index)
                .setBaseImponibleVentaDetalle(ventaDetalleObservableList.get(index).getPrecioUnitarioVentaDetalle() * ventaDetalleObservableList.get(index).getCantidadVentaDetalle());
        ventaDetalleObservableList.get(index)
                .setIgvVentaDetalle((ventaDetalleObservableList.get(index).getPrecioUnitarioVentaDetalle() * ventaDetalleObservableList.get(index).getCantidadVentaDetalle()) * (18.00 / 100.00));
        ventaDetalleObservableList.get(index)
                .setTotalVentaDetalle((ventaDetalleObservableList.get(index).getPrecioUnitarioVentaDetalle() * ventaDetalleObservableList.get(index).getCantidadVentaDetalle()) + ((ventaDetalleObservableList.get(index).getPrecioUnitarioVentaDetalle()) * (18.00 / 100.00)));
       /*ventaDetalleObservableList.forEach(data -> {
           System.out.println("base imponible");
           System.out.println(data.getBaseImponibleVentaDetalle());
       });*/
        ventaDetalle = ventaDetalleObservableList.remove(index);
        ventaDetalleObservableList.add(ventaDetalle);
        System.out.println("detalle: " + ventaDetalleObservableList.toString());
        calculaTotales();
    }


    @FXML
    public void onEnter(ActionEvent ae){

        System.out.println(codigo.getText()) ;
        productosObservableList.forEach(producto -> {
            if (producto.getCodigoProducto().equals(codigo.getText())){
                productoSeleccionado=producto;
                VentaDetalle ventaDetalle = new VentaDetalle();
                ventaDetalle.setIdProducto(productoSeleccionado.getIdProducto());
                ventaDetalle.setNombre(productoSeleccionado.getNombre());
                ventaDetalle.setCodigoProducto(productoSeleccionado.getCodigoProducto());
                ventaDetalle.setCantidadVentaDetalle(1.0);
                ventaDetalle.setPrecioUnitarioVentaDetalle(productoSeleccionado.getPrecioProducto() * ventaDetalle.getCantidadVentaDetalle());
                ventaDetalle.setNombreProducto(productoSeleccionado.getNombreProducto());
                ventaDetalle.setBaseImponibleVentaDetalle(productoSeleccionado.getPrecioProducto());
                ventaDetalle.setIgvVentaDetalle((productoSeleccionado.getPrecioProducto()) * (18.00 / 100.00));
                ventaDetalle.setTotalVentaDetalle((productoSeleccionado.getPrecioProducto()) + ((productoSeleccionado.getPrecioProducto()) * (18.00 / 100.00)));
                ventaDetalleObservableList.add(ventaDetalle);
                calculaTotales();
            }
        });
    }

}

