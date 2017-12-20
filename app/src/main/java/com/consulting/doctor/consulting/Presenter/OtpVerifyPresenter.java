package com.consulting.doctor.consulting.Presenter;

import com.consulting.doctor.consulting.BackTask.RetrofitBuild;
import com.consulting.doctor.consulting.Interface.DateView;
import com.consulting.doctor.consulting.Interface.VerifyView;
import com.consulting.doctor.consulting.Model.DatePojo;
import com.consulting.doctor.consulting.Model.Verify;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class OtpVerifyPresenter {


    private VerifyView verifyView;

    private RetrofitBuild retrofitBuild;


    public OtpVerifyPresenter(VerifyView verifyView) {

        this.verifyView = verifyView;

        retrofitBuild = new RetrofitBuild();

    }



    public void getVerify(String mobile,String otp){

        verifyView.showVprogress();

        Call<Verify> pojoCall = retrofitBuild.allApi().getGetverif(mobile, otp);


        pojoCall.enqueue(new Callback<Verify>() {
            @Override
            public void onResponse(Call<Verify> call, Response<Verify> response) {

                verifyView.hideVprogress();


                   verifyView.showVLoginSuccessMsg(response.body().getSuccess());



            }

            @Override
            public void onFailure(Call<Verify> call, Throwable t) {

                verifyView.hideVprogress();

                verifyView.showVErrorMeassage();

            }
        });


    }


}
