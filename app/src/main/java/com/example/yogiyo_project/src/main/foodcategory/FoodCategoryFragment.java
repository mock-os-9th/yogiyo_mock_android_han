package com.example.yogiyo_project.src.main.foodcategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.example.yogiyo_project.src.main.MainActivity;

public class FoodCategoryFragment extends Fragment {
    View mView;
    TextView mTvFoodCategoryAddress;
    ImageView mIvFoodCategoryBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_food_category, container, false);

        mTvFoodCategoryAddress = mView.findViewById(R.id.fragment_food_category_tv_address);
        mTvFoodCategoryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), AddressMainActivity.class);
                startActivity(intent);
            }
        });
        mIvFoodCategoryBack = mView.findViewById(R.id.fragment_food_category_iv_back);
        mIvFoodCategoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.setFrag(0);
            }
        });


        return mView;

    }
}
