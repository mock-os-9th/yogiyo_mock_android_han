package com.example.yogiyo_project.src.FoodCategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.google.android.material.tabs.TabLayout;

public class FoodCategoryMainActivity extends AppCompatActivity {
    TextView mTvFoodCategoryAddress;
    ImageView mIvFoodCategoryBack;
    ViewPager mVp;
    FoodCategoryViewPagerAdapter mViewPagerAdapter;
    TabLayout mTl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        System.out.println("FoodCategory onCreate");

        mTvFoodCategoryAddress = findViewById(R.id.fragment_food_category_tv_address); //상단 주소 텍스트 누를 시 주소 설정 액티비로 이동
        mTvFoodCategoryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodCategoryMainActivity.this, AddressMainActivity.class);
                startActivity(intent);
            }
        });
        mIvFoodCategoryBack = findViewById(R.id.fragment_food_category_iv_back);
        mIvFoodCategoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mVp = findViewById(R.id.activity_foodcategory_viewpager);
        mViewPagerAdapter = new FoodCategoryViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mViewPagerAdapter);

        mTl = findViewById(R.id.fragment_food_category_tablayout);
        mTl.setupWithViewPager(mVp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("FoodCategory onResume");
        if(ApplicationClass.InputAddress){   //주소 선택 시 상단에 주소 값 변경되게 하기
            mTvFoodCategoryAddress.setText(ApplicationClass.DONG_NAME+" "+ApplicationClass.MAIN_ADDRESS_NO);
        }
    }
}
