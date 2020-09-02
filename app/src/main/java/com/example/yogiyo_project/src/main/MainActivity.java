package com.example.yogiyo_project.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.main.favorite.FavoriteFragment;
import com.example.yogiyo_project.src.main.foodcategory.FoodCategoryFragment;
import com.example.yogiyo_project.src.main.home.CategoryTopRecyclerAdapter;
import com.example.yogiyo_project.src.main.home.HomeFragment;
import com.example.yogiyo_project.src.main.myYogiyo.MyYogiyoFragment;
import com.example.yogiyo_project.src.main.orderList.OrderListFragment;
import com.example.yogiyo_project.src.main.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private  HomeFragment mHomeFragment;
    private  FavoriteFragment mFavoriteFragment;
    private  SearchFragment mSearchFragment;
    private  OrderListFragment mOrderListFragment;
    private  MyYogiyoFragment mMyYogiyoFragment;
    private  FoodCategoryFragment mFoodCategoryFragment;

    private BottomNavigationView mBottomNavigationView;
    private static FragmentManager mFragmentManager;
    private static FragmentTransaction mFragmentTransaction;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();


        mHomeFragment = new HomeFragment();
        mFavoriteFragment = new FavoriteFragment();
        mSearchFragment = new SearchFragment();
        mOrderListFragment = new OrderListFragment();
        mMyYogiyoFragment = new MyYogiyoFragment();
        mFoodCategoryFragment = new FoodCategoryFragment();

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_navigationview);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        setFrag(0);
                        break;
                    case R.id.menu_favorite:
                        setFrag(1);
                        break;
                    case R.id.menu_search:
                        setFrag(2);
                        break;
                    case R.id.menu_orderlist:
                        setFrag(3);
                        break;
                    case R.id.menu_myyogiyo:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });

            setFrag(0); //시작 시 자동으로 홈 화면 선택


    }



    /*static*/ public void setFrag(int n){   //setfrag5 위해서 static으로 하면 프래먼트 간 이동방식으로 가능 하지만 static 좋지 않으므로 우선 액티비티 이동으로 하기
        mFragmentTransaction = mFragmentManager.beginTransaction();

        switch(n) {
            case 0:
                mFragmentTransaction.replace(R.id.main_framelayout, mHomeFragment);
                mFragmentTransaction.commit();
                break;
            case 1:
                mFragmentTransaction.replace(R.id.main_framelayout, mFavoriteFragment);
                mFragmentTransaction.commit();
                break;
            case 2:
                mFragmentTransaction.replace(R.id.main_framelayout, mSearchFragment);
                mFragmentTransaction.commit();
                break;
            case 3:
                mFragmentTransaction.replace(R.id.main_framelayout, mOrderListFragment);
                mFragmentTransaction.commit();
                break;
            case 4:
                mFragmentTransaction.replace(R.id.main_framelayout, mMyYogiyoFragment);
                mFragmentTransaction.commit();
                break;
            case 5:
                mFragmentTransaction.replace(R.id.main_framelayout, mFoodCategoryFragment);
                mFragmentTransaction.commit();
                break;
        }
    }
}