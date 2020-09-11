package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;

import org.w3c.dom.Text;

public class SelectedStoreFragmentMenu extends Fragment {
    View mView;
    RecyclerView mRecyclerView = null;



    ListView mListView = null;
    ListView mListViewCategory1 = null;
    ListView mListViewCategory2 = null;
    ListView mListViewCategory3 = null;


    LinearLayout mLlPopMenu;
    ImageView mIvMenuOpenClose;
    boolean popularmenu = true;

    boolean category1 = false;
    boolean category2 = false;
    boolean category3 = false;

    ImageView mIvCategory1OpenClose;
    ImageView mIvCategory2OpenClose;
    ImageView mIvCategory3OpenClose;

    LinearLayout mLlCategory1;
    LinearLayout mLlCategory2;
    LinearLayout mLlCategory3;

    public static TextView mTvCategory1Name;
    public static TextView mTvCategory2Name;
    public static TextView mTvCategory3Name;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_selected_store_menu, container, false);
        System.out.println("SelectedStore Fragment Menu onCreateView");

        mTvCategory1Name = mView.findViewById(R.id.selected_store_tv_menucategory1);
        mTvCategory1Name.setText(SelectedStoreMainActivity.Category1Name);   // 데이터 다 들어오면 카테고리 조회해서 상위 3개 뽑아서 넣어주기
       mTvCategory2Name = mView.findViewById(R.id.selected_store_tv_menucategory2);
        mTvCategory2Name.setText(SelectedStoreMainActivity.Category2Name);
        mTvCategory3Name = mView.findViewById(R.id.selected_store_tv_menucategory3);
        mTvCategory3Name.setText(SelectedStoreMainActivity.Category3Name);


        mIvMenuOpenClose = mView.findViewById(R.id.selected_store_iv_listview_popular_openclose);
        mIvCategory1OpenClose = mView.findViewById(R.id.selected_store_iv_listview_menucategory1_close);
        mIvCategory2OpenClose = mView.findViewById(R.id.selected_store_iv_listview_menucategory2_close);
        mIvCategory3OpenClose = mView.findViewById(R.id.selected_store_iv_listview_menucategory3_close);

        mRecyclerView = mView.findViewById(R.id.selected_store_recyclerview);
        mRecyclerView.setAdapter(SelectedStoreMainActivity.mSelectedRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());  //수평 리사이클러뷰 방법
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new SelectedRecyclerDecoration());

        /*addItem("든든 치킨 카레", "8000");
        addItem("제육 튀김 만두", "5000");
        addItem("쫄깃 냉우동", "7000");
        addItem("가락 떡볶이", "7500");
        addItem("바른 등심 돈가스", "8500"); */
        SelectedStoreMainActivity.mSelectedRecyclerAdapter.notifyDataSetChanged();


        //선택한 가게의 메뉴 카테고리 선택 시 리스트 뷰
        mListView = mView.findViewById(R.id.selected_store_listview_popular);
        mListView.setAdapter(SelectedStoreMainActivity.mSelectedListAdapter);

        mListViewCategory1 = mView.findViewById(R.id.selected_store_listview_menucategory1);
        mListViewCategory2 = mView.findViewById(R.id.selected_store_listview_menucategory2);
        mListViewCategory3 = mView.findViewById(R.id.selected_store_listview_menucategory3);

        mListViewCategory1.setAdapter(SelectedStoreMainActivity.mCategory1Adapter);
        mListViewCategory2.setAdapter(SelectedStoreMainActivity.mCategory2Adapter);
        mListViewCategory3.setAdapter(SelectedStoreMainActivity.mCategory3Adapter);


       /* addItemListView(R.drawable.selected_store_popmenu1, "바른 김밥",
                "두번 구운 남해 청정지역 김에 신선한 재료를 가득 담은 김밥", "4000");
        addItemListView(R.drawable.selected_store_popmenu2, "가락 떡볶이",
                "쫄깃한 가락떡으로 매콤하게 만들어 김밥과 곁들여 먹기 더 없이 좋은 떡볶이", "7500");
        addItemListView(R.drawable.selected_store_popmenu3, "철판 제육 덮밥",
                "매콤한 제육볶음에 숯불향으로 맛을 더한 덮밥", "4000");
        addItemListView(R.drawable.selected_store_popmenu4, "쫄깃 냉우동",
                "쫄깃한 식감의 우동면과, 깔끔한 육수가 조화된 우동", "4000");
        addItemListView(R.drawable.selected_store_popmenu5, "바른 등심 돈가스",
                "무항생제 우리 돼지로 제대로 만든 돈가스", "8500"); */
        SelectedStoreMainActivity.mSelectedListAdapter.notifyDataSetChanged();

        mLlCategory1 = mView.findViewById(R.id.selected_store_linearlayout_menucategory1);
        mLlCategory2 = mView.findViewById(R.id.selected_store_linearlayout_menucategory2);
        mLlCategory3 = mView.findViewById(R.id.selected_store_linearlayout_menucategory3);


        mLlPopMenu = mView.findViewById(R.id.selected_store_linearlayout_popular);
        mLlPopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popularmenu = !popularmenu;
                if(popularmenu){
                    mListView.setVisibility(View.VISIBLE);
                    mIvMenuOpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_close);
                }
                if(!popularmenu){
                mListView.setVisibility(View.GONE);
                mIvMenuOpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_open);
                }
            }
        });

        mLlCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category1 = !category1;
                if(category1){
                    mListViewCategory1.setVisibility(View.VISIBLE);
                    mIvCategory1OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_close);
                }
                if(!category1){
                    mListViewCategory1.setVisibility(View.GONE);
                    mIvCategory1OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_open);
                }

            }
        });

        mLlCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category2 = !category2;
                if(category2){
                    mListViewCategory2.setVisibility(View.VISIBLE);
                    mIvCategory2OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_close);
                }
                if(!category2){
                    mListViewCategory2.setVisibility(View.GONE);
                    mIvCategory2OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_open);
                }

            }
        });

        mLlCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category3 = !category3;
                if(category3){
                    mListViewCategory3.setVisibility(View.VISIBLE);
                    mIvCategory3OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_close);
                }
                if(!category3){
                    mListViewCategory3.setVisibility(View.GONE);
                    mIvCategory3OpenClose.setImageResource(R.drawable.ic_baseline_selected_store_menu_listview_open);
                }
            }
        });


        return mView;
    }

    public void addItem(String menuName, String menuPrice){  //인기메뉴 리사이클러 뷰 아이템 추가 함수수
           SelectedStoreRecyclerData item = new SelectedStoreRecyclerData();

            item.menuName = menuName;
            item.menuPrice = menuPrice;

        SelectedStoreMainActivity.mBestMenuRecyclerList.add(item);
    }

    public void addItemListView(int menuImage, String menuName,  String menuInfo, String menuPrice){
        SelectedStoreListviewData item = new SelectedStoreListviewData();

        item.menuImageDrawable = menuImage;
        item.menuName = menuName;
        item.menuInfo = menuInfo;
        item.menuPrice = menuPrice;

        SelectedStoreMainActivity.mBestMenuListViewList.add(item);
    }


}
