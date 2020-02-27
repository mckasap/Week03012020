package org.kasapbasi.week030012020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String CHANNEL_ID = "mobilprog";
    String CHANNEL_NAME = "Mobil Programlama Notification";

    public void createChannel (View v){
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.enableLights(true);
        NotificationManager manager = (NotificationManager) getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
        Toast.makeText(this,"Notification Channel Created", Toast.LENGTH_SHORT).show();
    }

    public void myClick(View v){
        int NOTIFICATION_ID = 52; //Id for notification
        Intent yesReceive = new Intent();
        yesReceive.setAction("YES_ACTION");
        PendingIntent pendingIntentYes = PendingIntent.getBroadcast(this,0,yesReceive,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent noReceive = new Intent();
        noReceive.setAction("NO_ACTION");
        PendingIntent pendingIntentNo = PendingIntent.getBroadcast(this,0,noReceive,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification myN= new  Notification.Builder( this,CHANNEL_ID)
                .setContentTitle("Dikkat Virus Bulundu")
                .setContentText("Silmek için Tıklayınız")
                .setSmallIcon(android.R.drawable.btn_star)
                .addAction(android.R.drawable.btn_plus,"YES",pendingIntentYes)
                .addAction(android.R.drawable.btn_minus,"NO",pendingIntentNo)
                .setAutoCancel(true)
                .build();

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID,myN);

        Toast.makeText(this,"Notification Sent",Toast.LENGTH_LONG).show();

    }
}
