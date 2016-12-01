package com.prueba.lgramir.Gazpchos;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SizeGazpachoFragment extends Fragment {

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
        View v = inflater.inflate(R.layout.fragment_size_gazpacho, parent, false);
        mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);

        mSizeB= Singleton.getInstance().getBigGazpacho();

        mBigButton = (Button) v.findViewById(R.id.big_button);
        mBigButton.setText("Grande $ "+ mSizeB.toString() +" pesos");

        mBigButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("grande");
                Singleton.getInstance().setPrice("Total a pagar: $ "+mSizeB +" pesos 00/100 M.N)");
                Intent intent = new Intent(getActivity(), TakeawayActivity.class);
                startActivity(intent);
            }
        });

        mSizeM= Singleton.getInstance().getMediumGazpacho();

        mMediumButton = (Button) v.findViewById(R.id.medium_button);
        mMediumButton.setText("Mediano $ "+ mSizeM.toString()+" pesos");
        mMediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("mediano");
                Singleton.getInstance().setPrice(mSizeM );
                Intent intent = new Intent(getActivity(), TakeawayActivity.class);
                startActivity(intent);
            }
        });

        mSizeS= Singleton.getInstance().getSmallGazpacho();

        mSmallButton = (Button) v.findViewById(R.id.small_button);
        mSmallButton.setText("Chico $ "+ mSizeS.toString()+" pesos");
        mSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setSize("chico");
                Singleton.getInstance().setPrice("Total a pagar: $ "+mSizeS  +" pesos 00/100 M.N)");
                Intent intent = new Intent(getActivity(), TakeawayActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                // finish(); // to simulate "restart" of the activity.
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

