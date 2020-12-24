package com.romdal.studyandroid;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LefrFragment extends Fragment implements View.OnClickListener{

    private  OnColorButtonListener onColorButtonListener;

    public LefrFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onColorButtonListener = (OnColorButtonListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lefr, container, false);
        view.findViewById(R.id.v_red).setOnClickListener(this);
        view.findViewById(R.id.v_green).setOnClickListener(this);
        view.findViewById(R.id.v_blue).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.v_red:
                onColorButtonListener.onColorClick(0);
                break;
            case R.id.v_green:
                onColorButtonListener.onColorClick(1);
                break;
            case R.id.v_blue:
                onColorButtonListener.onColorClick(2);
                break;
        }



    }
}
