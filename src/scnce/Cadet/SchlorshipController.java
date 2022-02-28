package scnce.Cadet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import users.cadet;

public class SchlorshipController implements Initializable {
     
    
    
    @FXML public ComboBox<String> incomeSource;
    @FXML public ComboBox<String> persentage;
    @FXML public TextField nameTextField;
    @FXML public TextField idTextField;
    @FXML public TextField addressTextField;
    @FXML public TextField salaryTextField;
    @FXML public TextArea viewInformationTextArea;
    @FXML public TextArea InformationEditTextArea;
    @FXML public CheckBox  editSchlorshipontentCheckBox;



    ObservableList<String> list1 = FXCollections.observableArrayList("Govt job", "Busness","Employee");
    ObservableList<String> list2 = FXCollections.observableArrayList("10%", "50%","60%");
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        incomeSource.setItems(list1);
        persentage.setItems(list2);
    }

    @FXML
    private void submitDetailsOnClick(ActionEvent event) {   
        cadet c1 =new cadet(); 
        c1.applyForSchlorship(nameTextField.getText(),idTextField.getText(),addressTextField.getText(),incomeSource.getValue(),salaryTextField.getText(),persentage.getValue());   
        nameTextField.clear();idTextField.clear();addressTextField.clear();salaryTextField.clear();
    }

    @FXML
    private void viewsubmitInformationOnClick(ActionEvent event) {
        viewInformationTextArea.setText("");
        File file = new File("src/Files/Cadet/schlorship.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            viewInformationTextArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                viewInformationTextArea.appendText(str+"\n");
                            
            }
        } catch (FileNotFoundException ex) {
           //todo
        }   
    }  

    @FXML
    private void editSchlorshipContentOnClick(ActionEvent event) {
        if(editSchlorshipontentCheckBox.isSelected()){
            InformationEditTextArea.setEditable(true);
            InformationEditTextArea.setText(viewInformationTextArea.getText());
        }
        else{
            InformationEditTextArea.setText(null);
            InformationEditTextArea.setEditable(false);
        }
    }


    @FXML
    public void saveEditedSchfile(ActionEvent event)throws Exception{
        try {
            File file = new File("src/Files/Cadet/schlorship.txt");
            if (!file.exists()) {
               //todo
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(InformationEditTextArea.getText());
            out.newLine();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
       
       
    }

    @FXML
    private void goBackToCadetSceneOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/Cadet/cadet2.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

}
