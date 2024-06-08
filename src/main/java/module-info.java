module javafx.maman14q2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens q2 to javafx.fxml;
    exports q2;
}