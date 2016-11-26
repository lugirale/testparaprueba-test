package com.prueba.lgramir.Gazpchos;


import android.support.v4.app.Fragment;

public class IngredientsGazpachoActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new IngredientsGazpachoFragment();
    }
}
