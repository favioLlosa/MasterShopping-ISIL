package com.system.mastershopping_isil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.system.mastershopping_isil.fragments.CheckoutFragment;
import com.system.mastershopping_isil.fragments.EditProfileFragment;
import com.system.mastershopping_isil.fragments.OrderFragment;
import com.system.mastershopping_isil.fragments.ProfileFragment;
import com.system.mastershopping_isil.fragments.ProfileMainFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    public void toProfile(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_main2, new ProfileMainFragment())
                .commit();
        defaultSettings();
    }

    public void editProfile(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_profile, new EditProfileFragment())
                .commit();
    }

    public void defaultSettings(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_profile, new ProfileFragment())
                .commit();
    }

    public void openOrders(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_main2, new OrderFragment())
                .commit();
    }

    public void checkout(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ly_main2, new CheckoutFragment())
                .commit();
    }

    public void initComponent(){
        tab_layout = (TabLayout) findViewById(R.id.tab_layout2);

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_home), 0);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite), 1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_shopping_cart), 2);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person), 3);

        tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()){
                    case 0:
                        System.out.println("Home");
                        break;
                    case 1:
                        Favorites();
                        break;
                    case 2:
                        System.out.println("Cart");
                        break;
                    case 3:
                        toProfile();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void Favorites(){
        startActivity(new Intent(this, FavoritesActivity.class));
    }
    public void changeColor(String primaryDark, String primary){
        getWindow().setStatusBarColor(Color.parseColor(primaryDark));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
    }
}