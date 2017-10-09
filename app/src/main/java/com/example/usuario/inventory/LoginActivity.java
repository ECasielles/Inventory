package com.example.usuario.inventory;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Actividad que maneja el alta de usuarios y
 * el ingreso a la aplicación.
 *
 * Cuando ingresa un usuario se lanza la actividad Dashboard
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */

public class LoginActivity extends AppCompatActivity {

    private TextView txvSignUp;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txvSignUp = (TextView) findViewById(R.id.txvSignUp);
        txvSignUp.setPaintFlags(txvSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
