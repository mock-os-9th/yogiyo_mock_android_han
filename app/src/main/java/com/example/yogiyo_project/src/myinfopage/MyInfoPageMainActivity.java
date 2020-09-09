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
import com.example.yogiyo_project.src.myinfopage.inferfaces.MyInfoPageActivityView;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreMainService;

public class MyInfoPageMainActivity extends BaseActivity implements MyInfoPageActivityView {
    static TextView mTvMyInfoEmail;
    static TextView mTvMyInfoPassword;
    static TextView mTvMyInfoPhoneNum;
    static TextView mTvMyInfoNickname;

    static TextView mTvMyInfoLogout;
    static TextView mTvMyInfoWithdrawal;


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

        tryGetMyInfo();
    }

    /*public static void MyInfoInput(String userEmail, String password, String nickName, String phoneNum){ //회원 가입 시 저장한 스트링 값들 가져와야 함
        mUserEmail = userEmail;
        mPassword = password;
        mNickName = nickName;
        mPhoneNum = phoneNum;
    }*/

    @Override
    public void validateFailure(String message) {
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void MyInfoSuccess(String userEmail, String passWord, String phoneNum, String nickName) {
        hideProgressDialog();
        mTvMyInfoEmail.setText(userEmail);
        mTvMyInfoPassword.setText(passWord);
        mTvMyInfoNickname.setText(nickName);
        mTvMyInfoPhoneNum.setText("0"+phoneNum);
    }

    private void tryGetMyInfo() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final MyInfoPageService myInfoPageService = new MyInfoPageService(this);
        myInfoPageService.getMyInfo();
    }
}
