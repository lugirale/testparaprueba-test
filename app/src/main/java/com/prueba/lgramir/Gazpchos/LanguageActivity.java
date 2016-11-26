package com.prueba.lgramir.Gazpchos;

import android.support.v4.app.Fragment;

public class LanguageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LanguageFragment();
    }
}