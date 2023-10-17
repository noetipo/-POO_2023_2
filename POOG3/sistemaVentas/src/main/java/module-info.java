module com.example.sistemaventas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.sistemaventas to javafx.fxml;
    exports com.example.sistemaventas;
    exports com.example.sistemaventas.controlador;
    opens com.example.sistemaventas.controlador to javafx.fxml;
}