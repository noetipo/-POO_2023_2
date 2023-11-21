package com.example.sistemaventas.controlador;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController implements Initializable {
    public BorderPane bp;
    public AnchorPane ap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void home(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    public void categoria(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaventas/hello-view");
    }

    public void cliente(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaventas/cliente-view");
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, e);
        }
        bp.setCenter(root);
    }

    public void producto(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaventas/producto-view");
    }

    public void venta(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaventas/venta-view");
    }

    public void venta2(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaventas/venta-view2");
    }
}
