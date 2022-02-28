package users;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import core.AppendableObjectOutputStream;
import core.Grade;
import core.User;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Trainer extends User { 
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Trainer(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }

    public Trainer()
    {
        //Todo
    }

    public void gradesubmission(String id,String sec,String grade)
    {
        File f = null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
          
            f = new File("src/Files/Trainer/grade.bin");
            if(f.exists()) {
                fos = new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Grade s=new Grade(
                id,
                sec,	
                grade		
            );
                
            oos.writeObject(s);
        } catch (IOException ex) {
            //Todo;
        } finally {
          try {
              if(oos != null) oos.close();
          } catch (IOException ex) {
              //todo
          }
      }
    }

    public void bookaircrift(String name,LocalDate date,String time,String purpose)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/Trainer/bookAir.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
                "Air Crift Name : "+name+
                "Selected Date : "+date+
                ", Time : "+time+","+	
                ", purpose : "+purpose+"\n"
               		
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

    public void viewmedicalReport(TextArea tex,String s,Label l1)
    {
        tex.setText("");
        File f=null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str="";
        try{
            f = new File("src/Files/MedicalStaff/"+s+"Report.bin");
            if(!f.exists()){
                l1.setText("Not Found");
            }
            else{
                l1.setText("Found");
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str+= "Report Of "+s+"\n"
                    +"Test 1 : "+dis.readUTF()+"\n"
                    +"Test 2 : "+dis.readUTF()+"\n"
                    +"Test 3 : "+dis.readUTF()+"\n";
                   
                }
            }
        }catch (IOException ex) {
            tex.setText(str);
            //todo
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                //todo
            }
        }   
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

    public void studentinfo(String s,TextArea infromTextArea,Label viewmsgLevel)
    {
        infromTextArea.setText("");
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/Trainer/"+s+".txt");
            sc = new Scanner(f);
            if(f.exists()){
                viewmsgLevel.setText("Found");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    infromTextArea.appendText(
                            "Name ="+tokens[0]
                            +", ID ="+tokens[1]
                            +", Email ="+tokens[2]
                            +", Subject ="+tokens[3]+"\n"                    
                    );
                }
            }
            else 
                viewmsgLevel.setText("Not Found");
        } 
        catch (IOException ex) {
            //todo
        } 
        finally {
             //todo
        }        
    }

    public void showcourseCadetList(String optionChosen,TextArea courseview)
    {
        if (optionChosen == "Fly101")
        {
         
        File file = new File("src/Files/CourseAdmin/Fly101.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            courseview.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                courseview.appendText(str+"\n");
              
            }
        } catch (FileNotFoundException ex) {
            //todo
        }   
        }
        else{
            File file = new File("src/Files/CourseAdmin/Fly102.txt");
            Scanner sc; String str=null;
            try {
                sc = new Scanner(file);
                courseview.setText(null);
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    courseview.appendText(str+"\n");
                             
                }
            } catch (FileNotFoundException ex) {
                //todo
            }   
        }
    }
}
