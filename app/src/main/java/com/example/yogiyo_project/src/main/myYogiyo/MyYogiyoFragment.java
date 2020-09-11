package com.example.yogiyo_project.src.main.myYogiyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.login.LogInMainActivity;
import com.example.yogiyo_project.src.myinfopage.MyInfoPageMainActivity;
import com.example.yogiyo_project.src.signup.SignUpMainActivity;

public class MyYogiyoFragment extends Fragment {
    View mView;
    TextView mTvGoToLogin;
    TextView mTvGoToSignUp;

    static ImageView mIvSuperclubAdBeforeLogin;
    static ImageView mIvSuperclubAdAfterLogin;

    static TextView mTvCoupon;
    static TextView mTvPoint;
    static TextView mTvReview;
    static TextView mTvNickName;

    static RelativeLayout mRlBeforeLoginInfo;
    static RelativeLayout mRlAfterLoginInfo;

    ImageView mIvAfterLoginGoToMyInfoPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_myyogiyo, container, false);



        System.out.println("MyYogiyoFragment onCreateView");

        mTvGoToLogin = mView.findViewById(R.id.fragment_myyogiyo_tv_gotologin);
        mTvGoToSignUp = mView.findViewById(R.id.fragment_myyogiyo_tv_signup);

        mTvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), LogInMainActivity.class);
                startActivity(intent);
            }
        });

        mTvGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), SignUpMainActivity.class);
                startActivity(intent);
            }
        });

        // 슈퍼클럽 광고 그림 로그인 전후로 다르므로 설정
        mIvSuperclubAdBeforeLogin = mView.findViewById(R.id.fragment_yogiyo_iv_superclub_ad_beforelogin);
        mIvSuperclubAdAfterLogin = mView.findViewById(R.id.fragment_yogiyo_iv_superclub_ad_afterlogin);
        // 쿠폰함, 포인트, 리뷰관리, 닉네임 텍스트뷰
        mTvCoupon = mView.findViewById(R.id.fragment_myyogiyo_tv_coupon);
        mTvPoint = mView.findViewById(R.id.fragment_myyogiyo_tv_point);
        mTvReview = mView.findViewById(R.id.fragment_myyogiyo_tv_review);
        mTvNickName = mView.findViewById(R.id.fragment_myyogiyo_tv_nickName);
        //상단 로그인 정보 relativelayout
        mRlBeforeLoginInfo = mView.findViewById(R.id.fragment_myyogiyo_relativelayout_beforelogin);
        mRlAfterLoginInfo = mView.findViewById(R.id.fragment_myyogiyo_relativelayout_afterlogin);


        MyYogiyoFragmentUIChangeAsLogIn(); // 다른 화면 갔다가 돌아올 시 상태 유지를 위함

        mIvAfterLoginGoToMyInfoPage = mView.findViewById(R.id.fragment_myyogiyo_iv_afterlogin_gotomyinfo);
        mIvAfterLoginGoToMyInfoPage.setOnClickListener(new View.OnClickListener() {  //로그인 후 내 정보 페이지 가기 위함
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), MyInfoPageMainActivity.class);
                startActivity(intent);
            }
        });

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("MyYogiyo fragment onResume");
        MyYogiyoFragmentUIChangeAsLogIn();
    }

    public static void MyYogiyoFragmentUIChangeAsLogIn(){
        if(ApplicationClass.LOGIN_STATE){
            mIvSuperclubAdBeforeLogin.setVisibility(View.GONE);
            mIvSuperclubAdAfterLogin.setVisibility(View.VISIBLE);

            mRlBeforeLoginInfo.setVisibility(View.GONE);
            mRlAfterLoginInfo.setVisibility(View.VISIBLE);

            mTvCoupon.setText(String.valueOf(ApplicationClass.INFO_couponCnt));
            mTvPoint.setText(String.valueOf(ApplicationClass.INFO_leftPoint));
            mTvReview.setText(String.valueOf(ApplicationClass.INFO_reviewCnt));
            mTvNickName.setText(ApplicationClass.INFO_nickName);

        }
        else{
            mIvSuperclubAdBeforeLogin.setVisibility(View.VISIBLE);
            mIvSuperclubAdAfterLogin.setVisibility(View.GONE);

            mRlBeforeLoginInfo.setVisibility(View.VISIBLE);
            mRlAfterLoginInfo.setVisibility(View.GONE);

            mTvCoupon.setText("-");
            mTvPoint.setText("-");
            mTvReview.setText("0");
            mTvNickName.setText("닉네임을 설정해주세요.");

        }
    }
}
