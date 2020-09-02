package com.example.yogiyo_project.src.main.orderList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;

public class OrderListFragment extends Fragment {
    View mView;
    ViewFlipper mViewFlipper;
    int images[] = {R.drawable.orderlist_ad_capture1,
            R.drawable.orderlist_ad_capture2,
            };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_orderlist, container, false);

        //광고 넘기기
        mViewFlipper = mView.findViewById(R.id.fragment_orderlist_viewflipper_advertise);
        for(int image : images){
            fllipperImages(image);
        }

        return mView;
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
