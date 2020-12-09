package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PickDialog extends DialogFragment {
    private Context context;
    private int lastWhich=0;

    public PickDialog(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pick a color")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Toast.makeText(context, which+" ", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setSingleChoiceItems(R.array.colors_array, lastWhich, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            lastWhich=which;
            }
        });

        return builder.create();
    }


     void show(@Nullable Bundle savedInstanceState){
        onCreateDialog(savedInstanceState).show();

    }



}
