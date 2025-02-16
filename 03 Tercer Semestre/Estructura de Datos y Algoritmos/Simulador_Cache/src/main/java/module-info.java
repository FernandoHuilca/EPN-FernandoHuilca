module com.example.simulador_cache {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.simulador_cache to javafx.fxml;
    exports com.example.simulador_cache;
}