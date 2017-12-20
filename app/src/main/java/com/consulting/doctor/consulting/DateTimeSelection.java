package com.consulting.doctor.consulting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.consulting.doctor.consulting.Interface.DateView;
import com.consulting.doctor.consulting.Model.Datee;
import com.consulting.doctor.consulting.Presenter.DatePresenter;
import com.consulting.doctor.consulting.Presenter.DoctorPresenter;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pritesh on 10/3/2017.
 */

public class DateTimeSelection extends AppCompatActivity implements DateView{


    private Button button,check;

    ArrayList<String> status = new ArrayList<>();
    private MaterialSpinner spinner1;

   private ArrayList<String> timestStrings = new ArrayList<>();

    private  RadioButton radio8, radio9, radio11, radio12, radio2, radio3, radio5, radio6, radio80, radio7, radio13, radio14;

    private RadioGroupTableLayout radioGroup;
    private String location,name;

    private Context context = DateTimeSelection.this;

    private DatePresenter datePresenter;
    private ProgressDialog dialog;
    private RadioButton rb1;
    private SharedPreferences timePreferences;
    private Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.datetime);


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


        dialog = new ProgressDialog(context);


         timePreferences = this.getSharedPreferences("Tim",0);

        datePresenter = new DatePresenter(this);

        spinner1 = (MaterialSpinner) findViewById(R.id.spinner2);

        radioGroup = (RadioGroupTableLayout) findViewById(R.id.radioGroupx);

        radio8 = (RadioButton) findViewById(R.id.radio9);
        radio9 = (RadioButton) findViewById(R.id.radio10);
        radio11 = (RadioButton) findViewById(R.id.radio11);
        radio12 = (RadioButton) findViewById(R.id.radio12);
        radio2 = (RadioButton) findViewById(R.id.radio1);
        radio3 = (RadioButton) findViewById(R.id.radio2);
        radio5 = (RadioButton) findViewById(R.id.radio3);
        radio6 = (RadioButton) findViewById(R.id.radio4);
        radio80 = (RadioButton) findViewById(R.id.radio5);
        radio7 = (RadioButton) findViewById(R.id.radio6);
        radio13 = (RadioButton) findViewById(R.id.radio7);
        radio14 = (RadioButton) findViewById(R.id.radio8);

        radioGroup.setVisibility(View.GONE);


        status.add(0,"Select Location");

        status.add("Mumbai Central");
        status.add("Dadar");



        spinner1.setItems(status);
        check = (Button) findViewById(R.id.check);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final  int i1 = spinner1.getSelectedIndex();

                location = status.get(i1).toString();

                name = "Dr Rahul Ghule";


                if(location.equals("Select Location")){


                    Toast.makeText(context,"Plz select location",Toast.LENGTH_SHORT).show();

                }
                else {


                    showprogress();

                    datePresenter.getList(name,location);


                }

            }
        });





        button = (Button) findViewById(R.id.book);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectedId = radioGroup.getCheckedRadioButtonId();


                if (selectedId < 0 ) {


                    Toast.makeText(DateTimeSelection.this, "plz select appointment time", Toast.LENGTH_SHORT).show();

                }
                else {


                    if( selectedId >=0) {

                        rb1 = (RadioButton) findViewById(selectedId);

                        String tt = rb1.getText().toString();

                        timePreferences.edit().putString("time",tt).apply();

                        Intent intent = new Intent(DateTimeSelection.this,PatientDetail.class);

                           intent.putExtra("Time", tt);

                              startActivity(intent);

                   //     System.out.println("TE :" + tt);

                    }


                    }

            }
        });


    }


    public  void interval2(int begin, int end, int interval) {

        timestStrings.clear();


        radioGroup.setVisibility(View.VISIBLE);


        for (int time = begin; time <= end; time += interval) {

             System.out.println("pp:" + String.format("%02d:%02d", time / 60, time % 60));

            timestStrings.add(String.format("%02d:%02d", time / 60, time % 60));

        }


        if(timestStrings.size() >= 1) {

            if (!timestStrings.get(0).equals("")) {


                radio8.setText(timestStrings.get(0));
                radio8.setEnabled(true);
                radio8.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio8.setTextColor(getResources().getColor(R.color.carbon_black));
            }

        }
        else {

            radio8.setEnabled(false);
            radio8.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio8.setTextColor(getResources().getColor(R.color.gray_ddark));

        }


        if(timestStrings.size() >= 2) {

            if (!timestStrings.get(1).equals("")) {


                radio9.setText(timestStrings.get(1));
                radio9.setEnabled(true);
                radio9.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio9.setTextColor(getResources().getColor(R.color.carbon_black));
            }

        }
        else {

            radio9.setEnabled(false);
            radio9.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio9.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 3) {

            if (!timestStrings.get(2).equals("")) {


                radio11.setText(timestStrings.get(2));
                radio11.setEnabled(true);
                radio11.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio11.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio11.setEnabled(false);
            radio11.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio11.setTextColor(getResources().getColor(R.color.gray_ddark));

        }


        if(timestStrings.size() >= 4) {

            if (!timestStrings.get(3).equals("")) {


                radio12.setText(timestStrings.get(3));
                radio12.setEnabled(true);
                radio12.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio12.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio12.setEnabled(false);
            radio12.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio12.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 5) {


            if (!timestStrings.get(4).equals("")) {


                radio2.setText(timestStrings.get(4));
                radio2.setEnabled(true);
                radio2.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio2.setTextColor(getResources().getColor(R.color.carbon_black));
            }

        }
        else {

            radio2.setEnabled(false);
            radio2.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio2.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 6) {

            if (!timestStrings.get(5).equals("")) {


                radio3.setText(timestStrings.get(5));
                radio3.setEnabled(true);
                radio3.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio3.setTextColor(getResources().getColor(R.color.carbon_black));
            }

        }
        else {

            radio3.setEnabled(false);
            radio3.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio3.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 7) {

            if (!timestStrings.get(6).equals("")) {


                radio5.setText(timestStrings.get(6));
                radio5.setEnabled(true);
                radio5.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio5.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio5.setEnabled(false);
            radio5.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio5.setTextColor(getResources().getColor(R.color.gray_ddark));

        }


        if(timestStrings.size() >= 8) {

            if (!timestStrings.get(7).equals("")) {


                radio6.setText(timestStrings.get(7));
                radio6.setEnabled(true);
                radio6.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio6.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio6.setEnabled(false);
            radio6.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio6.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 9) {


            if (!timestStrings.get(8).equals("")) {


                radio80.setText(timestStrings.get(8));
                radio80.setEnabled(true);
                radio80.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio80.setTextColor(getResources().getColor(R.color.carbon_black));
            }

        }
        else {

            radio80.setEnabled(false);
            radio80.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio80.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 10) {


            if (!timestStrings.get(9).equals("")) {


                radio7.setText(timestStrings.get(9));
                radio7.setEnabled(true);
                radio7.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio7.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio7.setEnabled(false);
            radio7.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio7.setTextColor(getResources().getColor(R.color.gray_ddark));

        }


        if(timestStrings.size() >= 11) {

            if (!timestStrings.get(10).equals("")) {


                radio13.setText(timestStrings.get(10));
                radio13.setEnabled(true);
                radio13.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio13.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio13.setEnabled(false);
            radio13.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio13.setTextColor(getResources().getColor(R.color.gray_ddark));

        }

        if(timestStrings.size() >= 12) {

            if (!timestStrings.get(11).equals("")) {


                radio14.setText(timestStrings.get(11));
                radio14.setEnabled(true);
                radio14.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                radio14.setTextColor(getResources().getColor(R.color.carbon_black));
            }
        }
        else {

            radio14.setEnabled(false);
            radio14.setBackground(getResources().getDrawable(R.drawable.disableselector));
            radio14.setTextColor(getResources().getColor(R.color.gray_ddark));
        }

    }


    @Override
    public void showErrorMeassage() {

        Toast.makeText(context,"error",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showLoginSuccessMsg(List<Datee> dateeList) {


        System.out.println("Msg " + String.valueOf(dateeList.size()));

        int from = Integer.parseInt(dateeList.get(0).getFromTime());

        int to = Integer.parseInt(dateeList.get(0).getToTime());


        interval2(from * 60, to * 60, 30);



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
