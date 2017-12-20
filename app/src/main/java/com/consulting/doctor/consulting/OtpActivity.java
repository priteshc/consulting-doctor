package com.consulting.doctor.consulting;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.brouding.blockbutton.BlockButton;
import com.consulting.doctor.consulting.Interface.OtpView;
import com.consulting.doctor.consulting.Interface.VerifyView;
import com.consulting.doctor.consulting.Model.Request;
import com.consulting.doctor.consulting.Presenter.OtpPresenter;
import com.consulting.doctor.consulting.Presenter.OtpVerifyPresenter;
import com.consulting.doctor.consulting.utils.ValidationUtils;
import com.github.kayvannj.permission_utils.Func;
import com.github.kayvannj.permission_utils.PermissionUtil;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by pritesh on 11/9/2017.
 */

public class OtpActivity extends AppCompatActivity implements OtpView,VerifyView{

    BlockButton button;
    private Toolbar toolbar;

    EditText otp1,mobileno;

    CountdownView mCvCountdownView;

    Request request;

    private ValidationUtils validationUtils;

    String  resend = "0";

    private Context context = OtpActivity.this;

    private OtpPresenter otpPresenter;

    private OtpVerifyPresenter otpVerifyPresenter;
    private ProgressDialog dialog;

    private SharedPreferences shareddata;

    private PermissionUtil.PermissionRequestObject mStoragePermissionRequest;

    private static final int REQUEST_CODE_STORAGE = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.otp);

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


        button = (BlockButton) findViewById(R.id.btn_reset_guide);

        shareddata = this.getSharedPreferences("DATA", 0);

        dialog = new ProgressDialog(this);
        dialog.setMessage("plz wait");

        otpPresenter = new OtpPresenter(this);

        otpVerifyPresenter = new OtpVerifyPresenter(this);

        validationUtils = new ValidationUtils(this);

        request = new Request();

        mCvCountdownView = (CountdownView) findViewById(R.id.tim);

        otp1 = (EditText) findViewById(R.id.otp);

        mobileno = (EditText) findViewById(R.id.phn);

        if (Build.VERSION.SDK_INT > 22) {


            onAskForStoragePermissionClick();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String mobile = mobileno.getText().toString();

                if (!validationUtils.isValidMobile(mobile)) {

                    Toast.makeText(OtpActivity.this,"Please enter your mobile no",Toast.LENGTH_SHORT).show();

                }
                else {



                    shareddata.edit().putString("mob",mobile).apply();

                    request.setMobileNo(mobile);
                    request.setResend(resend);


                    otpPresenter.getSms(request);

                 //   Intent intent = new Intent(OtpActivity.this, PlaceOrder.class);
                 //   startActivity(intent);
                }

            }
        });


        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() == 6){


                    otpVerifyPresenter.getVerify(mobileno.getText().toString(),otp1.getText().toString());


                    mCvCountdownView.stop();


                    /*verifysms(mobileno.getText().toString(),otp1.getText().toString());


                    mCvCountdownView.stop();

                    progressDialog.show();
*/
                }


            }
        });



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            String message = extras.getString("message");

            String [] spi = message.split(":");

            String msg = spi[1].trim();

            otp1.setText(msg);

            String mob = shareddata.getString("mob","");

            mobileno.setText(mob);


         //     Toast.makeText(OtpActivity.this, "messageReceived", Toast.LENGTH_SHORT).show();


        }





    }

    @Override
    public void showErrorMeassage() {

    }

    @Override
    public void showLoginSuccessMsg(String msg) {



        if(msg.equals("Success")){

            mCvCountdownView.start(60000);

        }

        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showprogress() {

        dialog.show();

    }

    @Override
    public void hideprogress() {

        dialog.dismiss();
    }

    @Override
    public void showVErrorMeassage() {

    }

    @Override
    public void showVLoginSuccessMsg(int success) {

        if(success == 1){

            shareddata.edit().putString("otp",otp1.getText().toString()).apply();

            Intent intent = new Intent(OtpActivity.this, PlaceOrder.class);
            startActivity(intent);

        }

        else {

            Toast.makeText(OtpActivity.this,"Otp is invalid",Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void showVprogress() {

        dialog.show();

    }

    @Override
    public void hideVprogress() {

        dialog.dismiss();
    }


    public void onAskForStoragePermissionClick() {
        mStoragePermissionRequest = PermissionUtil.with(this).request(Manifest.permission.READ_SMS).onAllGranted(
                new Func() {
                    @Override
                    protected void call() {
                        doOnPermissionGranted("Storage");
                    }
                }).onAnyDenied(
                new Func() {
                    @Override
                    protected void call() {
                        doOnPermissionDenied("Storage");
                    }
                }).ask(REQUEST_CODE_STORAGE);

    }


    private void doOnPermissionDenied(String permission) {
//		updateStatus(permission + " Permission Denied or is on \"Do Not SHow Again\"");
    }

    private void doOnPermissionGranted(String permission) {
//		updateStatus(permission + " Permission Granted");

        /*Intent mediaIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mediaIntent.setType("application*//*"); //set mime type as per requirement
        startActivityForResult(mediaIntent,REQUESTCODE_PICK_VIDEO);*/
    }

	/*private void updateStatus(String s)
    {
		mStatus.setText(String.format("> %s\n", s) + mStatus.getText().toString());
	}
*/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (mStoragePermissionRequest != null)
            mStoragePermissionRequest.onRequestPermissionsResult(requestCode, permissions, grantResults);

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
