package org.kasapbasi.week030012020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void myClick(View v){

        Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show();
        Intent in = new Intent(this,MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this,0,in,0);

        Notification myN= new  Notification.Builder( this)
                .setContentTitle("Dikkat Virus Bulundu")
                .setContentText("Silmek için Tıklayınız")
                .setSmallIcon(android.R.drawable.btn_star)
                .addAction(android.R.drawable.btn_minus
                        , "And more", pending)
                .addAction(android.R.drawable.btn_minus
                        , "And more", pending)
                .addAction(android.R.drawable.btn_minus
                        , "And more", pending)
                .setContentIntent(pending)
                .setAutoCancel(true)
                .build();

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0,myN);

        Toast.makeText(this,"Hello 2",Toast.LENGTH_LONG).show();

    }
}
