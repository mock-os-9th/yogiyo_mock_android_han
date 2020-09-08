package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.BaseActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SelectedStoreMainActivity extends BaseActivity {
    TabLayout mTl;
    ViewPager mVp;
    SelectedStoreViewPagerAdapter mVpAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_store_info);


        mVp = findViewById(R.id.selected_stroe_viewpager);
        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mVpAdapter);
        mTl = findViewById(R.id.selected_stroe_tablayout);
        mTl.setupWithViewPager(mVp);



    }

    @Override
    protected void onResume() {
        super.onResume();
        mVpAdapter.notifyDataSetChanged();
    }

    public void refresh(){
        mVpAdapter.notifyDataSetChanged();
    }
}
