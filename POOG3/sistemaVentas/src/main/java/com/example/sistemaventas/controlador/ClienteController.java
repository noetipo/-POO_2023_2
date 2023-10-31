package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.ClienteDao;
import com.example.sistemaventas.modelo.dominio.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {


    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, String> colid;
    @FXML
    private TableColumn<Cliente, String> coldni;
    @FXML
    public TableColumn<Cliente, String> colNombre;
    @FXML
    public TableColumn<Cliente, String> colApellido;
    @FXML
    public TableColumn<Cliente, String> colDireccion;
    @FXML
    public TableColumn<Cliente, String> colFechaCreacion;
    @FXML
    public TableColumn<Cliente, String> colFechaActualizacion;
    @FXML
    private TextField dniText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField apellidoText;
    @FXML
    private TextField direccionText;
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();
    @FXML
    public Button guardarBtn;
    Integer idCliente = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarClientes();
    }

    public void listarClientes() {
        tablaClientes.getItems().clear();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = clienteDao.listarClientes();
        clientesObservableList.addAll(clientes);
        colid.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getId())));
        coldni.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacion.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacion())));
        colFechaActualizacion.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaActualizacion())));
        tablaClientes.setItems(clientesObservableList);

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarCliente(newValue);
                    }
                }
        );

    }

    private void seleccionarCliente(Cliente cliente) {

        idCliente = cliente.getId();
    }

    public void onInsertarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        if (idCliente == 0) {
            cliente.setDni(dniText.getText());
            cliente.setNombre(nombreText.getText());
            cliente.setApellido(apellidoText.getText());
            cliente.setDireccion(direccionText.getText());
            cliente.setFechaCreacion(new Date());
            cliente.setFechaActualizacion(new Date());
            clienteDao.insertarCliente(cliente);
        } else {
            cliente.setId(idCliente);
            cliente.setDni(dniText.getText());
            cliente.setNombre(nombreText.getText());
            cliente.setApellido(apellidoText.getText());
            cliente.setDireccion(direccionText.getText());
            cliente.setFechaActualizacion(new Date());
            clienteDao.actulizarCliente(cliente);
        }

        listarClientes();
        onLimpiarButtonClick(null);
        idCliente = 0;
        guardarBtn.setText("Guardar");
    }

    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        dniText.clear();
        nombreText.clear();
        apellidoText.clear();
        direccionText.clear();
        guardarBtn.setText("Guardar");
        idCliente = 0;
    }

    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.clientePorId(idCliente);
        dniText.setText(cliente.getDni());
        nombreText.setText(cliente.getNombre());
        apellidoText.setText(cliente.getApellido());
        direccionText.setText(cliente.getDireccion());
        guardarBtn.setText("Guardar Editar");
    }

    public void eliminarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.eliminarClientePorId(idCliente);
        listarClientes();
    }


}