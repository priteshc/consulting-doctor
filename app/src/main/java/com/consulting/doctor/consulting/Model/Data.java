package com.consulting.doctor.consulting.Model;

/**
 * Created by pritesh on 10/24/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("otp_mst_id")
    @Expose
    private String otpMstId;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("otp_number")
    @Expose
    private String otpNumber;

    /**
     *
     * @return
     * The otpMstId
     */
    public String getOtpMstId() {
        return otpMstId;
    }

    /**
     *
     * @param otpMstId
     * The otp_mst_id
     */
    public void setOtpMstId(String otpMstId) {
        this.otpMstId = otpMstId;
    }

    /**
     *
     * @return
     * The mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     * The mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     * The otpNumber
     */
    public String getOtpNumber() {
        return otpNumber;
    }

    /**
     *
     * @param otpNumber
     * The otp_number
     */
    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

}