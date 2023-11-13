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
    private TableColumn<Cliente, String> colDni;
    @FXML
    public TableColumn<Cliente, String> colNombre;
    @FXML
    public TableColumn<Cliente, String> colDireccion;
    @FXML
    public TableColumn<Cliente, String> colFechaCreacion;
    @FXML
    private TextField dniText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField direccionText;

    @FXML
    public Button guardarBtn;
    Integer idCliente = 0;
    private ObservableList<Cliente> clientesObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarClientes();

    }

    public void listarClientes() {
        tablaClientes.getItems().clear();

        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = clienteDao.listarClientes();
        clientesObservableList.addAll(clientes);
        colDni.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacion.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacion())));
        tablaClientes.setItems(clientesObservableList);

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarCategoria(newValue);
                    }
                }
        );

    }

    private void seleccionarCategoria(Cliente cliente) {
        idCliente = cliente.getId();
    }

    public void onInsertarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        if (idCliente == 0) {
            cliente.setDni(dniText.getText());
            cliente.setNombre(nombreText.getText());
            cliente.setDireccion(direccionText.getText());
            cliente.setFechaCreacion(new Date());
            clienteDao.insertarCliente(cliente);
        } else {
            cliente.setId(idCliente);
            cliente.setDni(dniText.getText());
            cliente.setNombre(nombreText.getText());
            cliente.setDireccion(direccionText.getText());
            clienteDao.actulizarCliente(cliente);


        }
        idCliente = 0;
        onLimpiarButtonClick(null);
        listarClientes();
        guardarBtn.setText("Guardar");
    }

    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        dniText.clear();
        nombreText.clear();
        direccionText.clear();
    }

    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.clientePorId(idCliente);
        dniText.setText(cliente.getDni());
        nombreText.setText(cliente.getNombre());
        direccionText.setText(cliente.getDireccion());
        guardarBtn.setText("Guardar Editar");
    }

    public void eliminarButtonClick(ActionEvent actionEvent) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.eliminarClientePorId(idCliente);
        listarClientes();
    }
}
