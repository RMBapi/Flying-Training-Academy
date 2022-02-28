package scnce.Administrator;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import users.Administrator;

import java.util.logging.Level;
import java.util.logging.Logger;

import core.AppendableObjectOutputStream;
import core.BAccount;
import core.meeting;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AccountController implements Initializable {

   
    @FXML public TextField  accTypeTextField;
    @FXML public TextField  transTextField;
    @FXML public TextField  debitTextField;
    @FXML public TextField  crditTextField;
    @FXML public TextField  takaTextField;
    @FXML public TextArea   viewAccountList;
  
   
    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }
   
    @FXML
    public void acccreateButtononClick(ActionEvent event) throws IOException{
       Administrator A1=new Administrator();
       A1.accountsInformation(accTypeTextField.getText(),transTextField.getText(),debitTextField.getText(),crditTextField.getText(),takaTextField.getText());
       accTypeTextField.clear();transTextField.clear();debitTextField.clear();crditTextField.clear();
       takaTextField.clear();
    }
    
    @FXML
    private void viewAccountListOnClick(ActionEvent event) {
       Administrator A2 =new Administrator();
       A2.viewcreatedAccount(viewAccountList);

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