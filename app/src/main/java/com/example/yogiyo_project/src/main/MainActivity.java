package com.example.yogiyo_project.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryMainActivity;
import com.example.yogiyo_project.src.addressdetailinfo.AddressDetailInfoMainActivity;
import com.example.yogiyo_project.src.main.favorite.FavoriteFragment;
import com.example.yogiyo_project.src.main.foodcategory.FoodCategoryFragment;
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
    private FoodCategoryFragment mFoodCategoryFragment;

    private BottomNavigationView mBottomNavigationView;
    private static FragmentManager mFragmentManager;
    private static FragmentTransaction mFragmentTransaction;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActiviy onCreate");
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

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity onResume");
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

    private long time = 0;
    @Override                       //뒤로가기 버튼을 정해진 시간내에 두번 누를 경우 앱 종료되게 하기
    public void onBackPressed() {
        //super.onBackPressed();
        if(System.currentTimeMillis() - time >= 2000){
            time = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "'뒤로'버튼을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }else if(System.currentTimeMillis()-time<2000){
            finish();
        }
    }

    public void CategoryTxtClick(View view){
        switch(view.getId()){
            case R.id.tv_all:
                ApplicationClass.MENU_CATEGORY_NUM = 0;
                break;
            case R.id.tv_chicken:
                ApplicationClass.MENU_CATEGORY_NUM = 1;
                break;
            case R.id.tv_china:
                ApplicationClass.MENU_CATEGORY_NUM = 2;
                break;
            case R.id.tv_pizza:
                ApplicationClass.MENU_CATEGORY_NUM = 3;
                break;
            case R.id.tv_korean:
                ApplicationClass.MENU_CATEGORY_NUM = 4;
                break;
            case R.id.tv_boonsik:
                ApplicationClass.MENU_CATEGORY_NUM = 5;
                break;
            case R.id.tv_cafe:
                ApplicationClass.MENU_CATEGORY_NUM = 6;
                break;
            case R.id.tv_foroneperson:
                ApplicationClass.MENU_CATEGORY_NUM = 7;
                break;
            case R.id.tv_japan:
                ApplicationClass.MENU_CATEGORY_NUM = 8;
                break;
            case R.id.tv_jokbo:
                ApplicationClass.MENU_CATEGORY_NUM = 9;
                break;
            case R.id.tv_franchise:
                ApplicationClass.MENU_CATEGORY_NUM = 10;
                break;
            case R.id.tv_night:
                ApplicationClass.MENU_CATEGORY_NUM = 11;
                break;
            case R.id.tv_mart:
                ApplicationClass.MENU_CATEGORY_NUM = 12;
                break;
            default:
                break;
        }
        Intent intent = new Intent(MainActivity.this, FoodCategoryMainActivity.class);
        startActivity(intent);
    }
}