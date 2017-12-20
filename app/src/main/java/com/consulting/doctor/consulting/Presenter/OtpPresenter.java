package com.consulting.doctor.consulting.Presenter;

import com.consulting.doctor.consulting.BackTask.RetrofitBuild;
import com.consulting.doctor.consulting.Interface.DateView;
import com.consulting.doctor.consulting.Interface.OtpView;
import com.consulting.doctor.consulting.Model.DatePojo;
import com.consulting.doctor.consulting.Model.Request;
import com.consulting.doctor.consulting.Model.Sendsms;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class OtpPresenter {


    private OtpView otpView;

    private RetrofitBuild retrofitBuild;


    public OtpPresenter(OtpView otpView) {

        this.otpView = otpView;

        retrofitBuild = new RetrofitBuild();

    }



    public void getSms(Request request){

        otpView.showprogress();

        Call<Sendsms> pojoCall = retrofitBuild.allApi().getSmsdata(request);


        pojoCall.enqueue(new Callback<Sendsms>() {
            @Override
            public void onResponse(Call<Sendsms> call, Response<Sendsms> response) {

                otpView.hideprogress();

                otpView.showLoginSuccessMsg(response.body().getResponse());

            }

            @Override
            public void onFailure(Call<Sendsms> call, Throwable t) {

                 otpView.showErrorMeassage();

            }
        });


    }


}
