package scnce.Cadet;
import  core.Grade;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;


public class ResultController implements Initializable {

    @FXML private Label lineChartLabel;
    @FXML private Button loadLineChartButton;
    @FXML private TextField textlop;
    @FXML private LineChart<String, Number> lineChart;
    @FXML private PieChart pieChart;
    @FXML private TableView<Grade> tableView;
    @FXML private TableColumn<Grade, String> iDColumn;
    @FXML private TableColumn<Grade, String> secColumn;
    @FXML private TableColumn<Grade, String> colcolumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iDColumn.setCellValueFactory(new PropertyValueFactory<Grade, String>("id"));
        secColumn .setCellValueFactory(new PropertyValueFactory<Grade, String>("sec"));
        colcolumn.setCellValueFactory(new PropertyValueFactory<Grade, String>("grad"));
   
        loadGrades();
        // TODO
    }    

    @FXML
    private void loadGrades() {
        ObjectInputStream ois=null;
        try {
           Grade s;
           ois = new ObjectInputStream(new FileInputStream("src/Files/Trainer/grade.bin"));
           while(true){
           s = (Grade) ois.readObject();
           s.display();
           tableView.getItems().add(s);
           }
           
       } catch (Exception ex) {
           try {
               if(ois!=null)
                   ois.close();
           } 
           catch (IOException e) {
               e.printStackTrace();
           }
           ex.printStackTrace();
       }        
    }


    @FXML
    private void loadLineChartButtonOnClick(ActionEvent event) {
        lineChart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("1st Semester",3.17));
        series.getData().add(new XYChart.Data<String,Number>("2nd Semester",3.25));
        series.getData().add(new XYChart.Data<String,Number>("3rd Semester",3.75));
        series.setName("2019");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("1st Semester",3.10));
        series2.getData().add(new XYChart.Data<String,Number>("2nd Semester",3.75));
        series2.getData().add(new XYChart.Data<String,Number>("3rd Semester",3.22));
        series2.setName("2020");
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.getData().add(new XYChart.Data<String,Number>("1st Semester",2.56));
        series3.getData().add(new XYChart.Data<String,Number>("2nd Semester",2.96));
        series3.getData().add(new XYChart.Data<String,Number>("3rd Semester",2.56));
        series3.setName("2021");
        
        lineChart.getData().addAll(series,series2,series3);
        
        for(XYChart.Data<String,Number> data: series.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series3.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }

    @FXML
    private void loadpieButtonOnClick(ActionEvent event) {
        ObservableList<Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Summer",60),
            new PieChart.Data("Spring",30),
            new PieChart.Data("Autumn",10)
        );

        pieChart.setData(list);
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
