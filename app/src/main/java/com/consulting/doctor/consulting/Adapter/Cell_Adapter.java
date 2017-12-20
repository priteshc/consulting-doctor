package com.consulting.doctor.consulting.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.consulting.doctor.consulting.DateTimeSelection;
import com.consulting.doctor.consulting.Holder.Cell_Holder;
import com.consulting.doctor.consulting.Interface.CustomItemListner;
import com.consulting.doctor.consulting.Model.Doctor;
import com.consulting.doctor.consulting.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by pritesh on 10/2/2017.
 */

public class Cell_Adapter extends RecyclerView.Adapter<Cell_Holder> {

    Context mContext;
    List<Doctor> doctorList;
    private int pos = -1;
    private   FoldingCell cell;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();

    ArrayList<Integer>integerArrayList = new ArrayList<>();

    CustomItemListner listener;

    public Cell_Adapter(Context mContext ) {
        this.mContext = mContext;

     //   this.listener = listener;
    }

    public void setList( List<Doctor> doctorList){

        this.doctorList = doctorList;
        notifyDataSetChanged();
    }


    @Override
    public Cell_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell, parent, false);

     /*   final Cell_Holder cellHolder = new Cell_Holder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClick(view,cellHolder.getPosition());
            }
        });*/

        return new Cell_Holder(itemView);

    }

    @Override
    public void onBindViewHolder(Cell_Holder holder, final int position) {

        System.out.println("POS:" + position);


        if (unfoldedIndexes.contains(position))
        {

           holder.foldingCell.unfold(true);

          //  cell.unfold(true);

        }
        else {


            holder.foldingCell.fold(true);

        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   cell = (FoldingCell) view;

                cell.toggle(false);*/

              //  registerToggle(position);

                ((FoldingCell) view).toggle(false);


                registerToggle(position);

                notifyDataSetChanged();

            }
        });


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(mContext,String.valueOf(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext,DateTimeSelection.class);
                mContext.startActivity(intent);

            }
        });

     /*   holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              *//*   cell = (FoldingCell) view;

                ((FoldingCell) view).toggle(false);
*//*
              //  pos = position;

                registerToggle(position);

                notifyDataSetChanged();


            }
        });*/



    }



    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {

        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    @Override
    public int getItemCount() {

        return doctorList.size();
    }
}
