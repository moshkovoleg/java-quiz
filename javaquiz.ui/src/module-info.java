module javaquiz.ui {
    requires javafx.fxml;
    requires javafx.controls;
    requires javaquiz.db;

    exports javaquiz.ui to javafx.graphics;
    opens javaquiz.ui to javafx.fxml;
}