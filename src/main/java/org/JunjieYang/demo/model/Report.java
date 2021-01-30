package org.JunjieYang.demo.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class Report {
    @Id
    String id;

    String user;

    String report;

    Date date = new Date();

    Boolean morning;

    public MorningReport(){}

    public MorningReport(String pUser, String pReport, Date pDate){
        user = pUser;
        report = pReport;
        date = pDate;
    }

    public void setId(String pId){
        id = pId;
    }
    public String getId(){
        return id;
    }

    public void setUser(String pUser){
        user = pUser;
    }
    public String getUser(){
        return user;
    }

    public void setReport(String pReport){
        report = pReport;
    }
    public Stirng getReport(){
        return report;
    }

    public void setDate(Date pDate){
        date = pDate;
    }
    public String getDate(){
        return date;
    }

    publiv void setMorning(Boolean pMorning ){
        morning = pMorning;
    }
    public Boolean getMorning(){
        return morning;
    }
}
