module com.example.nhanmessagehau {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
    requires jedis;

    opens com.example.nhanmessagehau to javafx.fxml;
    exports com.example.nhanmessagehau;
}