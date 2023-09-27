module com.among_us {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.among_us to javafx.fxml;
    exports com.among_us;
}
