package users;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import core.User;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MedicalStaff extends User {

    private static final long serialVersionUID = 1L;

    public MedicalStaff(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }
    
    public MedicalStaff()
    {

    }

    public void viewnotice(Label t)
    {
        t.setText("");
        File file = new File("src/Files/Administrator/AdmissionNotice.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            t.setText(null);
            while(sc.hasNextLine()){
              str=sc.nextLine();
              t.setText(str+"\n");
                            
            }
        } catch (FileNotFoundException ex) {
           //todo
        }   
    }

    public void previousreports(String s,TextArea viewFileTextArea)
    {
        File file = new File("src/Files/MedicalStaff/"+s+".txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            viewFileTextArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                viewFileTextArea.appendText(str+"\n");         
            }
        } catch (FileNotFoundException ex) {
           //todo
        }   
    }

    public void goods(String s,String s2,String s3,String s4)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/MedicalStaff/goods.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
               s+","+s2+","+s3+","+s4	
            );           
           
        } catch (IOException ex) {
           //todo
        } finally {
          try {
              if(fw != null) fw.close();
          } catch (IOException ex) {
            //todo
          }
      }
    }

    public void createmedicalreport(String fName,String test1,String test2,String test3)
    {
        File f = null;
        FileOutputStream fos=null;
        DataOutputStream dos=null;
        try {
          
            f = new File("src/Files/MedicalStaff/"+fName+"Report.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
           
                dos.writeUTF(test1); 
                dos.writeUTF(test2);   
                dos.writeUTF(test3); 
                
             
        } catch (IOException ex) {
            //todo
        } finally {
          try {
              if(dos != null) dos.close();
          } catch (IOException ex) {
            //todo
          }
      }
    }
    
}
