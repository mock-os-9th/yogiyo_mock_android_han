package com.example.yogiyo_project.src.selectedmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;

public class SelectedMenuMainActivity extends BaseActivity {
    ImageView mIvMenuImage;
    TextView mTvMenuName;
    TextView mTvMenuInfo;
    TextView mTvMenuPrice;

    TextView mTvTotalCount;
    TextView mTvPlus;
    TextView mTvMinus;
    TextView mTvTotalPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_menu);

        mIvMenuImage = findViewById(R.id.selected_menu_iv_menuimage);
        mTvMenuName = findViewById(R.id.selected_menu_tv_menuname);
        mTvMenuInfo = findViewById(R.id.selected_menu_tv_menuinfo);
        mTvMenuPrice = findViewById(R.id.selected_menu_tv_menuprice);

        mIvMenuImage.setImageResource(ApplicationClass.MENU_IAMGE);
        mTvMenuName.setText(ApplicationClass.MENU_NAME);
        mTvMenuInfo.setText(ApplicationClass.MENU_INFO);
        mTvMenuPrice.setText(ApplicationClass.MENU_PRICE);

        mTvTotalCount = findViewById(R.id.selected_menu_tv_count_presentmenutotal);
        mTvPlus = findViewById(R.id.selected_menu_tv_plus);
        mTvMinus = findViewById(R.id.selected_menu_tv_minus);
        mTvTotalPrice = findViewById(R.id.selected_menu_tv_price_presentmenutotal);
        mTvTotalPrice.setText(ApplicationClass.MENU_PRICE);


        mTvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int count = Integer.parseInt(mTvTotalCount.getText().toString());
                    count += 1;
                    mTvTotalCount.setText(String.valueOf(count));
                int menuPrice = Integer.parseInt(mTvMenuPrice.getText().toString());
                int totalPrice = menuPrice * count;
                mTvTotalPrice.setText(String.valueOf(totalPrice));
            }
        });
        mTvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(mTvTotalCount.getText().toString());
                if(count >= 2){
                    count -= 1;
                }
                mTvTotalCount.setText(String.valueOf(count));
                int menuPrice = Integer.parseInt(mTvMenuPrice.getText().toString());
                int totalPrice = menuPrice * count;
                mTvTotalPrice.setText(String.valueOf(totalPrice));
            }
        });


    }
}
