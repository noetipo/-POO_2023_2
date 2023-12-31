package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.CategoriaDao;
import com.example.sistemaventas.modelo.dominio.Categoria;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView<Categoria> tablaCategorias;
    @FXML
    private TableColumn<Categoria, String> colCodigo;
    @FXML
    public TableColumn<Categoria, String> colNombre;
    @FXML
    public TableColumn<Categoria, String> colDescripcion;
    @FXML
    public TableColumn<Categoria, String> colFechaCreacion;
    @FXML
    private TextField codigoText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField descripcionText;
    private ObservableList<Categoria> categoriasObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarCategorias();

    }

    public void listarCategorias() {
        CategoriaDao categoriaDao = new CategoriaDao();
        List<Categoria> categorias = categoriaDao.listarCategorias();
        categoriasObservableList.addAll(categorias);
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacion.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacion())));
        tablaCategorias.setItems(categoriasObservableList);
    }
    public void onInsertarButtonClick(ActionEvent actionEvent) {
        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria categoria = new Categoria();
        categoria.setCodigo(codigoText.getText());
        categoria.setNombre(nombreText.getText());
        categoria.setDescripcion(descripcionText.getText());
        categoria.setFechaCreacion(new Date());
        categoriaDao.insertarCategoria(categoria);
        listarCategorias();
        onLimpiarButtonClick(null);
    }


    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        codigoText.clear();
        nombreText.clear();
        descripcionText.clear();
    }
}