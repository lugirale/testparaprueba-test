package com.prueba.lgramir.Gazpchos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PriceFruitFragment extends Fragment {

    private EditText mSmallField;
    private EditText mMediumField;
    private EditText mBigField;

    private Button mNextButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_price_fruit, parent, false);

        mNextButton = (Button) v.findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                startActivity(intent);
            }
        });

        mSmallField = (EditText) v.findViewById(R.id.small);
        mSmallField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Singleton.getInstance().setSmallFruit(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mMediumField = (EditText) v.findViewById(R.id.medium);
        mMediumField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Singleton.getInstance().setMediumFruit(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        mBigField = (EditText) v.findViewById(R.id.big);
        mBigField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Singleton.getInstance().setBigFruit(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
