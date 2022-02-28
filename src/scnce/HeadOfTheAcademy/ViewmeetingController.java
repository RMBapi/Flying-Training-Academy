package scnce.HeadOfTheAcademy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


import core.meeting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import users.HeadOfTheAcad;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewmeetingController implements Initializable{
     
    @FXML private TableView<meeting> tableView;
    @FXML private TableColumn<meeting, String> tableMeetingIDColumn;
    @FXML private TableColumn<meeting, String> tablePurposeColumn;
    @FXML private TableColumn<meeting, String> tableTimecolumn;
    @FXML private TableColumn<meeting, String> tableDatecolumn;
    @FXML private TableColumn<meeting, String> tableapprovalColumn;
    
    public void initialize(URL url, ResourceBundle rb) { 
        tableMeetingIDColumn.setCellValueFactory(new PropertyValueFactory<meeting, String>("meetingId"));
        tablePurposeColumn.setCellValueFactory(new PropertyValueFactory<meeting, String>("purpose"));
        tableTimecolumn.setCellValueFactory(new PropertyValueFactory<meeting, String>("time"));
        tableDatecolumn.setCellValueFactory(new PropertyValueFactory<meeting, String>("date"));
        tableapprovalColumn.setCellValueFactory(new PropertyValueFactory<meeting,String>("appoval"));

        loadmeetingFile();
        tableView.setEditable(true);
        tableapprovalColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        

        
    }

    @FXML
    private void loadmeetingFile() {
        HeadOfTheAcad h2 = new HeadOfTheAcad();
        h2.viewmeetingschadule(tableView);
    }

    public void changePurposeCellEvent(CellEditEvent edittedCell){
        meeting personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setAppoval(edittedCell.getNewValue().toString());
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