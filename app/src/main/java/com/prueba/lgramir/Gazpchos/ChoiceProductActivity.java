package com.prueba.lgramir.Gazpchos;

import android.support.v4.app.Fragment;

public class ChoiceProductActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ChoiceProductFragment();
    }
}
