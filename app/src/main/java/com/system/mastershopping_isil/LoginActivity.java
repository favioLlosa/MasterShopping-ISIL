package com.system.mastershopping_isil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtCreate_Account = findViewById(R.id.txtCreate_Account);
        txtCreate_Account.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, ButtonSignActivityGoogle.class));
    }

    public void mainActivity(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}