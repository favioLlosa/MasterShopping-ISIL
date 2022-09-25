package com.system.mastershopping_isil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.system.mastershopping_isil.fragments.CheckoutFragment;
import com.system.mastershopping_isil.fragments.OrderFragment;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        showOrderDefault();
    }

    public void showOrderDefault(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_order_main, new OrderFragment())
                .commit();
    }

    public void checkout(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_order_main, new CheckoutFragment())
                .commit();
    }
}