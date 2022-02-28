package scnce.Administrator;

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
import users.Administrator;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AnnualReportController implements Initializable {
    
    @FXML public TextField yearTextField;
    @FXML public TextField firstyearTextField;
    @FXML public TextField scndyearTextField;
    @FXML public TextField trdyearTextField;
    @FXML public TextField firstyearincomeTextField;
    @FXML public TextField scndyearincomeTextField;
    @FXML public TextField trdyearincomeTextField;

    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }

    @FXML
    private void annualreportOnclick(ActionEvent event) throws IOException {
          Administrator a1 = new Administrator();
          a1.annualrepot(yearTextField.getText(),firstyearTextField.getText(),scndyearTextField.getText(),trdyearTextField.getText());
          yearTextField.clear();firstyearTextField.clear();scndyearTextField.clear();trdyearTextField.clear();

    }

    @FXML
    private void annualrepor2tOnclick(ActionEvent event) throws IOException {
          Administrator a2 = new Administrator();
          a2.annualrepot2(firstyearincomeTextField.getText(),scndyearincomeTextField.getText(),trdyearincomeTextField.getText());
          firstyearincomeTextField.clear();scndyearincomeTextField.clear();trdyearincomeTextField.clear();

    }

    @FXML
    private void goBackToAddministrationSceneOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/Administrator/Administrator.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
}