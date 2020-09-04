package com.example.yogiyo_project.src.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.login.interfaces.LogInActivityView;
import com.example.yogiyo_project.src.login.models.LogInResponse;
import com.example.yogiyo_project.src.main.myYogiyo.MyYogiyoFragment;
import com.example.yogiyo_project.src.signup.SignUpMainActivity;

import static com.example.yogiyo_project.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.yogiyo_project.src.ApplicationClass.sSharedPreferences;

public class LogInMainActivity extends BaseActivity implements LogInActivityView {
    ImageView mIvActivityLoginClose;
    TextView mTvActivityLoginGoToSignUp;
    EditText mEtActivityLoginEmail;
    EditText mEtActivityLoginPassWord;
    TextView mTvActivityLoginLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        System.out.println("LogIn Activity onCreate");

        mTvActivityLoginLogin = findViewById(R.id.activity_login_tv_loginbtn);
        mTvActivityLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryPostLogIn();
            }
        });

        mIvActivityLoginClose=findViewById(R.id.activity_login_iv_closeicon);
        mIvActivityLoginClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mTvActivityLoginGoToSignUp = findViewById(R.id.activity_login_tv_goto_signup);
        mTvActivityLoginGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInMainActivity.this, SignUpMainActivity.class);
                startActivity(intent);
            }
        });

        mEtActivityLoginEmail = findViewById(R.id.activity_login_tv_input_email);
        mEtActivityLoginPassWord = findViewById(R.id.activity_login_tv_input_password);  //이메일, 비밀번호 모두 (공백x)입력 감지시 로그인 버튼 색상 변경
        mEtActivityLoginEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
               if(!mEtActivityLoginPassWord.getText().toString().trim().equals("")) {
                   if(mEtActivityLoginPassWord.getText().length() != 0){
                   if (!mEtActivityLoginEmail.getText().toString().trim().equals("")) {
                       if (mEtActivityLoginEmail.getText().length() != 0) {
                           mTvActivityLoginLogin.setBackgroundColor(Color.RED);
                       }
                   }
                   }
               }
               if(mEtActivityLoginEmail.getText().toString().trim().equals("")){
                   if (mEtActivityLoginEmail.getText().length() == 0){
                       mTvActivityLoginLogin.setBackgroundColor(Color.parseColor("#A3A3A3"));
                   }
               }
            }
        });

        mEtActivityLoginPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!mEtActivityLoginEmail.getText().toString().trim().equals("")) {
                    if(mEtActivityLoginEmail.getText().length() != 0){
                        if (!mEtActivityLoginPassWord.getText().toString().trim().equals("")) {
                            if (mEtActivityLoginPassWord.getText().length() != 0) {
                                mTvActivityLoginLogin.setBackgroundColor(Color.RED);
                            }
                        }
                    }
                }
                if(mEtActivityLoginPassWord.getText().toString().trim().equals("")){
                    if (mEtActivityLoginPassWord.getText().length() == 0){
                        mTvActivityLoginLogin.setBackgroundColor(Color.parseColor("#A3A3A3"));
                    }
                }

            }
        });



    }

    private void tryPostLogIn() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것

        final LogInMainService logInmainService = new LogInMainService(this);
        logInmainService.postLogIn(mEtActivityLoginEmail.getText().toString(),
                mEtActivityLoginPassWord.getText().toString());     //MainService 객체 생성 시 생성자에 this를 넣는다(MainActivity자신) -> MainActivityView를 구현했으므로 가능
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void logInSuccess(String message, LogInResponse.LogInResult logInResult) {
        hideProgressDialog();
        showCustomToast(message);

        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString(X_ACCESS_TOKEN, logInResult.getJwt());
        editor.commit();

        System.out.println("로그인 성공");

        ApplicationClass.logInState = true;
        MyYogiyoFragment.MyYogiyoFragmentUIChangeAsLogIn();

        onBackPressed();



    }
}
