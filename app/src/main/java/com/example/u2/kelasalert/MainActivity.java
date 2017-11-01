package com.example.u2.kelasalert;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tampilDialog(View view){
        //        langkah 1 :bentuk dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //        langkah 2: tambah karakteristik dari dialog box
        builder.setMessage("Dialog message: hello dialog!")
                .setTitle("Dialog Tittle");


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            //          user click OK button
                Toast.makeText(getApplicationContext(),"Positive button",Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//          user click Cancel button
                dialog.cancel();
            }
        });

        AlertDialog alertdialog = builder.create();
        alertdialog.show();

        final Intent emptyIntent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Notifikasi pertama")
                        .setContentText("Hello World!")
                        .setContentIntent(pendingIntent);

        int mId = 001;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(mId, mBuilder.build());
    }

    public void tampilCustomDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        builder.setMessage("silahkan isi form")
                .setTitle("Hello!");

        final View dialogLogin = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(dialogLogin)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etUsername = (EditText) dialogLogin.findViewById(R.id.username);
                        EditText etPassword = (EditText) dialogLogin.findViewById(R.id.password);

                        String username = etUsername.getText().toString();
                        String password = etPassword.getText().toString();

                        String hasil = username+" "+password;

                        Toast.makeText(getApplicationContext(), hasil, Toast.LENGTH_LONG).show();
                    }
                })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                   }
               });
        AlertDialog alertdialog = builder.create();
        alertdialog.show();
    }

    public void tampilNotification(View view){
        final Intent emptyIntent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Notifikasi kedua")
                        .setContentText("Hello i just send you a notification")
                        .setContentIntent(pendingIntent);

        int mId = 002;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(mId, mBuilder.build());
    }
}
