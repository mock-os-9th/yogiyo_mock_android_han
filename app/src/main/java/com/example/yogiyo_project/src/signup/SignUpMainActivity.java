package com.example.yogiyo_project.src.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.main.MainService;
import com.example.yogiyo_project.src.signup.Interfaces.SignUpActivityView;

public class SignUpMainActivity extends BaseActivity implements SignUpActivityView {
    EditText mEtSignUpEmail;
    EditText mEtSignUpPassWord;
    EditText mEtSignUpCheckPassWord;
    EditText mEtSignUpNickName;
    EditText mEtSignUpPhoneNum;

    TextView mTvSignUpTryNextStep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        System.out.println("SignUp Activity onCreate");

        mEtSignUpEmail = findViewById(R.id.activity_login_tv_input_email);
        mEtSignUpPassWord = findViewById(R.id.activity_login_tv_input_password);
        mEtSignUpCheckPassWord = findViewById(R.id.activity_login_tv_input_checkpassword);
        mEtSignUpNickName = findViewById(R.id.activity_login_tv_input_nickname);
        mEtSignUpPhoneNum = findViewById(R.id.activity_login_tv_input_phonenum);

       mTvSignUpTryNextStep = findViewById(R.id.activity_signup_tv_trynextstep);
       mTvSignUpTryNextStep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tryPostSignUp();
           }
       });
    }

    private void tryPostSignUp() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것

        final  SignUpMainService signUpMainService = new SignUpMainService(this);
        signUpMainService.postSignUp("Y", mEtSignUpEmail.getText().toString(), mEtSignUpPassWord.getText().toString()
                , mEtSignUpCheckPassWord.getText().toString(), mEtSignUpNickName.getText().toString(), mEtSignUpPhoneNum.getText().toString());
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();  //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(text);

    }

    @Override
    public void validateFailure(String message) { //회원 가입 실패 시
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void signUpSuccess(String message) {  //회원 가입 성공 시 호출
        hideProgressDialog();
        showCustomToast(message);
        System.out.println(message);
    }


}
