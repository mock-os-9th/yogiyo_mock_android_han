package com.example.yogiyo_project.src.myinfopage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.main.myYogiyo.MyYogiyoFragment;

public class MyInfoPageMainActivity extends BaseActivity {
    static TextView mTvMyInfoEmail;
    static TextView mTvMyInfoPassword;
    static TextView mTvMyInfoPhoneNum;
    static TextView mTvMyInfoNickname;

    static TextView mTvMyInfoLogout;
    static TextView mTvMyInfoWithdrawal;

    static String mUserEmail;
    static String mPassword;
    static String mNickName;
    static String mPhoneNum;

    ImageView mIvMyInfoBackBtn;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_page);

        mIvMyInfoBackBtn = findViewById(R.id.activity_myinfopage_iv_back); //왼쪽 상단 뒤로가기 버튼
        mIvMyInfoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mTvMyInfoEmail = findViewById(R.id.activity_myinfopage_tv_email);
        mTvMyInfoPassword = findViewById(R.id.activity_myinfopage_tv_password);
        mTvMyInfoPhoneNum = findViewById(R.id.activity_myinfopage_tv_phonenum);
        mTvMyInfoNickname = findViewById(R.id.activity_myinfopage_tv_nickname);

        mTvMyInfoEmail.setText(mUserEmail);
        mTvMyInfoPassword.setText(mPassword);
        mTvMyInfoNickname.setText(mNickName);
        mTvMyInfoPhoneNum.setText(mPhoneNum);

        mTvMyInfoLogout = findViewById(R.id.activity_myinfopage_tv_logout); //로그아웃 클릭 시
        mTvMyInfoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationClass.LOGIN_STATE = false;
                MyYogiyoFragment.MyYogiyoFragmentUIChangeAsLogIn();
                showCustomToast("로그아웃 되었습니다");
                onBackPressed(); //마이요기요 프래그먼트로 복귀
            }
        });
    }

    public static void MyInfoInput(String userEmail, String password, String nickName, String phoneNum){ //회원 가입 시 저장한 스트링 값들 가져와야 함
        mUserEmail = userEmail;
        mPassword = password;
        mNickName = nickName;
        mPhoneNum = phoneNum;
    }
}
