package com.rramprasad.eventbussample;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FirstFragment firstFragment = FirstFragment.newInstance();
            replaceFragmentInActivity(firstFragment);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void replaceFragmentInActivity(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        String message = messageEvent.getMessage();
        SecondFragment secondFragment = SecondFragment.newInstance(message);
        replaceFragmentInActivity(secondFragment);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onDataReceivedFromService(ServiceMessageEvent serviceMessageEvent){
        //Running in separate thread(Not Posting or Main thread)
        String message = serviceMessageEvent.getMessage();
        Log.d("EventBus", "onDataReceivedFromService: "+message);
    }
}



