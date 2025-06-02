module cqu.assignment2phase1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens cqu.assignment2phase1 to javafx.fxml;
    exports cqu.assignment2phase1;
}
