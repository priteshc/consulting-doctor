package com.consulting.doctor.consulting.Presenter;

import com.consulting.doctor.consulting.BackTask.RetrofitBuild;
import com.consulting.doctor.consulting.Interface.DateView;
import com.consulting.doctor.consulting.Interface.PatientView;
import com.consulting.doctor.consulting.Model.DatePojo;
import com.consulting.doctor.consulting.Model.Sendpdata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class PatientPresenter {


    private PatientView patientView;

    private RetrofitBuild retrofitBuild;


    public PatientPresenter(PatientView patientView) {

        this.patientView = patientView;

        retrofitBuild = new RetrofitBuild();

    }



    public void sendData(String id,String name,String apdat,String pnam,String schid,String schnam,String mobno,String addr,String email,String ptyp,String otpmob,String otpcod,String paymod,String amt,String code){

        patientView.showprogress();

        Call<Sendpdata> pojoCall = retrofitBuild.allApi().getPdata(id, name, apdat, pnam, schid, schnam, mobno, addr, email, ptyp, otpmob, otpcod, paymod, amt, code);


        pojoCall.enqueue(new Callback<Sendpdata>() {
            @Override
            public void onResponse(Call<Sendpdata> call, Response<Sendpdata> response) {

                patientView.hideprogress();



                    patientView.showLoginSuccessMsg(response.body().getSuccess());




            }

            @Override
            public void onFailure(Call<Sendpdata> call, Throwable t) {

                patientView.hideprogress();

                patientView.showErrorMeassage();

            }
        });


    }


}
