package com.prueba.lgramir.Gazpchos;


import android.support.v4.app.Fragment;

public class FruitDayFruitActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FruitDayFruitFragment();
    }
}
