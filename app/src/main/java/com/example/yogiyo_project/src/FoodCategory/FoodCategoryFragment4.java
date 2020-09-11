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

import java.util.ArrayList;

public class FoodCategoryFragment4 extends Fragment {
    View mView;

    public static ListView mLvFoodListListView4; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<FoodCategoryListViewData> fragment4FoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_food_category4, container, false);
        //mLvFoodListListView4 = mView.findViewById(R.id.fragment4_listview);
        System.out.println("FoodFragment4 onCreateView");

        return mView;

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("foodfragment4 onResume");

        //FoodFragment4();
    }

   /* public static void FoodFragment4() {

        System.out.println(FoodCategoryMainActivity.allFoodDataArrayList.size());
        fragment4FoodDataArrayList.clear();
        for (int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++) {
            fragment4FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
        }

        System.out.println(fragment4FoodDataArrayList.size());


        foodListAdapter4 = new FoodCategoryListViewAdapter(fragment4FoodDataArrayList);
        mLvFoodListListView4.setAdapter(foodListAdapter4);
        foodListAdapter4.notifyDataSetChanged();
    }*/
}
