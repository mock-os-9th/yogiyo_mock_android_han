package com.example.yogiyo_project.src.main.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.example.yogiyo_project.src.main.MainActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View mView;
    ViewFlipper mViewFlipper;
    int images[] = {R.drawable.fragmenthome_ad1,
                    R.drawable.fragmenthome_ad2,
                    R.drawable.fragmenthome_ad3};

    TextView mTvAddress;

    //그림 메뉴 카테고리 위한 변수
    RecyclerView mRecyclerViewCategoryTop;
    CategoryTopRecyclerAdapter mAdapterCategoryTop;
    ArrayList<CategoryTopRecyclerData> mListCategoryTop = new ArrayList<>();

    //나의 입맛 저격!
    RecyclerView mRecyclerViewStore;
    StoreRecyclerAdapter mAdapterStore;
    ArrayList<StoreRecyclerData> mListStore = new ArrayList<>();

    //우리동네 찜 많은 음식점
    RecyclerView mRecyclerViewStore2;
    StoreRecyclerAdapter2 mAdapterStore2;
    ArrayList<StoreRecyclerData> mListStore2 = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_home, container, false);
        //광고 넘기기
        mViewFlipper = mView.findViewById(R.id.fragment_home_viewflipper_advertise);
        for(int image : images){
            fllipperImages(image);
        }

        //최상단 주소 텍스트 누를 시
        mTvAddress = mView.findViewById(R.id.fragment_home_tv_address);
        mTvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddressMainActivity.class);
                startActivity(intent);
            }
        });

        //상단 카테고리 recyclerview
        mRecyclerViewCategoryTop = mView.findViewById(R.id.fragment_home_recyclerview_category_top);
        mAdapterCategoryTop = new CategoryTopRecyclerAdapter(getActivity(), mListCategoryTop);
        mRecyclerViewCategoryTop.setHasFixedSize(true);
        mRecyclerViewCategoryTop.setAdapter(mAdapterCategoryTop);


        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //mRecyclerViewCategoryTop.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManagerCategoryTop = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        mRecyclerViewCategoryTop.setLayoutManager(gridLayoutManagerCategoryTop);

        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category1), "전체보기");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category2), "1인분주문");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category3), "요기요플러스");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category4), "치킨");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category5), "중국집");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category6), "피자/양식");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category7), "한식");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category8), "분식");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category9), "카페/디저트");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category10), "족발/보쌈");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category11), "일식/돈까스");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category12), "야식");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category13), "프랜차이즈");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category14), "편의점/마트");
        addItemCategoryTop(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragmenthome_menu_category15), "테이크아웃");
        mAdapterCategoryTop.notifyDataSetChanged();
        //상단 음식 그림 카테고리 리사이클러 끝


        //나의 입맛 저격! 리사이클러뷰  -  로그인 했을때만 나타남
        mRecyclerViewStore = mView.findViewById(R.id.fragment_home_recyclerview_mytaste);
        mAdapterStore = new StoreRecyclerAdapter(getActivity(), mListStore);
        mRecyclerViewStore.setAdapter(mAdapterStore);

        LinearLayoutManager linearLayoutManagerStore = new LinearLayoutManager(getContext());
        linearLayoutManagerStore.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewStore.setLayoutManager(linearLayoutManagerStore);

        addItemStoreMyTaste(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragment_home_mytaste1), "바르다김선생-분당정자신기사거리점",
                "4.1", "133","바른 김밥, 가락 떡볶이");
        addItemStoreMyTaste(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragment_home_mytaste1), "바르다김선생-분당정자신기사거리점",
                "4.1", "133","바른 김밥, 가락 떡볶이");
        addItemStoreMyTaste(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragment_home_mytaste1), "바르다김선생-분당정자신기사거리점",
                "4.1", "133","바른 김밥, 가락 떡볶이");
        addItemStoreMyTaste(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragment_home_mytaste1), "바르다김선생-분당정자신기사거리점",
                "4.1", "133","바른 김밥, 가락 떡볶이");
        mAdapterStore.notifyDataSetChanged();
        //나의 입맛 저격! 리사이클러뷰 - 끝

        //우리동네 찜 많은 음식점 리사이클러 뷰
        mRecyclerViewStore2 = mView.findViewById(R.id.fragment_home_recyclerview_favorite_lot);
        mAdapterStore2 = new StoreRecyclerAdapter2(getActivity(), mListStore2);
        mRecyclerViewStore2.setAdapter(mAdapterStore2);

        addItemStoreMyTaste(ContextCompat.getDrawable(mView.getContext(), R.drawable.fragment_home_mytaste1), "바르다김선생-분당정자신기사거리점",
                "4.1", "133","바른 김밥, 가락 떡볶이");
        mAdapterStore2.notifyDataSetChanged();



        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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
    //나의 입맛 저격! 리사이클러뷰 아이템 추가
    public void addItemStoreMyTaste(Drawable drawableStoreMyTaste, String storeNameMyTaste, String storeRatingMyTaste
            , String reviewCountMyTaste, String additionalInfoMyTaste){
        StoreRecyclerData item = new StoreRecyclerData();

        item.setmDrawableStore(drawableStoreMyTaste);
        item.setmStringStoreName(storeNameMyTaste);
        item.setmStringStoreRating(storeRatingMyTaste);
        item.setmStringReviewCount(reviewCountMyTaste);
        item.setmStringAdditionalInfo(additionalInfoMyTaste);

        mListStore.add(item);

    }

}
