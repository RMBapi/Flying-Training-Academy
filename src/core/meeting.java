package core;
import java.io.Serializable;


public class meeting implements Serializable {
    String meetingId;
    String purpose;  
    String time;
    String date;
    String appoval;
    
    
    public meeting(String meetingId,String purpose,String time,String date,String appoval) {  
        this.meetingId=meetingId;
        this.purpose=purpose;
        this.time = time;  
        this.date = date;
        this.appoval = appoval;
    }
    
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public void setTime(String time) {
        this.time = time;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setAppoval(String appoval) {
        this.appoval = appoval;
    }
     
    public String getMeetingId() {
        return meetingId;
    }
    
    public String getPurpose() {
        return purpose;
    }
    public String getTime() {
        return time;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getAppoval() {
        return appoval;
    }
    
    @Override
    public String toString(){
        return "Meeting ID="+meetingId+",Purpose="+purpose+", Time="+time+", Date="+date+", Appoval="+appoval;
    }
    
    public void display(){
        System.out.println("Meeting ID="+meetingId+",Purpose="+purpose+", Time="+time+", Date="+date+", Appoval="+appoval);
    }
}
