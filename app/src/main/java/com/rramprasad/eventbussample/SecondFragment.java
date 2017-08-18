package com.rramprasad.eventbussample;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    private static final String PARAM_KEY_MESSAGE = "param_key_message";
    private String mMessage;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String message) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_KEY_MESSAGE,message);
        secondFragment.setArguments(bundle);
        return secondFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mMessage = getArguments().getString(PARAM_KEY_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        TextView messageTextView = rootView.findViewById(R.id.message_textview);
        messageTextView.setText(mMessage);

        Button getDataFromServiceButton = rootView.findViewById(R.id.get_data_from_service_button);
        getDataFromServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyIntentService.class);
                getActivity().startService(intent);
            }
        });
        return rootView;
    }
}
