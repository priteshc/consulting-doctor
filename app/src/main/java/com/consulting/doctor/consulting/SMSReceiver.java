package com.consulting.doctor.consulting;

/**
 * Created by pritesh on 10/20/2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();


    MSGListner msgListner;


    String otpmobile;

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        SharedPreferences shareddata = context.getSharedPreferences("DATA", 0);

        otpmobile = shareddata.getString("otp","");


        System.out.println("OTT:" + otpmobile);

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    if(senderNum.contains("MGCDIL")) {
                        if(otpmobile.equals("")|| otpmobile == null) {

                            Intent newintent = new Intent(context, OtpActivity.class);
                            newintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            newintent.putExtra("address", senderNum);
                            newintent.putExtra("message", message);
                            context.startActivity(newintent);
                        }
                    }
                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);


                    // Show Alert


                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }

    public void registermsglistner( MSGListner msgListner) {

        this.msgListner = msgListner;
    }


    public interface MSGListner {
        void onMsg(String msg);
    }




}