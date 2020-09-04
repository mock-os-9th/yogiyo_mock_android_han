package com.example.yogiyo_project.src.FoodCategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;

public class FoodCategoryMainActivity extends AppCompatActivity {
    TextView mTvFoodCategoryAddress;
    ImageView mIvFoodCategoryBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_food_category);

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

    }
}
