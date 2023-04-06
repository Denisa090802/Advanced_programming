module com.lab6.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires com.fasterxml.jackson.databind;


    opens com.lab6.lab6 to javafx.fxml;
    exports com.lab6.lab6;
}