package com.examples.firstapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends Activity {

    private static final int DIALOG_ALERT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        Button b = (Button) findViewById(R.id.valider);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ALERT);

            }
        });
    }
        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DIALOG_ALERT:
                    // Create out AlterDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Êtes vous sûr de vouloir confirmer ?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Confirmer",new OkOnClickListener());
                    builder.setNegativeButton("Annuler",new CancelOnClickListener());
                    AlertDialog dialog = builder.create();
                    dialog.show();
            }
            return super.onCreateDialog(id);
        }

        private final class CancelOnClickListener implements
                DialogInterface.OnClickListener {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Annuler",
                        Toast.LENGTH_LONG).show();
            }
        }

        private final class OkOnClickListener implements
                DialogInterface.OnClickListener {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Confirmer", Toast.LENGTH_LONG).show();
                MainActivity.this.finish();


            }
        }}