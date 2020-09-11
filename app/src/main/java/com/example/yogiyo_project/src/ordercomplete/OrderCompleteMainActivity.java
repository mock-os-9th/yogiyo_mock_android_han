package com.example.yogiyo_project.src.ordercomplete;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;

public class OrderCompleteMainActivity extends BaseActivity {
    TextView mTvTotalCost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mTvTotalCost = findViewById(R.id.total_cost);
        mTvTotalCost.setText(String.valueOf(ApplicationClass.TOTAL_COST)); // 총 가격 대입

    }
}
