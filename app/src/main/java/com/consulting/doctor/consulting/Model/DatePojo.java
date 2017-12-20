package com.consulting.doctor.consulting.Model;

/**
 * Created by pritesh on 10/7/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatePojo {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("data")
    @Expose
    private List<Datee> data = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Datee> getData() {
        return data;
    }

    public void setData(List<Datee> data) {
        this.data = data;
    }

}