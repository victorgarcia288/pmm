package com.example.victeb.preferencias;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by victeb on 15/12/17.
 */

public class SettingsFragment extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}
