package com.rramprasad.eventbussample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        final EditText messageEditText = rootView.findViewById(R.id.message_edittext);

        Button gotoSecondFragmentButton = rootView.findViewById(R.id.go_to_second_fragment_button);
        gotoSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();

                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setMessage(message);
                EventBus.getDefault().post(messageEvent);
            }
        });
        return rootView;
    }
}
