package com.consulting.doctor.consulting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.consulting.doctor.consulting.utils.ValidationUtils;

/**
 * Created by pritesh on 10/4/2017.
 */

public class PatientDetail extends AppCompatActivity {

 Button process;

    TextInputLayout inputLayoutName, inputLayoutAddress, inputLayoutMobile,inputLayoutEmail;

    EditText inputName, inputAddress, inputMobile,inputEmail;
    private Toolbar toolbar;
    String name,addres,mobile,email;

    ValidationUtils validationUtils;

    private SharedPreferences patientPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.book);

        process = (Button) findViewById(R.id.process);

        patientPreferences = this.getSharedPreferences("PAT",0);


        inputLayoutName = (TextInputLayout) findViewById(R.id.name);
        inputLayoutAddress = (TextInputLayout) findViewById(R.id.address);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.mobile);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.email);


        inputName = (EditText)findViewById(R.id.input_name);
        inputAddress = (EditText)findViewById(R.id.input_address);
        inputMobile = (EditText)findViewById(R.id.input_mobile);
        inputEmail = (EditText)findViewById(R.id.input_email);


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



        validationUtils = new ValidationUtils(this);


        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name = inputName.getText().toString();
                addres = inputAddress.getText().toString();
                mobile = inputMobile.getText().toString();
                email = inputEmail.getText().toString();


                if (name.equals("")) {

                    inputLayoutName.setError("Please enter name");
                    inputName.requestFocus();

                } else {

                    inputLayoutName.setErrorEnabled(false);


                    if (addres.equals("")) {


                        inputLayoutAddress.setError("Please enter address");
                        inputAddress.requestFocus();


                    } else {

                        inputLayoutAddress.setErrorEnabled(false);


                        if (!validationUtils.isValidMobile(mobile)) {


                            inputLayoutMobile.setError("Please enter valid mobile number");

                            inputMobile.requestFocus();

                        } else {


                            inputLayoutMobile.setErrorEnabled(false);

                            if (!validationUtils.isValidEmail(email)) {


                                inputLayoutEmail.setError("Please enter valid email id");

                                inputEmail.requestFocus();

                            } else {


                                inputLayoutEmail.setErrorEnabled(false);


                                patientPreferences.edit().putString("Name",name).putString("Addr",addres).putString("Mob",mobile).putString("Email",email).apply();

                                Intent intent = new Intent(PatientDetail.this,OtpActivity.class);
                                startActivity(intent);


                            }
                        }
                    }
                }



               /* Intent intent = new Intent(PatientDetail.this,OtpActivity.class);
                startActivity(intent);*/


            }
        });


    }
}
