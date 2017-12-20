package com.consulting.doctor.consulting.Model;

/**
 * Created by pritesh on 10/7/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datee {

    @SerializedName("T_id")
    @Expose
    private String tId;
    @SerializedName("Doctor_Name")
    @Expose
    private String doctorName;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("From_Time")
    @Expose
    private String fromTime;
    @SerializedName("To_Time")
    @Expose
    private String toTime;
    @SerializedName("No_Of_Hrs")
    @Expose
    private String noOfHrs;
    @SerializedName("Day")
    @Expose
    private String day;

    public String getTId() {
        return tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getNoOfHrs() {
        return noOfHrs;
    }

    public void setNoOfHrs(String noOfHrs) {
        this.noOfHrs = noOfHrs;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}