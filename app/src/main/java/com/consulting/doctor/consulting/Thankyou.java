package com.consulting.doctor.consulting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pritesh on 11/9/2017.
 */

public class Thankyou extends AppCompatActivity {


    private Button button;
    private Toolbar toolbar;
    private TextView tname,taddress,tmobile,tdat,ttime,tot;
    private String name,addres,mobile,email,mobileotp,otp,time;


    private SharedPreferences patientPreferences;
    private SharedPreferences shareddata;

    private SharedPreferences timePreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thankyou);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        patientPreferences = this.getSharedPreferences("PAT",0);

        timePreferences = this.getSharedPreferences("Tim",0);


        shareddata = this.getSharedPreferences("DATA", 0);

        button = (Button) findViewById(R.id.process);

        tname = (TextView) findViewById(R.id.tvname);

        taddress = (TextView) findViewById(R.id.tvaddress);

        tmobile = (TextView) findViewById(R.id.tvmob);

        tdat = (TextView) findViewById(R.id.tvdat);

        ttime = (TextView) findViewById(R.id.tvtime);

        tot = (TextView) findViewById(R.id.totl);


        name=  patientPreferences.getString("Name","");
        addres= patientPreferences.getString("Addr","");
        mobile= patientPreferences.getString("Mob","");
        email= patientPreferences.getString("Email","");
        mobileotp = shareddata.getString("mob","");
        otp= shareddata.getString("otp","");
        time = timePreferences.getString("time","");


         tname.setText(name);
        taddress.setText(addres);
        tmobile.setText(mobile);
        ttime.setText(time);
        tot.setText("100");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Thankyou.this,MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);


                startActivity(intent);

                finish();



            }
        });

    }
}
