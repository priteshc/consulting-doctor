package com.consulting.doctor.consulting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by pritesh on 10/6/2017.
 */

public class DynamicRadio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dyanmic);


        for(int row=0; row < 3; row++)
        {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            for(int i = 0; i < 2; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId((row * 2) + i);
                rdbtn.setText("test " + rdbtn.getId());
                rdbtn.setBackground(getResources().getDrawable(R.drawable.plain_rbtn_selector));
                ll.addView(rdbtn);
            }
            ((ViewGroup)findViewById(R.id.radiogroup)).addView(ll);
        }

    }

    public void addRadioButtons(int number) {

        for (int row = 0; row < 5; row++) {
            RadioGroup ll = new RadioGroup(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 1; i <= 2; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId((row * 2) + i);
                rdbtn.setText("Radio " + rdbtn.getId());
                ll.addView(rdbtn);
            }
            ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
        }

    }
}
