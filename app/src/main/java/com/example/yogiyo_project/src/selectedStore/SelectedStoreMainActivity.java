package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.BaseActivity;
import com.google.android.material.tabs.TabLayout;

public class SelectedStoreMainActivity extends BaseActivity {
    TabLayout mTl;
    ViewPager mVp;
    SelectedStoreViewPagerAdapter mVpAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_store_info);

        mTl = findViewById(R.id.selected_stroe_tablayout);
        mVp = findViewById(R.id.selected_stroe_viewpager);
        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());

        mVp.setAdapter(mVpAdapter);
        mTl.setupWithViewPager(mVp);

    }
}
