package users;

import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import core.BAccount;
import core.User;
import core.meeting;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class HeadOfTheAcad extends User { 
   
    private static final long serialVersionUID = 1L;

    public HeadOfTheAcad(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }

    public HeadOfTheAcad()
    {

    }
    public void viewaccademicAccount(TableView<BAccount> tableView)
    {
        ObjectInputStream ois=null;
        try {
           BAccount s;
           ois = new ObjectInputStream(new FileInputStream("src/Files/Administrator/Accounts.bin"));
           while(true){
           s = (BAccount) ois.readObject();
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

    public void viewmeetingschadule(TableView<meeting> tableview2)
    {
        ObjectInputStream ois=null;
         try {
            meeting s;
            ois = new ObjectInputStream(new FileInputStream("src/Files/Administrator/Createmeeting.bin"));
            while(true){
            s = (meeting) ois.readObject();
            s.display();
            tableview2.getItems().add(s);
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

public void viewlivechartreport(LineChart<String, Number> lineChart)
{ 
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/Administrator/annualreport.txt");
            sc = new Scanner(f);
            if(f.exists()){
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                
                    XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
                    series.getData().add(new XYChart.Data<String,Number>(tokens[0]+"1sttake",Integer.parseInt(tokens[1])));
                    series.getData().add(new XYChart.Data<String,Number>(tokens[0]+"2ndtake",Integer.parseInt(tokens[2])));
                    series.getData().add(new XYChart.Data<String,Number>(tokens[0]+"3ndtake",Integer.parseInt(tokens[3])));
                    series.setName("2019");  
                   
                    XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
                    series2.getData().add(new XYChart.Data<String,Number>("2020 1sttake",1020));
                    series2.getData().add(new XYChart.Data<String,Number>("2020 2ndtake",860));
                    series2.getData().add(new XYChart.Data<String,Number>("2020 3ndtake",560));
                    series2.setName("2020");
        
                    lineChart.getData().addAll(series,series2);
                }
            }
        } catch (IOException ex) {
            //todo
        } 
         finally {
            //todo
        }       
    }

    public void annualIncome(PieChart pieChart)
    {
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/Administrator/annualreport2.txt");
            sc = new Scanner(f);
            if(f.exists()){
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    ObservableList<Data> list = FXCollections.observableArrayList(
                        new PieChart.Data("Summer",Integer.parseInt(tokens[0])),
                        new PieChart.Data("Spring",Integer.parseInt(tokens[1])),
                        new PieChart.Data("Autumn",Integer.parseInt(tokens[2]))
                    );
                    pieChart.setData(list);
                }
                
            }
        } catch (IOException ex) {
            //todo
        } 
         finally {
            //todo
        }  
    }

    public void viewAcademicComplain(String optionChosen,TextArea complaintextArea)
    {
        if (optionChosen == "Trainer")
        {
            complaintextArea.setText("");
            File file = new File("src/Files/Cadet/Faculty.txt");
            Scanner sc; String str=null;
            try {
                sc = new Scanner(file);
                complaintextArea.setText(null);
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    complaintextArea.appendText(str+"\n");
                                
                }
            } catch (FileNotFoundException ex) {
               //todo
            }   
        }
        else{
            complaintextArea.setText("");
            File file = new File("src/Files/Cadet/Academy.txt");
            Scanner sc; String str=null;
            try {
                sc = new Scanner(file);
                complaintextArea.setText(null);
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    complaintextArea.appendText(str+"\n");
                                
                }
            } catch (FileNotFoundException ex) {
               //todo
            }   
        }

    }

    public void reportview(ArrayList<String> fileTypeList,TextArea viewfileTextArea)
    {
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
                viewfileTextArea.setText(str);
            } catch (FileNotFoundException ex) {
                //todo
            }
        }
    }

}






