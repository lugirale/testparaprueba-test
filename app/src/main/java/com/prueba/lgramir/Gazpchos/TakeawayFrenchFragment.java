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
import android.widget.Toast;

public class TakeawayFrenchFragment extends Fragment {

    private Button mHereButton;
    private Button mTakeawayButton;
    private TextView mQuestionTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_takeaway_french, parent, false);

        mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);

        mHereButton = (Button) v.findViewById(R.id.here_button);
        mHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setAnswerTakaway("manger ici");
                Intent intent = new Intent(getActivity(), OrderFrenchActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity() , R.string.english_here_toast, Toast.LENGTH_SHORT).show();

            }
        });

        mTakeawayButton = (Button) v.findViewById(R.id.takeaway_button);
        mTakeawayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setAnswerTakaway("A emporter");
                Intent intent = new Intent(getActivity(), OrderFrenchActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity() , R.string.english_takeaway_toast, Toast.LENGTH_SHORT).show();
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

