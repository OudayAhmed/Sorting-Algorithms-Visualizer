module com.ouday {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    requires org.kordamp.iconli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome;

    opens com.ouday.controller to javafx.fxml;
    exports com.ouday;
}