package com.prueba.lgramir.Gazpchos;


import android.support.v4.app.Fragment;

public class IngredientsFruitActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new IngredientsFruitFragment();
    }
}