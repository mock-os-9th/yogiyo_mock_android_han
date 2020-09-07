package com.example.yogiyo_project.src.main.orderList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryMainActivity;

public class OrderListFragment extends Fragment {
    View mView;
    ViewFlipper mViewFlipper;
    int images[] = {R.drawable.orderlist_ad_capture1,
            R.drawable.orderlist_ad_capture2,
            };
    TextView mTvGoToFoodList;
    TextView mTvTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_orderlist, container, false);
        System.out.println("OrderList Fragment onCreateView");

        //광고 넘기기
        mViewFlipper = mView.findViewById(R.id.fragment_orderlist_viewflipper_advertise);
        for(int image : images){
            fllipperImages(image);
        }

        mTvGoToFoodList = mView.findViewById(R.id.fragment_orderlist_tv_gotoorder);
        mTvGoToFoodList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationClass.MENU_CATEGORY_NUM = 0;
                Intent intent = new Intent(mView.getContext(), FoodCategoryMainActivity.class);
                startActivity(intent);
            }
        });
        mTvTitle = mView.findViewById(R.id.fragment_orderlist_tv_title);

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(ApplicationClass.LOGIN_STATE){
            mTvTitle.setText("회원 주문내역");
        } else{
          mTvTitle.setText("비회원 주문내역");
        }
    }

    //상단 광고 넘기는 method
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(image);

        mViewFlipper.addView(imageView);      // 이미지 추가
        mViewFlipper.setFlipInterval(3500);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        mViewFlipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        mViewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        mViewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }
}
