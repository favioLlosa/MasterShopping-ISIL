package com.system.mastershopping_isil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.system.mastershopping_isil.fragments.EditProfileFragment;
import com.system.mastershopping_isil.fragments.ProfileFragment;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Dialog msDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);
        showDefault();
    }

    @Override
    public void onClick(View view) {
        editProfile();
    }

    public void editProfile(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_profile, new EditProfileFragment())
                .commit();
    }

    public void openOrders(View v){
        startActivity(new Intent(this, OrderActivity.class));
    }

    public void showDefault(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_profile, new ProfileFragment())
                .commit();
    }
}