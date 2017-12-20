package com.consulting.doctor.consulting.BackTask;


import com.consulting.doctor.consulting.Model.DatePojo;
import com.consulting.doctor.consulting.Model.DoctorPojo;
import com.consulting.doctor.consulting.Model.Request;
import com.consulting.doctor.consulting.Model.Sendpdata;
import com.consulting.doctor.consulting.Model.Sendsms;
import com.consulting.doctor.consulting.Model.Verify;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pritesh on 3/27/2017.
 */

public interface AllApi {


    @GET("/php/Doctor_List.php")
    Call<DoctorPojo> getList();


    @FormUrlEncoded
    @POST("/php/Doctor_LocationList.php")
    Call<DatePojo> gettime(@Field("name") String name, @Field("location") String loc);


    @POST("/php/send_otp_sms.php")
    Call<Sendsms> getSmsdata(@Body Request request);

    @FormUrlEncoded
    @POST("/php/Check_Otp.php")
    Call<Verify> getGetverif(@Field("MobileNo") String mob, @Field("OtpNo") String otp);


    @FormUrlEncoded
    @POST("/php/Insert_Patient.php")
    Call<Sendpdata> getPdata(@Field("Location_Id") String id, @Field("Location_Name") String name , @Field("Appointment_Date") String apdat , @Field("Patient_Name") String pname , @Field("Schedule_Id") String schid , @Field("Schedule_Name") String schname  , @Field("MobileNo") String pmno , @Field("Address") String paddr , @Field("Email") String pmail , @Field("Patient_Type") String ptyp , @Field("OTP_MobileNo") String otpmob , @Field("OTP_Code") String otc , @Field("Payment_Mode") String paymod , @Field("Amount") String amt, @Field("Coupon_Id") String code);



}
