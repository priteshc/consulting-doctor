package com.consulting.doctor.consulting.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brouding.blockbutton.BlockButton;
import com.consulting.doctor.consulting.R;
import com.ramotion.foldingcell.FoldingCell;

/**
 * Created by pritesh on 10/2/2017.
 */

public class Cell_Holder extends RecyclerView.ViewHolder {

  public BlockButton button;

   public FoldingCell foldingCell;
    public Cell_Holder(View itemView) {

        super(itemView);


        button = (BlockButton)itemView.findViewById(R.id.btn_reset_guide);

        foldingCell = (FoldingCell) itemView.findViewById(R.id.fold);

    }
}
