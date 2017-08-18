package com.rramprasad.eventbussample;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String message = "Message from Service";

            ServiceMessageEvent serviceMessageEvent = new ServiceMessageEvent();
            serviceMessageEvent.setMessage(message);
            EventBus.getDefault().post(serviceMessageEvent);
        }
    }
}
