package com.consulting.doctor.consulting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.consulting.doctor.consulting.Interface.PatientView;
import com.consulting.doctor.consulting.Presenter.PatientPresenter;

/**
 * Created by pritesh on 11/9/2017.
 */

public class PlaceOrder extends AppCompatActivity implements PatientView {

    Button button;
    private ImageView imageViewcod,imageViewpayu;
    LinearLayout linearLayoutcod,linearLayoutpayu;


    private PatientPresenter patientPresenter;

    private ProgressDialog dialog;

    private SharedPreferences patientPreferences;
    private SharedPreferences shareddata;

    private String name,addres,mobile,email,mobileotp,otp,time;
    private SharedPreferences timePreferences;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_place_order);

        button = (Button) findViewById(R.id.process);

        patientPreferences = this.getSharedPreferences("PAT",0);

        timePreferences = this.getSharedPreferences("Tim",0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });



        shareddata = this.getSharedPreferences("DATA", 0);

        dialog = new ProgressDialog(this);
        dialog.setMessage("plz wait");



                name=  patientPreferences.getString("Name","");
                addres= patientPreferences.getString("Addr","");
                mobile= patientPreferences.getString("Mob","");
                email= patientPreferences.getString("Email","");
                mobileotp = shareddata.getString("mob","");
                otp= shareddata.getString("otp","");
                time = timePreferences.getString("time","");


        patientPresenter = new PatientPresenter(this);

        imageViewcod = (ImageView) findViewById(R.id.cod);

        imageViewpayu = (ImageView) findViewById(R.id.payu);

        linearLayoutcod = (LinearLayout) findViewById(R.id.linercod);

        linearLayoutpayu = (LinearLayout) findViewById(R.id.linearpayu);



        this.linearLayoutcod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                imageViewcod.setVisibility(View.VISIBLE);
                imageViewpayu.setVisibility(View.GONE);

            }
        });


        this.linearLayoutpayu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                imageViewcod.setVisibility(View.INVISIBLE);
                imageViewpayu.setVisibility(View.INVISIBLE);


                Toast.makeText(PlaceOrder.this,"Sorry!..Currently unavaiiable",Toast.LENGTH_SHORT).show();


            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(imageViewcod.getVisibility() == View.VISIBLE) {




                    patientPresenter.sendData("",name,"",name,time,"",mobile,addres,email,"",mobile,otp,"Cod","100","");

                    Intent intent = new Intent(PlaceOrder.this,Thankyou.class);
                    startActivity(intent);



                }

                else {

                    Toast.makeText(PlaceOrder.this, "plz select payment option", Toast.LENGTH_SHORT).show();


                }

          /*          Intent intent = new Intent(PlaceOrder.this,Thankyou.class);
                startActivity(intent);
*/
            }
        });

    }

    @Override
    public void showErrorMeassage() {

        Toast.makeText(PlaceOrder.this, "Error", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showLoginSuccessMsg(int success) {

        if(success == 1) {


            Intent intent = new Intent(PlaceOrder.this,Thankyou.class);
            startActivity(intent);


        }
        else {


            Toast.makeText(PlaceOrder.this, "plz try again", Toast.LENGTH_SHORT).show();

        }

        }

    @Override
    public void showprogress() {

        dialog.show();
    }

    @Override
    public void hideprogress() {

        dialog.dismiss();

    }
}
