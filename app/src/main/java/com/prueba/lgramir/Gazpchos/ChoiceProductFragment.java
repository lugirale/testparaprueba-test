package com.prueba.lgramir.Gazpchos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChoiceProductFragment extends Fragment {

    private Button mFruitButton;
    private Button  mGazpachoButton;
    private TextView mQuestionTextView;

    private ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choice_product, parent, false);

        mQuestionTextView = (TextView) v.findViewById(R.id.Choice_text_view);

        image = (ImageView) v.findViewById(R.id.imageView1);
        image = (ImageView) v.findViewById(R.id.imageView2);

        mFruitButton = (Button) v.findViewById(R.id.fruit_button);
        mFruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setChoice("Vaso de fruta");

                Intent intent = new Intent(getActivity(), IngredientsFruitActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),R.string.fruit_toast, Toast.LENGTH_SHORT).show();
            }

        });


        mGazpachoButton = (Button) v.findViewById(R.id.gazpacho_button);
        mGazpachoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setChoice("Gazpcho");
                Intent intent = new Intent(getActivity(), IngredientsGazpachoActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),R.string.gazpacho_toast, Toast.LENGTH_SHORT).show();
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