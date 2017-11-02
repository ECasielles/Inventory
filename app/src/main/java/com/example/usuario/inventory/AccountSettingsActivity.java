package com.example.usuario.inventory;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Clase que guarda las preferencias de cuenta de la aplicación
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see PreferenceActivity
 */
public class AccountSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }

}
