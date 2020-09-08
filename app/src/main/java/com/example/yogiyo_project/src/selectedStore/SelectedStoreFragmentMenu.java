package com.example.yogiyo_project.src.selectedStore;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.main.MainActivity;

import java.util.ArrayList;

public class SelectedStoreFragmentMenu extends Fragment {
    View mView;
    RecyclerView mRecyclerView = null;
    SelectedStoreRecyclerAdpater mSelectedRecyclerAdapter = null;
    ArrayList<SelectedStoreRecyclerData> mList = new ArrayList<>();

    ListView mListView = null;
    SelectedStoreListViewAdapter mSelectedListAdapter = null;
    ArrayList<SelectedStoreListviewData> mListViewList = new ArrayList<>();

    LinearLayout mLlPopMenu;
    ImageView mIvMenuOpenClose;
    boolean popularmenu = true;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_selected_store_menu, container, false);
        System.out.println("SelectedStore Fragment Menu onCreateView");

        ((SelectedStoreMainActivity)getActivity()).refresh();

        mIvMenuOpenClose = mView.findViewById(R.id.selected_store_iv_listview_popular_openclose);

        mRecyclerView = mView.findViewById(R.id.selected_store_recyclerview);
        mSelectedRecyclerAdapter = new SelectedStoreRecyclerAdpater(mList);
        mRecyclerView.setAdapter(mSelectedRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());  //수평 리사이클러뷰 방법
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new SelectedRecyclerDecoration());

        addItem("든든 치킨 카레", "8000");
        addItem("제육 튀김 만두", "5000");
        addItem("쫄깃 냉우동", "7000");
        addItem("가락 떡볶이", "7500");
        addItem("바른 등심 돈가스", "8500");
        mSelectedRecyclerAdapter.notifyDataSetChanged();


        //선택한 가게의 메뉴 카테고리 선택 시 리스트 뷰
        mListView = mView.findViewById(R.id.selected_store_listview_popular);
        mSelectedListAdapter = new SelectedStoreListViewAdapter(mListViewList);
        mListView.setAdapter(mSelectedListAdapter);

        addItemListView(R.drawable.selected_store_popmenu1, "바른 김밥",
                "두번 구운 남해 청정지역 김에 신선한 재료를 가득 담은 김밥", "4000");
        addItemListView(R.drawable.selected_store_popmenu2, "가락 떡볶이",
                "쫄깃한 가락떡으로 매콤하게 만들어 김밥과 곁들여 먹기 더 없이 좋은 떡볶이", "7500");
        addItemListView(R.drawable.selected_store_popmenu3, "철판 제육 덮밥",
                "매콤한 제육볶음에 숯불향으로 맛을 더한 덮밥", "4000");
        addItemListView(R.drawable.selected_store_popmenu4, "쫄깃 냉우동",
                "쫄깃한 식감의 우동면과, 깔끔한 육수가 조화된 우동", "4000");
        addItemListView(R.drawable.selected_store_popmenu5, "바른 등심 돈가스",
                "무항생제 우리 돼지로 제대로 만든 돈가스", "8500");
        mSelectedListAdapter.notifyDataSetChanged();

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


        return mView;
    }

    public void addItem(String menuName, String menuPrice){
            SelectedStoreRecyclerData item = new SelectedStoreRecyclerData();

            item.menuName = menuName;
            item.menuPrice = menuPrice;

            mList.add(item);
    }

    public void addItemListView(int menuImage, String menuName,  String menuInfo, String menuPrice){
        SelectedStoreListviewData item = new SelectedStoreListviewData();

        item.menuImageDrawable = menuImage;
        item.menuName = menuName;
        item.menuInfo = menuInfo;
        item.menuPrice = menuPrice;

        mListViewList.add(item);
    }
}
