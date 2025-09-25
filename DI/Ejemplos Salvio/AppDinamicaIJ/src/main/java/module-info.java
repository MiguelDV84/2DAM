module com.dam.appdinamicaij {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.dam.appdinamicaij to javafx.fxml;
    exports com.dam.appdinamicaij;
}