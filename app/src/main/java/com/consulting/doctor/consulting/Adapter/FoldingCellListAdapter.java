package com.consulting.doctor.consulting.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.brouding.blockbutton.BlockButton;
import com.consulting.doctor.consulting.DateTimeSelection;
import com.consulting.doctor.consulting.Model.Doctor;
import com.consulting.doctor.consulting.Profile;
import com.consulting.doctor.consulting.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Doctor> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    private int pos;

    private  Context context;

    public FoldingCellListAdapter(Context context, List<Doctor> objects) {

        super(context, 0, objects);
        this.context = context;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        Doctor item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.fromAddress = (TextView) cell.findViewById(R.id.title_from_address);
            viewHolder.toAddress = (TextView) cell.findViewById(R.id.title_to_address);
            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            viewHolder.button = (BlockButton)cell.findViewById(R.id.btn_reset_guide);
            viewHolder.view = (Button)cell.findViewById(R.id.view);
            viewHolder.price = (TextView) cell.findViewById(R.id.price);
            viewHolder.experience = (TextView) cell.findViewById(R.id.expr);
            viewHolder.clinic = (TextView) cell.findViewById(R.id.clinic);
            viewHolder.location = (TextView) cell.findViewById(R.id.location);
            viewHolder.call = (ImageView) cell.findViewById(R.id.call);


            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }


        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Profile.class);
                context.startActivity(intent);

            }
        });


        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,DateTimeSelection.class);
                context.startActivity(intent);

            }
        });

        viewHolder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showCallLog = new Intent();
                showCallLog.setAction(Intent.ACTION_DIAL);
                showCallLog.setData(Uri.parse("tel:022-1234568"));
                context.startActivity(showCallLog);

            }
        });


        // bind data from selected element to view through view holder

        viewHolder.price.setText(item.getFees());

        viewHolder.experience.setText(item.getExperience());

        viewHolder.fromAddress.setText(item.getDocName());

        viewHolder.toAddress.setText(item.getSpecialization());

        viewHolder.clinic.setText(item.getClinicName());

      //  viewHolder.location.setText(item.getLocation());


        // set custom btn handler for list item from that item
      /*  if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }
*/
        return cell;


    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {

            unfoldedIndexes.clear();

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


    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView price;
        TextView contentRequestBtn;
        TextView pledgePrice;
        TextView fromAddress;
        TextView toAddress;
        TextView requestsCount;
        TextView date;
        TextView time;
        TextView experience;
        BlockButton button;
        Button view;
        TextView clinic;
        TextView location;
        ImageView call;

    }
}
