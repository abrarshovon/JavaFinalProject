package cqu.assignment2phase1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Abrar
 */
public class FXMLController implements Initializable {

    @FXML private Label titleLabel;
    @FXML private TextField shopCapacityField;
    @FXML private TextField durationField;
    @FXML private TextField fileNameField;
    @FXML private TextArea summaryTextArea;
    @FXML private Button runButton;
    @FXML private Button resetButton;
    @FXML private Button saveButton;
    @FXML private Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization if needed
    }

    @FXML
    private void handleRun() {
        String capacity = shopCapacityField.getText().trim();
        String duration = durationField.getText().trim();

        if (capacity.isEmpty() || duration.isEmpty()) {
            summaryTextArea.appendText("Error: Please enter both capacity and duration.\n");
            return;
        }

        try {
            int cap = Integer.parseInt(capacity);
            int dur = Integer.parseInt(duration);
            summaryTextArea.appendText("Simulation started with capacity " + cap + " for duration " + dur + " minutes.\n");
            // Add actual simulation logic here
        } catch (NumberFormatException e) {
            summaryTextArea.appendText("Error: Capacity and duration must be numbers.\n");
        }
    }

    @FXML
    private void handleReset() {
        shopCapacityField.clear();
        durationField.clear();
        fileNameField.clear();
        summaryTextArea.clear();
    }

    @FXML
    private void handleSave() {
        String fileName = fileNameField.getText().trim();
        String content = summaryTextArea.getText();

        if (fileName.isEmpty()) {
            summaryTextArea.appendText("Error: Please enter a file name.\n");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            writer.write(content);
            summaryTextArea.appendText("Summary saved to " + fileName + ".txt\n");
        } catch (IOException e) {
            summaryTextArea.appendText("Error: Failed to save file.\n");
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
