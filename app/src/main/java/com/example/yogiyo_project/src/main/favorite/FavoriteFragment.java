package com.example.yogiyo_project.src.main.favorite;

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
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryMainActivity;
import com.example.yogiyo_project.src.login.LogInMainActivity;

public class FavoriteFragment extends Fragment {
    View mView;
    TextView mTvGotoLogin;
    TextView mTvGotoFoodCategory;

    TextView mTvAfterLogin1;
    TextView mTvAfterLogin2;
    TextView mTvBeforeLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_favorite, container, false);
        System.out.println("FavoriteFragment onCreateView");

        mTvAfterLogin1 = mView.findViewById(R.id.fragment_favorite_tv_afterlogin1);
        mTvAfterLogin2 = mView.findViewById(R.id.fragment_favorite_tv_afterlogin2);
        mTvBeforeLogin = mView.findViewById(R.id.fragment_favorite_tv_beforeloginment);

        mTvGotoLogin = mView.findViewById(R.id.fragment_favorite_tv_gotologin);
        mTvGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), LogInMainActivity.class);
                startActivity(intent);
            }
        });
        mTvGotoFoodCategory = mView.findViewById(R.id.fragment_favorite_tv_gotofoodcategory);
        mTvGotoFoodCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), FoodCategoryMainActivity.class);
                startActivity(intent);
            }
        });

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
            //로그인 상태에 따라 화면 구성 바뀜
        if(ApplicationClass.logInState){
            mTvAfterLogin1.setVisibility(View.VISIBLE);
            mTvAfterLogin2.setVisibility(View.VISIBLE);
            mTvBeforeLogin.setVisibility(View.GONE);
            mTvGotoFoodCategory.setVisibility(View.VISIBLE);
            mTvGotoLogin.setVisibility(View.GONE);
        }
        else{
            mTvAfterLogin1.setVisibility(View.GONE);
            mTvAfterLogin2.setVisibility(View.GONE);
            mTvBeforeLogin.setVisibility(View.VISIBLE);
            mTvGotoFoodCategory.setVisibility(View.GONE);
            mTvGotoLogin.setVisibility(View.VISIBLE);
        }
    }
}
