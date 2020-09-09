package com.example.yogiyo_project.src.FoodCategory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreMainActivity;

import java.util.ArrayList;

public class FoodCategoryListViewAdapter extends BaseAdapter {

    ArrayList<FoodCategoryListViewData> mDataArrayList;

    public FoodCategoryListViewAdapter(ArrayList<FoodCategoryListViewData> dataArrayList) {
        this.mDataArrayList = dataArrayList;
    }

    @Override
    public int getCount() {
        return mDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        int pos = position;
        Context context = parent.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_foodcategory_foodlistview, parent, false);
        }

        TextView storeName = view.findViewById(R.id.item_food_category_listview_tv_storename);
        TextView rating = view.findViewById(R.id.item_food_category_listview_tv_ratingscore);
        TextView reviewScore = view.findViewById(R.id.item_food_category_listview_tv_reviewcount);
        TextView ownerComment = view.findViewById(R.id.item_food_category_listview_tv_ownerreview);
        TextView signatureMenu = view.findViewById(R.id.item_food_category_listview_tv_signaturemenu);
        TextView deliveryTime = view.findViewById(R.id.item_food_category_listview_tv_ordertime);
        ImageView cescoLogo = view.findViewById(R.id.item_food_category_listview_iv_cesco);

        FoodCategoryListViewData data = mDataArrayList.get(position);

        storeName.setText(data.storeName);
        rating.setText(String.valueOf(data.star));
        reviewScore.setText(String.valueOf(data.reviews));
        ownerComment.setText(String.valueOf(data.masterComments));
        signatureMenu.setText(data.signaturemenu);
        deliveryTime.setText(data.deliveryTime);

        if (data.cesco == "Y") {
            cescoLogo.setVisibility(View.VISIBLE);  //세스코 로고
        }

        view.setOnClickListener(new View.OnClickListener() {  // 가게 리스트에서 클릭 시 해당 가게 정보 액티비티로 갈 수 있게하기
            @Override
            public void onClick(View view) {
                ApplicationClass.STORE_IDX = data.storeIdx;  //선택한 가게 번호를 넣어준다
                Toast.makeText(view.getContext(),"cesco: "+data.cesco+" "+ApplicationClass.STORE_IDX ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), SelectedStoreMainActivity.class);
                view.getContext().startActivity(intent);
            }
        });




        return view;
    }
}
