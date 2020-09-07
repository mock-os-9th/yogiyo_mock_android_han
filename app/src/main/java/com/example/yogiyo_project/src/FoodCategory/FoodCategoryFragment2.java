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

    public static ListView mLvFoodListListView2; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<FoodCategoryListViewData> fragment2FoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_food_category2, container, false);
        mLvFoodListListView2 = mView.findViewById(R.id.fragment2_listview);
        System.out.println("FoodFragment2 onCreateView");

        return mView;

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("foodfragment2 onResume");
       /* if (ApplicationClass.INPUT_ADDRESS) {
            System.out.println("onResume All food list size = " + FoodCategoryMainActivity.allFoodDataArrayList.size());
            for (int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++) {
                fragment2FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
            }
            mLvFoodListListView2.setAdapter(foodListAdapter2);
            foodListAdapter2.notifyDataSetChanged(); */
        }


    public static void FoodFragment2() {

            System.out.println(FoodCategoryMainActivity.allFoodDataArrayList.size());
            fragment2FoodDataArrayList.clear();
            for (int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++) {
                fragment2FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
            }

                System.out.println(fragment2FoodDataArrayList.size());


             foodListAdapter2 = new FoodCategoryListViewAdapter(fragment2FoodDataArrayList);
             mLvFoodListListView2.setAdapter(foodListAdapter2);
            foodListAdapter2.notifyDataSetChanged();
        }
    }

