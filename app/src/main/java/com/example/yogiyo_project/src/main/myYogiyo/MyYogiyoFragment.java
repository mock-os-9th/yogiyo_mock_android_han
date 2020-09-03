package com.example.yogiyo_project.src.main.myYogiyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.login.LoginMainActivity;
import com.example.yogiyo_project.src.main.MainActivity;
import com.example.yogiyo_project.src.signup.SignUpMainActivity;

public class MyYogiyoFragment extends Fragment {
    View mView;
    TextView mTvGoToLogin;
    TextView mTvGoToSignUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_myyogiyo, container, false);

        mTvGoToLogin = mView.findViewById(R.id.fragment_myyogiyo_tv_gotologin);
        mTvGoToSignUp = mView.findViewById(R.id.fragment_myyogiyo_tv_signup);

        mTvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), LoginMainActivity.class);
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

        return mView;
    }
}
