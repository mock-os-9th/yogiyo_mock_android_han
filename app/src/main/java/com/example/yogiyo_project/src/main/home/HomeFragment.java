package com.example.yogiyo_project.src.main.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.main.MainActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View mView;
    ViewFlipper mViewFlipper;
    int images[] = {R.drawable.fragmenthome_ad1,
                    R.drawable.fragmenthome_ad2,
                    R.drawable.fragmenthome_ad3};

    RecyclerView mRecyclerViewCategoryTop = null;
    CategoryTopRecyclerAdapter mAdapterCategoryTop = null;
    ArrayList<CategoryTopRecyclerData> mListCategoryTop = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_home, container, false);
        //광고 넘기기
        mViewFlipper = mView.findViewById(R.id.fragment_home_viewflipper_advertise);
        for(int image : images){
            fllipperImages(image);
        }

        //상단 카테고리 recyclerview
        mRecyclerViewCategoryTop = mView.findViewById(R.id.fragment_home_recyclerview_category_top);
        mAdapterCategoryTop = new CategoryTopRecyclerAdapter(mListCategoryTop);
        mRecyclerViewCategoryTop.setAdapter(mAdapterCategoryTop);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mAdapterCategoryTop.notifyDataSetChanged();


        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addItemCategoryTop(ContextCompat.getDrawable(getContext(), R.drawable.fragmenthome_menu_category1), "전체보기");
        addItemCategoryTop(ContextCompat.getDrawable(getContext(), R.drawable.fragmenthome_menu_category2), "1인분주문");
        addItemCategoryTop(ContextCompat.getDrawable(getContext(), R.drawable.fragmenthome_menu_category3), "요기요플러스");
        mAdapterCategoryTop.notifyDataSetChanged();

    }

    //상단 광고 넘기는 method
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(image);

        mViewFlipper.addView(imageView);      // 이미지 추가
        mViewFlipper.setFlipInterval(3500);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        mViewFlipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        mViewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        mViewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }

    //상단 카테고리 리사이클러뷰 아이템 추가
    public void addItemCategoryTop(Drawable drawableMenu, String stringMenu){
        CategoryTopRecyclerData item = new CategoryTopRecyclerData();

        item.setmDrawableMenu(drawableMenu);
        item.setmStringMenu(stringMenu);

        mListCategoryTop.add(item);
    }

}
