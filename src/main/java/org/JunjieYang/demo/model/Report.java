package org.JunjieYang.demo.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    String worker;

    String report;

    Date date = new Date();

    Boolean morning;

    public Report(){}

    public Report(String pUser, String pReport){
        worker = pUser;
        report = pReport;
    }

    public void setWorker(String pUser){
        worker = pUser;
    }
    public String getWorker(){
        return worker;
    }

    public void setReport(String pReport){
        report = pReport;
    }
    public String getReport(){
        return report;
    }

    public void setDate(Date pDate){
        date = pDate;
    }
    public Date getDate(){
        return date;
    }

    public void setMorning(Boolean pMorning ){
        morning = pMorning;
    }
    public Boolean getMorning(){
        return morning;
    }
}
