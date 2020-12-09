package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SignInDialog.SignInDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alert = findViewById(R.id.button);
        Button custom = findViewById(R.id.button2);
        Button signin = findViewById(R.id.button3);

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("dialog_message")
                .setTitle("dialog_title");

        // Add the buttons
        builder.setPositiveButton("ok", (DialogInterface.OnClickListener) (dialog, id) -> {
            // User clicked OK button
            Toast.makeText(this, "I am ok！", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) (dialog, id) -> {
            // User cancelled the dialog
            Toast.makeText(this, "I am cancel", Toast.LENGTH_SHORT).show();
        });

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();

        FireMissilesDialogFragment fireMissilesDialog = new FireMissilesDialogFragment(this);
        PickDialog pickDialog = new PickDialog(this);
        DialogFragment multiDialog = new MultiDialog();

        DialogFragment signinDialog = new SignInDialog();



        alert.setOnClickListener(v -> {
            dialog.show();
        });

        custom.setOnClickListener(v -> {
//          fireMissilesDialog.onCreateDialog(savedInstanceState).show();
//            pickDialog.show(savedInstanceState);
            multiDialog.show(getSupportFragmentManager(), "Multi");
        });

        signin.setOnClickListener(v -> {
            signinDialog.show(getSupportFragmentManager(),"Signin");
        });




    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}