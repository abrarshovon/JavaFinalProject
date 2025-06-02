package cqu.assignment2phase1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
private ShopModel shopModel;
private ShopSimulator simulator;
private Report report; // will use from Phase 3 on


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
        summaryTextArea.clear();
        String capacityStr = shopCapacityField.getText().trim();
        String durationStr = durationField.getText().trim();

        if (capacityStr.isEmpty() || durationStr.isEmpty()) {
            summaryTextArea.appendText("Error: Please enter both capacity and duration.\n");
            return;
        }

        try {
            int cap = Integer.parseInt(capacityStr);
            int dur = Integer.parseInt(durationStr);
            if (cap <= 0 || dur <= 0) {
                summaryTextArea.appendText("Error: Capacity and duration must be positive integers.\n");
                return;
            }

            shopModel = new ShopModel(cap);
            simulator = new ShopSimulator(shopModel);
            simulator.initialize(new ArrivalEvent(0));
            simulator.run(dur);

            summaryTextArea.appendText("Simulation completed. Check the console for trace.\n");
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
