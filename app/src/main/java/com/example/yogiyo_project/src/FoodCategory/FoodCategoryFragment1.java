package com.example.yogiyo_project.src.FoodCategory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.FoodCategory.interfaces.FoodCategoryActivityView;
import com.example.yogiyo_project.src.addressoption.AddressAdapter;
import com.example.yogiyo_project.src.addressoption.AddressData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodCategoryFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodCategoryFragment1 extends Fragment {

    View mView;
    FrameLayout fragment1;
    public static ListView mLvFoodListListView1_1; //주소 검색 결과 담을 리스트뷰
    public static ListView mLvFoodListListView1_2;
    public static ListView mLvFoodListListView1_3;
    public static ArrayList<FoodCategoryListViewData> fragment1_1FoodDataArrayList = new ArrayList<>();
    public static ArrayList<FoodCategoryListViewData> fragment1_2FoodDataArrayList = new ArrayList<>();
    public static ArrayList<FoodCategoryListViewData> fragment1_3FoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter1_1;
    public static FoodCategoryListViewAdapter foodListAdapter1_2;
    public static FoodCategoryListViewAdapter foodListAdapter1_3;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodCategoryFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodCategoryFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodCategoryFragment1 newInstance(String param1, String param2) {
        FoodCategoryFragment1 fragment = new FoodCategoryFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_food_category1, container, false);
        fragment1 = mView.findViewById(R.id.foodcategory_fragment1);

        mLvFoodListListView1_1 = mView.findViewById(R.id.foodcategory_fragment1_listview_ourtownplus);
        mLvFoodListListView1_2 = mView.findViewById(R.id.foodcategory_fragment1_listview_superredweek);
        mLvFoodListListView1_3 = mView.findViewById(R.id.foodcategory_fragment1_listview_yogiyogeneral);

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(ApplicationClass.INPUT_ADDRESS){
            fragment1.setVisibility(View.VISIBLE);
        }
    }

    public static void FoodFragment1(){
        fragment1_1FoodDataArrayList.clear();
        fragment1_2FoodDataArrayList.clear();
        fragment1_3FoodDataArrayList.clear();

        for(int i = 0; i < FoodCategoryMainActivity.allFoodDataArrayList.size(); i++){
            if(FoodCategoryMainActivity.allFoodDataArrayList.get(i).KindOfStore == "plusStore"){
                fragment1_1FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
            }
            if(FoodCategoryMainActivity.allFoodDataArrayList.get(i).KindOfStore == "redWeekStore"){
                fragment1_2FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
            }
            fragment1_3FoodDataArrayList.add(FoodCategoryMainActivity.allFoodDataArrayList.get(i));
            System.out.println(FoodCategoryMainActivity.allFoodDataArrayList.get(i).KindOfStore);
        }

        foodListAdapter1_1 = new FoodCategoryListViewAdapter(fragment1_1FoodDataArrayList);
        mLvFoodListListView1_1.setAdapter(foodListAdapter1_1);
        foodListAdapter1_1.notifyDataSetChanged();

        foodListAdapter1_2 = new FoodCategoryListViewAdapter(fragment1_2FoodDataArrayList);
        mLvFoodListListView1_2.setAdapter(foodListAdapter1_2);
        foodListAdapter1_2.notifyDataSetChanged();

        foodListAdapter1_3 = new FoodCategoryListViewAdapter(fragment1_3FoodDataArrayList);
        mLvFoodListListView1_3.setAdapter(foodListAdapter1_3);
        foodListAdapter1_3.notifyDataSetChanged();

    }


}