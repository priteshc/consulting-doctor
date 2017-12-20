package com.consulting.doctor.consulting.Presenter;

import com.consulting.doctor.consulting.BackTask.RetrofitBuild;
import com.consulting.doctor.consulting.Interface.DoctorView;
import com.consulting.doctor.consulting.Model.DoctorPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class DoctorPresenter {


    private DoctorView doctorView;

    private RetrofitBuild retrofitBuild;


    public DoctorPresenter(DoctorView doctorView) {

        this.doctorView = doctorView;

        retrofitBuild = new RetrofitBuild();

    }



    public void getList(){

        doctorView.showprogress();

        Call<DoctorPojo> pojoCall = retrofitBuild.allApi().getList();

        pojoCall.enqueue(new Callback<DoctorPojo>() {
            @Override
            public void onResponse(Call<DoctorPojo> call, Response<DoctorPojo> response) {


                if(response.body().getSuccess() == 1){


                    doctorView.showLoginSuccessMsg(response.body().getData());

                    doctorView.hideprogress();


                }
                else {

                    doctorView.hideprogress();

                    doctorView.showErrorMeassage();

                }




            }

            @Override
            public void onFailure(Call<DoctorPojo> call, Throwable t) {


                doctorView.hideprogress();

                doctorView.showErrorMeassage();


            }
        });


    }


}
