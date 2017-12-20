package com.consulting.doctor.consulting.Presenter;

import com.consulting.doctor.consulting.BackTask.RetrofitBuild;
import com.consulting.doctor.consulting.Interface.DateView;
import com.consulting.doctor.consulting.Interface.DoctorView;
import com.consulting.doctor.consulting.Model.DatePojo;
import com.consulting.doctor.consulting.Model.DoctorPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class DatePresenter {


    private DateView dateView;

    private RetrofitBuild retrofitBuild;


    public DatePresenter(DateView dateView) {

        this.dateView = dateView;

        retrofitBuild = new RetrofitBuild();

    }



    public void getList(String name,String location){

        dateView.showprogress();

        Call<DatePojo> pojoCall = retrofitBuild.allApi().gettime(name, location);


        pojoCall.enqueue(new Callback<DatePojo>() {
            @Override
            public void onResponse(Call<DatePojo> call, Response<DatePojo> response) {

                dateView.hideprogress();


                if(response.body().getSuccess() == 1){


                    dateView.showLoginSuccessMsg(response.body().getData());

                }
                else {


                    dateView.showErrorMeassage();

                }




            }

            @Override
            public void onFailure(Call<DatePojo> call, Throwable t) {

                dateView.hideprogress();

                dateView.showErrorMeassage();

            }
        });


    }


}
