package com.example.taobaounion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.taobaounion.R;
import com.example.taobaounion.ui.fragment.HomeFragment;
import com.example.taobaounion.ui.fragment.RedPacketFragment;
import com.example.taobaounion.ui.fragment.SearchFragment;
import com.example.taobaounion.ui.fragment.SelectedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView bottomNavigationView;
    private  HomeFragment homeFragment;
    private RedPacketFragment redPacketFragment;
    private SearchFragment searchFragment;
    private SelectedFragment selectedFragment;
    private FragmentManager fragmentManager;
    private  static  final  String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initFragment();
        initLisenter();
    }
    private  void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fn = getSupportFragmentManager();
        FragmentTransaction transaction = fn.beginTransaction();
        transaction.add(R.id.main_page_container,homeFragment);
        transaction.commit();
    }
    private  void initFragment() {
        homeFragment = new HomeFragment();
        redPacketFragment = new RedPacketFragment();
        searchFragment = new SearchFragment();
        selectedFragment = new SelectedFragment();
        fragmentManager = getSupportFragmentManager();
    }
    private  void initLisenter() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d(TAG, "title"  +item.getTitle());
                if (item.getItemId() == R.id.home) {
                    swithFragment(homeFragment);
                } else if (item.getItemId() == R.id.selected) {
                    swithFragment(selectedFragment);
                } else if (item.getItemId() == R.id.red_packet) {
                    swithFragment(redPacketFragment);
                } else {
                    swithFragment(searchFragment);
                }
                return true;
            }
        });
    }
    private  void  swithFragment(Fragment targetFragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container,targetFragment);
        fragmentTransaction.commit();
    }

}
