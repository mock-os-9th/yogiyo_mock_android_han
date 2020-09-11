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

public class FoodCategoryFragment3 extends Fragment {
    View mView;
    public static ListView mLvFoodListListView3; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<FoodCategoryListViewData> fragment3FoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_food_category3, container, false);
       // mLvFoodListListView3 = mView.findViewById(R.id.fragment3_listview);
        System.out.println("FoodFragment3 onCreateView");

        return mView;

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("foodfragment2 onResume");
       // FoodFragment3();
    }

   /* public static void FoodFragment3() {

        System.out.println(FoodCategoryMainActivity.allFoodDataArrayList.size());
        fragment3FoodDataArrayList.clear();
        for (int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++) {
            fragment3FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
        }

        System.out.println(fragment3FoodDataArrayList.size());


        foodListAdapter3 = new FoodCategoryListViewAdapter(fragment3FoodDataArrayList);
        mLvFoodListListView3.setAdapter(foodListAdapter3);
        foodListAdapter3.notifyDataSetChanged();
    }*/
}
