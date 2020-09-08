package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;

import java.util.ArrayList;

public class SelectedStoreFragmentMenu extends Fragment {
    View mView;
    RecyclerView mRecyclerView = null;
    SelectedStoreRecyclerAdpater mSelectedRecyclerAdapter = null;
    ArrayList<SelectedStoreRecyclerData> mList = new ArrayList<>();

    ListView mListView = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_selected_store_menu, container, false);
        System.out.println("SelectedStore Fragment Menu onCreateView");

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

        return mView;
    }

    public void addItem(String menuName, String menuPrice){
            SelectedStoreRecyclerData item = new SelectedStoreRecyclerData();

            item.menuName = menuName;
            item.menuPrice = menuPrice;

            mList.add(item);
    }
}
