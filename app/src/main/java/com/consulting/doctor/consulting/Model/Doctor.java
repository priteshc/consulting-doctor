package com.consulting.doctor.consulting.Model;

/**
 * Created by pritesh on 10/2/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("Doc_Id")
    @Expose
    private String docId;
    @SerializedName("Doc_Name")
    @Expose
    private String docName;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("From_Time")
    @Expose
    private String fromTime;
    @SerializedName("To_Time")
    @Expose
    private String toTime;
    @SerializedName("Total_Hours")
    @Expose
    private String totalHours;
    @SerializedName("Day")
    @Expose
    private String day;
    @SerializedName("Specialization")
    @Expose
    private String specialization;
    @SerializedName("Experience")
    @Expose
    private String experience;
    @SerializedName("Fees")
    @Expose
    private String fees;
    @SerializedName("Clinic_Name")
    @Expose
    private String clinicName;
    @SerializedName("Login_name")
    @Expose
    private String loginName;
    @SerializedName("Password")
    @Expose
    private String password;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
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

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}