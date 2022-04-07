module com.example.marbelsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.marbelsproject to javafx.fxml;
    exports com.example.marbelsproject;
}