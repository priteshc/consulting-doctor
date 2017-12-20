package com.consulting.doctor.consulting;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.consulting.doctor.consulting.Adapter.Cell_Adapter;
import com.consulting.doctor.consulting.Adapter.FoldingCellListAdapter;
import com.consulting.doctor.consulting.Interface.CustomItemListner;
import com.consulting.doctor.consulting.Interface.DoctorView;
import com.consulting.doctor.consulting.Model.Doctor;
import com.consulting.doctor.consulting.Presenter.DoctorPresenter;
import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DoctorView {


    private DoctorPresenter doctorPresenter;
    private Context context = MainActivity.this;

    private RecyclerView recyclerView;

    private Cell_Adapter cell_adapter;

    private FoldingCellListAdapter foldingCellListAdapter;

    private ProgressDialog dialog;
    private Toolbar toolbar;

    private FoldingCell cell;

    ListView theListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){

            System.out.println("Yo:"+ savedInstanceState.getString("Yes"));

        }

        theListView = (ListView) findViewById(R.id.mainListView);

        dialog = new ProgressDialog(context);


          doctorPresenter = new DoctorPresenter(this);

        /*recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
*/



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);




       // cell_adapter = new Cell_Adapter(context);




/*

        cell_adapter = new Cell_Adapter(context, new CustomItemListner() {
            @Override
            public void onItemClick(View v, int position) {


                cell = (FoldingCell) v;

                cell.toggle(false);

                cell_adapter.registerToggle(position);




              Toast.makeText(context,String.valueOf(position),Toast.LENGTH_SHORT).show();




            }
        });
*/

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                foldingCellListAdapter.registerToggle(pos);

                foldingCellListAdapter.notifyDataSetChanged();

            }
        });



        doctorPresenter.getList();


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("Yes","Welcome");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
/*
        String y = savedInstanceState.getString("Yes");

        System.out.println("Yo:"+ y);*/
    }

    @Override
    public void showErrorMeassage() {

        Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showLoginSuccessMsg(List<Doctor> doctorList) {

/*
        cell_adapter.setList(doctorList);

        recyclerView.setAdapter(cell_adapter);*/

    foldingCellListAdapter = new FoldingCellListAdapter(context,doctorList);

        theListView.setAdapter(foldingCellListAdapter);

    }


    @Override
    public void showprogress() {

        dialog.show();

    }

    @Override
    public void hideprogress() {

        dialog.hide();
    }
}
