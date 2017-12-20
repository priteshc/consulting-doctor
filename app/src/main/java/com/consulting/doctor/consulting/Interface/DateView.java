package com.consulting.doctor.consulting.Interface;

import com.consulting.doctor.consulting.Model.Datee;
import com.consulting.doctor.consulting.Model.Doctor;

import java.util.List;

/**
 * Created by pritesh on 10/2/2017.
 */

public interface DateView {


    void showErrorMeassage();

    void showLoginSuccessMsg(List<Datee> dateeList);

    void showprogress();

    void hideprogress();


}
