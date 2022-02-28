package users;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import core.User;

public class userFileCreate {
    public static void main(String[] args) {
    
        ArrayList u = new ArrayList<User>();
        u.add(new User("admin", "admin", "admin", "Administrator", "000000000", "000-000-000-00-00"));
        u.add(new User("admin", "admin", "admin", "Trainer", "000000000", "000-000-000-00-00"));
        u.add(new User("admin", "admin", "admin", "HeadOfTheAcademy", "000000000", "000-000-000-00-00"));
        u.add(new User("admin", "admin", "admin", "Cadet", "000000000", "000-000-000-00-00"));
        u.add(new User("admin", "admin", "admin", "CourseAdmin", "000000000", "000-000-000-00-00"));
        u.add(new User("admin", "admin", "admin", "MedicalStaff", "000000000", "000-000-000-00-00"));
      

        try {
            FileOutputStream file = new FileOutputStream("src/Files/users/loginUsers.bin");
            ObjectOutputStream out = new ObjectOutputStream(file);
            for (Object user : u)
                out.writeObject((User) user);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/users/loginUsers.bin"));
            User d;
            while (true) {
                d = (User) in.readObject();
                System.out.println(d.toString());
            }
            // in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}