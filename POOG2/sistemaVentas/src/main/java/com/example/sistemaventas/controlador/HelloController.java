package com.example.sistemaventas.controlador;

import com.example.sistemaventas.modelo.dao.CategoriaDao;
import com.example.sistemaventas.modelo.dominio.Categoria;
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

    @FXML
    public Button guardarBtn;
    Integer idCategoria = 0;
    private ObservableList<Categoria> categoriasObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarCategorias();

    }

    public void listarCategorias() {
        tablaCategorias.getItems().clear();

        CategoriaDao categoriaDao = new CategoriaDao();
        List<Categoria> categorias = categoriaDao.listarCategorias();
        categoriasObservableList.addAll(categorias);
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        colFechaCreacion.setCellValueFactory(cellData -> new SimpleStringProperty(formatter.format(cellData.getValue().getFechaCreacion())));
        tablaCategorias.setItems(categoriasObservableList);

        tablaCategorias.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarCategoria(newValue);
                    }
                }
        );

    }
    public void onInsertarButtonClick(ActionEvent actionEvent) {
        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria categoria = new Categoria();
        if (idCategoria == 0) {
            categoria.setCodigo(codigoText.getText());
            categoria.setNombre(nombreText.getText());
            categoria.setDescripcion(descripcionText.getText());
            categoria.setFechaCreacion(new Date());
            categoriaDao.insertarCategoria(categoria);
        } else {
            categoria.setId(idCategoria);
            categoria.setCodigo(codigoText.getText());
            categoria.setNombre(nombreText.getText());
            categoria.setDescripcion(descripcionText.getText());
            categoriaDao.actulizarCategoria(categoria);


        }
        idCategoria = 0;
        onLimpiarButtonClick(null);
        listarCategorias();
        guardarBtn.setText("Guardar");
    }


    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        codigoText.clear();
        nombreText.clear();
        descripcionText.clear();
    }
    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria categoria = categoriaDao.categoriaPorId(idCategoria);
        codigoText.setText(categoria.getCodigo());
        nombreText.setText(categoria.getNombre());
        descripcionText.setText(categoria.getDescripcion());
        guardarBtn.setText("Guardar Editar");
    }

    private void seleccionarCategoria(Categoria categoria) {
        System.out.println(categoria.getId());
        idCategoria = categoria.getId();
    }
    public void eliminarButtonClick(ActionEvent actionEvent) {
        CategoriaDao categoriaDao = new CategoriaDao();
        categoriaDao.eliminarCategoriaPorId(idCategoria);
        listarCategorias();
    }

}