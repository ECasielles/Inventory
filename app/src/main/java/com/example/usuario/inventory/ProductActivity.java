package com.example.usuario.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Actividad que maneja el alta de productos
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
}
