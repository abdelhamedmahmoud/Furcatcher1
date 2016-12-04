package com.example.dell.furcatcher1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class viewpager extends Fragment {

    TextView textView;

    public viewpager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_viewpager, container, false);
        textView=(TextView)view.findViewById(R.id.textView);
        Bundle bundle=getArguments();

        String Messege=bundle.getString("count");
        textView.setText(Messege);









        return view;
    }

}
