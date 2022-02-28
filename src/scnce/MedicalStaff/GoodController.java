package scnce.MedicalStaff;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import users.MedicalStaff;
import javafx.stage.Stage;
import javafx.scene.Node;

public class GoodController implements Initializable {
    
    @FXML public TextField  nameTextField;
    @FXML public TextField  quantityField;
    @FXML public TextField  reasonTextField;
    @FXML public TextField  gidTextField;

    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }

    @FXML
    private void applyforgoods(ActionEvent event) throws IOException {
        MedicalStaff m1 =new MedicalStaff();
        m1.goods(nameTextField.getText(),quantityField.getText(),reasonTextField.getText(),gidTextField.getText());
        nameTextField.clear();quantityField.clear();reasonTextField.clear();gidTextField.clear();
    }

    
    @FXML
    private void backtoStaff(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/scnce/MedicalStaff/medicalStaff.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

}
