module Comunicacion {
    requires transitive javafx.fxml;
    requires transitive javafx.controls;

    opens sample to javafx.fxml;
    exports sample;
}