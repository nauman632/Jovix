package com.example.madprojectassign3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        // Existing TextViews and Buttons
        TextView haveAccount = view.findViewById(R.id.haveaccout);
        TextView textView1 = view.findViewById(R.id.haveaccout1311);
        TextView textView2 = view.findViewById(R.id.haveaccout311111);
        Button button1 = view.findViewById(R.id.continue2f11q);
        Button button2 = view.findViewById(R.id.continue211);
        Button button3 = view.findViewById(R.id.continue2f11);

        // New TextViews
        TextView textView3 = view.findViewById(R.id.dev_about1);
        TextView textView4 = view.findViewById(R.id.dev_about2);
        TextView textView5 = view.findViewById(R.id.dev_about3);

        // Existing OnClickListeners
        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_login.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_login.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_login.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_sign_up.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_sign_up.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), firebase_sign_up.class);
                startActivity(intent);
            }
        });

        // New OnClickListeners for TextViews
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dev_about.class);
                startActivity(intent);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dev_about.class);
                startActivity(intent);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dev_about.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
