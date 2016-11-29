package com.prueba.lgramir.Gazpchos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SizeGazpachoFrenchFragment extends Fragment {

    private String mSizeB;
    private String mSizeS;
    private String mSizeM;

    private Button mBigButton;
    private Button mSmallButton;
    private Button mMediumButton;

    private TextView mQuestionTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_size_french_gazpacho, parent, false);
        mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);

        mSizeB= Singleton.getInstance().getBigGazpacho();

        mBigButton = (Button) v.findViewById(R.id.big_button);
        mBigButton.setText("Grande $ "+ mSizeB.toString() +" pesos mexicains");

        mBigButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("grande");
                Singleton.getInstance().setPrice(mSizeB);
                Intent intent = new Intent(getActivity(), TakeawayFrenchActivity.class);
                startActivity(intent);
            }
        });

        mSizeM= Singleton.getInstance().getMediumGazpacho();

        mMediumButton = (Button) v.findViewById(R.id.medium_button);
        mMediumButton.setText("Moyenne $ "+ mSizeM.toString()+" pesos mexicains");
        mMediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("moyenne");
                Singleton.getInstance().setPrice(mSizeM);
                Intent intent = new Intent(getActivity(), TakeawayFrenchActivity.class);
                startActivity(intent);
            }
        });

        mSizeS= Singleton.getInstance().getSmallGazpacho();

        mSmallButton = (Button) v.findViewById(R.id.small_button);
        mSmallButton.setText("Petite $ "+ mSizeS.toString()+" pesos mexicains");
        mSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("Petite");
                Singleton.getInstance().setPrice(mSizeS);
                Intent intent = new Intent(getActivity(), TakeawayFrenchActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}


