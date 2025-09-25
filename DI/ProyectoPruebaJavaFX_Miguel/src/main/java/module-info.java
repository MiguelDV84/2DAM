module org.mdv.proyectopruebajavafx_miguel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.mdv.proyectopruebajavafx_miguel to javafx.fxml;
    exports org.mdv.proyectopruebajavafx_miguel;
}