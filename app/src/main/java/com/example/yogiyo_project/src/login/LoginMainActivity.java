package com.example.yogiyo_project.src.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.signup.SignUpMainActivity;

public class LoginMainActivity extends AppCompatActivity {
    ImageView mIvActivityLoginClose;
    TextView mTvActivityLoginGoToSignUp;
    EditText mEtActivityLoginEmail;
    EditText mEtActivityLoginPassWord;
    TextView mTvActivityLoginLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTvActivityLoginLogin = findViewById(R.id.activity_login_tv_loginbtn);

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
                Intent intent = new Intent(LoginMainActivity.this, SignUpMainActivity.class);
                startActivity(intent);
            }
        });

        mEtActivityLoginEmail = findViewById(R.id.activity_login_tv_input_email);
        mEtActivityLoginPassWord = findViewById(R.id.activity_login_tv_input_password);
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

}
