module com.example.democha {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jedis;

    opens com.example.democha to javafx.fxml;
    exports com.example.democha;
}