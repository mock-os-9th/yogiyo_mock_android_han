package com.example.yogiyo_project.src.FoodCategory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;

import java.util.ArrayList;

public class FoodCategoryFragment2 extends Fragment {
    View mView;

    ListView mLvFoodListListView2; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<FoodCategoryListViewData> fragment2FoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter2 = new FoodCategoryListViewAdapter(fragment2FoodDataArrayList);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_food_category2, container, false);
        mLvFoodListListView2 = mView.findViewById(R.id.fragment2_listview);

        return mView;

    }

    @Override
    public void onResume() {
        super.onResume();

        if(ApplicationClass.INPUT_ADDRESS) {
            for(int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++){
            fragment2FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
                }
            mLvFoodListListView2.setAdapter(foodListAdapter2);
            foodListAdapter2.notifyDataSetChanged();

            }
        }
}
