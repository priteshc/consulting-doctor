package com.consulting.doctor.consulting.Model;

/**
 * Created by pritesh on 10/24/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Request {

    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("resend")
    @Expose
    private String resend;

    /**
     *
     * @return
     * The mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     *
     * @param mobileNo
     * The MobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     *
     * @return
     * The resend
     */
    public String getResend() {
        return resend;
    }

    /**
     *
     * @param resend
     * The resend
     */
    public void setResend(String resend) {
        this.resend = resend;
    }

}