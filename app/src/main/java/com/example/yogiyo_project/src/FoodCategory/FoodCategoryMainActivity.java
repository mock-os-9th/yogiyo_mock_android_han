package com.example.yogiyo_project.src.FoodCategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.FoodCategory.interfaces.FoodCategoryActivityView;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FoodCategoryMainActivity extends BaseActivity implements FoodCategoryActivityView{
    TextView mTvFoodCategoryAddress;
    ImageView mIvFoodCategoryBack;
    ViewPager mVp;
    FoodCategoryViewPagerAdapter mViewPagerAdapter;
    TabLayout mTl;
    TabLayout.Tab tab;

    ListView mLvFoodListListView; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<FoodCategoryListViewData> allFoodDataArrayList = new ArrayList<>();
    public static FoodCategoryListViewAdapter foodListAdapter = new FoodCategoryListViewAdapter(allFoodDataArrayList);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        System.out.println("FoodCategory onCreate");

        mLvFoodListListView = findViewById(R.id.all_food_list_listview);
        mLvFoodListListView.setAdapter(foodListAdapter);

        mTvFoodCategoryAddress = findViewById(R.id.fragment_food_category_tv_address); //상단 주소 텍스트 누를 시 주소 설정 액티비로 이동
        mTvFoodCategoryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodCategoryMainActivity.this, AddressMainActivity.class);
                startActivity(intent);
            }
        });
        mIvFoodCategoryBack = findViewById(R.id.fragment_food_category_iv_back);
        mIvFoodCategoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mVp = findViewById(R.id.activity_foodcategory_viewpager);
        mViewPagerAdapter = new FoodCategoryViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mViewPagerAdapter);

        mTl = findViewById(R.id.fragment_food_category_tablayout);
        mTl.setupWithViewPager(mVp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("FoodCategory onResume");
        if(ApplicationClass.INPUT_ADDRESS){   //주소 선택 시 상단에 주소 값 변경되게 하기
            mTvFoodCategoryAddress.setText(ApplicationClass.DONG_NAME+" "+ApplicationClass.MAIN_ADDRESS_NO);
        }
        tab = mTl.getTabAt(ApplicationClass.MENU_CATEGORY_NUM);
        tab.select();

        tryGetFoodList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();  //로그용
        System.out.println("FoodCategory onDestroy");
    }

    private void tryGetFoodList(){
        showProgressDialog();
        final FoodCategoryMainService foodCategoryMainService = new FoodCategoryMainService(this);
        foodCategoryMainService.getFoodList("37.2", "10.1");  //위,경도 값 보내줘야함

    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();  //통신이 끝나면 로딩 hide시켜준다
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void getStoreListSuccess(String message) {
        hideProgressDialog();
        showCustomToast(message);
    }
}
