package com.prueba.lgramir.Gazpchos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FrenchChoiceProductFragment extends Fragment {

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
        View v = inflater.inflate(R.layout.fragment_french_choice_product, parent, false);

        mQuestionTextView = (TextView) v.findViewById(R.id.Choice_text_view);

        image = (ImageView) v.findViewById(R.id.imageView1);
        image = (ImageView) v.findViewById(R.id.imageView2);

        mFruitButton = (Button) v.findViewById(R.id.fruit_button);
        mFruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setChoice("tranche de fruits");
                // Intent intent = new Intent(getActivity(), EnglishIngredientsFruitActivity.class);
                //startActivity(intent);
                Toast.makeText(getActivity(),R.string.fruit_toast, Toast.LENGTH_SHORT).show();
            }

        });


        mGazpachoButton = (Button) v.findViewById(R.id.gazpacho_button);
        mGazpachoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setChoice("Gazpcho Moreliano");
                //Intent intent = new Intent(getActivity(), EnglishIngredientsGazpachoActivity.class);
                //startActivity(intent);
                Toast.makeText(getActivity(),R.string.gazpacho_toast, Toast.LENGTH_SHORT).show();
            }

        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}

