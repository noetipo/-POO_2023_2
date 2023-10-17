package com.example.sistemaventas.controlador;




import com.example.sistemaventas.modelo.dao.CategoriaDao;
import com.example.sistemaventas.modelo.dominio.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class HelloController implements Initializable {


    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        CategoriaDao categoriaDao = new CategoriaDao();
        welcomeText.setText("Welcome to JavaFX Application!");
        List<Categoria> categorias = categoriaDao.listarCategorias();
        for (Categoria categoria : categorias
        ) {
            System.out.println(categoria.toString());
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoriaDao categoriaDao = new CategoriaDao();
        welcomeText.setText("Lista categoria!");
        List<Categoria> categorias = categoriaDao.listarCategorias();
        for (Categoria categoria : categorias
        ) {
            System.out.println(categoria.toString());
        }
    }


    public void onInsertarButtonClick(ActionEvent actionEvent) {
        CategoriaDao categoriaDao = new CategoriaDao();
        welcomeText.setText("Insertando!");
        Categoria categoria = new Categoria();
        categoria.setCodigo("5900");
        categoria.setNombre("Computadora");
        categoria.setDescripcion("Computadora");
        categoria.setFechaCreacion(new Date());
        categoriaDao.insertarCategoria(categoria);


    }
}
