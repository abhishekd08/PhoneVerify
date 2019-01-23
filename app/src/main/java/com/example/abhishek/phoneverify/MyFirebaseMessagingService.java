package com.example.abhishek.phoneverify;

import android.telephony.SmsManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private SmsManager smsManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String, String> data = remoteMessage.getData();

        String number = data.get("number");
        String code = data.get("code");

        Log.d("abhishek data okokok",number+" ::: "+code+" ::: data --->  "+data.get("timepass"));

        smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, "Security code is : "+code,null,null);


    }
}
