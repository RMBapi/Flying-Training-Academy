package scnce.Administrator;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import users.Administrator;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Node;

public class NoticeBoardController implements Initializable {
   
    private ArrayList<String> fileTypeList; 
    @FXML private Label showfileLabel; 
    @FXML public TextField noticefilenameTextField;
    @FXML public TextField DescriptionTextField;
    @FXML public TextArea viewNoticeTextArea;
    @FXML public TextArea editNoticeTextArea;
    @FXML public CheckBox editnoticeContentCheckBox;

    
    public void initialize(URL arg0, ResourceBundle arg1) {
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
        
        editNoticeTextArea.setEditable(false);
    }

    @FXML
    public void createnoticefileonClick(ActionEvent event) throws IOException{
          
        Administrator a1 =new Administrator();
        a1.createNotice(noticefilenameTextField.getText(),DescriptionTextField.getText());
                
    }  
            
    @FXML 
    void singleFileChooserMenuItemOnClick(){
                FileChooser fc = new FileChooser();
                fc.getExtensionFilters().add(new ExtensionFilter("Text files", fileTypeList));
                File f = fc.showOpenDialog(null);
                if(f != null){
                    try {
                        Scanner sc = new Scanner(f);
                        String str="";
                        while(sc.hasNextLine()){
                            str+=sc.nextLine()+"\n";
                        }
                        viewNoticeTextArea.setText(str);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NoticeBoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

    @FXML
    private void editnoticeCheckBoxOnClick(ActionEvent event) {
                   if(editnoticeContentCheckBox.isSelected()){
                    editNoticeTextArea.setEditable(true);
                    editNoticeTextArea.setText(viewNoticeTextArea.getText());
                }
                else{
                    editNoticeTextArea.setText(null);
                    editNoticeTextArea.setEditable(false);
                }
            }
    @FXML
    public void savechangesonClick(ActionEvent event)throws Exception{
        try {
            File file = new File("src/Files/Administrator/AdmissionNotice.txt");
            if (!file.exists()) {
               //todo
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(editNoticeTextArea.getText());
            out.newLine();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
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