module com.example.ssd4exercise4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ssd4exercise4 to javafx.fxml;
    exports com.example.ssd4exercise4;
}