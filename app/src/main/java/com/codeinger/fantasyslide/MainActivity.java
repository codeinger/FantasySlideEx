package com.codeinger.fantasyslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.mzule.fantasyslide.FantasyDrawerLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FantasyDrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        replace(new HomeFragment());

    }

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        ImageView menu = findViewById(R.id.menu);

        LinearLayout ll_Home = findViewById(R.id.ll_Home);
        LinearLayout ll_Profile = findViewById(R.id.ll_Profile);
        LinearLayout ll_Setting = findViewById(R.id.ll_Setting);
        LinearLayout ll_Share = findViewById(R.id.ll_Share);
        LinearLayout ll_Logout = findViewById(R.id.ll_Logout);



        menu.setOnClickListener(this);
        ll_Home.setOnClickListener(this);
        ll_Profile.setOnClickListener(this);
        ll_Setting.setOnClickListener(this);
        ll_Share.setOnClickListener(this);
        ll_Logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.ll_Home:
                replace(new HomeFragment(),"Home");
                break;

            case R.id.ll_Profile:
                replace(new ProfileFragment(),"Profile");
                break;

            case R.id.ll_Setting:
                replace(new SettingFragment(),"Setting");
                break;

            case R.id.ll_Share:
                Toast.makeText(this, "Share.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ll_Logout:
                Toast.makeText(this, "Logout.", Toast.LENGTH_SHORT).show();
                break;

        }

    }


    void replace(Fragment fragment,String s){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.addToBackStack(s);
        transaction.commit();
    }

    void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }

}