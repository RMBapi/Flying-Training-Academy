package scnce.HeadOfTheAcademy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import users.HeadOfTheAcad;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ReportController implements Initializable{
    
    private ArrayList<String> fileTypeList;
    @FXML public TextArea viewfileTextArea; 
    @FXML public CheckBox editfileContentCheckBox;
    @FXML public TextArea editfileTextArea;
    @FXML public Label printmsg;
    
    public void initialize(URL url, ResourceBundle rb) { 
     
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
        
    }

    @FXML 
    void singleFileChooserMenuItemOnClick(){
               HeadOfTheAcad h1=new HeadOfTheAcad();
               h1.reportview(fileTypeList,viewfileTextArea);
    }

    
    @FXML
    private void editfileCheckBoxOnClick(ActionEvent event) {
                   if(editfileContentCheckBox.isSelected()){
                    editfileTextArea.setEditable(true);
                    editfileTextArea.setText(viewfileTextArea.getText());
                }
                else{
                    editfileTextArea.setText(null);
                    editfileTextArea.setEditable(false);
                }
            }
    @FXML
    public void savechangesonClick(ActionEvent event)throws Exception{
        printmsg.setText("Edited");
        try {
            File file = new File("src/Files/Administrator/AdmissionNotice.txt");
            if (!file.exists()) {
               //todo
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write( editfileTextArea.getText());
            out.newLine();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    private void backtoHTDONClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/scnce/HeadOfTheAcademy/headOftheAcademy.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
}
    