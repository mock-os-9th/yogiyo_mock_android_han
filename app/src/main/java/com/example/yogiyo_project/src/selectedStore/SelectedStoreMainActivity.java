package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreActivityView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class SelectedStoreMainActivity extends BaseActivity implements SelectStoreActivityView {
    TabLayout mTl;
    ViewPager mVp;
    SelectedStoreViewPagerAdapter mVpAdapter;

    TextView mTvSelectedStoreName;
    TextView mTvScore;
    TextView mTvDeliveryTime;
    TextView mTvMinimumCharge;
    TextView mTvWishCnt;
    TextView mTvDeliveryCharge;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_store_info);

        System.out.println("SelectStore onCreate");


        mVp = findViewById(R.id.selected_stroe_viewpager);
        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mVpAdapter);
        mTl = findViewById(R.id.selected_stroe_tablayout);
        mTl.setupWithViewPager(mVp);

        mTvSelectedStoreName = findViewById(R.id.selected_store_tv_storename);
        mTvDeliveryTime = findViewById(R.id.selected_store_tv_deliverytime);
        mTvScore  = findViewById(R.id.selected_store_tv_rating);
        mTvMinimumCharge = findViewById(R.id.selected_stroe_tv_min_cost);
        mTvWishCnt = findViewById(R.id.selected_store_tv_like_count);
        mTvDeliveryCharge = findViewById(R.id.selected_stroe_tv_delivery_cost);

       /* mTvSelectedStoreName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("통신시작버튼눌림");
                tryGetSelectStore();
            }
        }); */
        tryGetSelectStore();



    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    public void validateFailure(String message) {
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void SelectStoreSuccess(String message) {
            hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
            showCustomToast("성공  "+message);

            mTvSelectedStoreName.setText(ApplicationClass.STORE_NAME);
        mTvDeliveryTime.setText(ApplicationClass.STORE_DELIVERY_TIME);
        mTvScore.setText(String.valueOf(ApplicationClass.STORE_totalScore));
        mTvMinimumCharge.setText(ApplicationClass.STORE_minimumCharge);
        mTvWishCnt.setText(String.valueOf(ApplicationClass.STORE_wishCnt));
        mTvDeliveryCharge.setText(ApplicationClass.STORE_deliverycharge);

        ApplicationClass.REVIEW_COUNT = ApplicationClass.STORE_reviewCnt;
        ApplicationClass.MENU_COUNT = ApplicationClass.STORE_menuCnt;

        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mVpAdapter);
        mTl.setupWithViewPager(mVp);

        mVpAdapter.notifyDataSetChanged();



    }

    private void tryGetSelectStore() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.getSelectedStore();
    }
}
