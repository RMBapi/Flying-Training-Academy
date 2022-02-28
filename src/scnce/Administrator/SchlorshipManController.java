package scnce.Administrator;
import core.SchManTable;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javafx.stage.Stage;
import users.Administrator;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SchlorshipManController implements Initializable {
    
    @FXML public TextArea viewApplicantTextArea;
    @FXML public TextField addnameColumnTextField;
    @FXML public TextField addidColumnTextField;
    @FXML public TextField addparsentageColumnTextField;

    @FXML private TableView<SchManTable> tableView;
    @FXML private TableColumn<SchManTable, String> nameColumn;
    @FXML private TableColumn<SchManTable, String> idColumn;
    @FXML private TableColumn<SchManTable, String> parsentageColumn;

    public void initialize(URL arg0, ResourceBundle arg1) {
       
        nameColumn.setCellValueFactory(new PropertyValueFactory<SchManTable,String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<SchManTable,String>("id"));
        parsentageColumn.setCellValueFactory(new PropertyValueFactory<SchManTable,String>("part"));

        tableView.setItems(getPeople()); 
        
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        parsentageColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    
    public ObservableList<SchManTable> getPeople(){
        ObservableList<SchManTable> people = FXCollections.observableArrayList();
        //people.add(new SchManTable("Rafid Mhotasim", "1931181", "60%"));
      
        return people;
    } 

    @FXML
    public void addapplicantListButtonOnClick(){
        Administrator a =new Administrator();
        a.ViewapplicantList(addnameColumnTextField.getText(),addidColumnTextField.getText(),addparsentageColumnTextField.getText(),tableView);
        addnameColumnTextField.clear();addidColumnTextField.clear();addparsentageColumnTextField.clear();
        
    }

    @FXML
    private void viewApplicantInformationOnClick(ActionEvent event) {
        Administrator a2 = new Administrator();
        a2.viewApplicantList(viewApplicantTextArea);
    }  

    @FXML
    private void recordofgivenschlorshipOnClick(ActionEvent event) {
        Administrator a1 =new Administrator();
        a1.viewScholarshipApproveList(viewApplicantTextArea);
    }  

    @FXML
    private void deleteApplicantButtonOnClick(ActionEvent event) {
        ObservableList<SchManTable> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(SchManTable p: selectedRows){
            allPeople.remove(p);
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
