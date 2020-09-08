package com.example.yogiyo_project.src.selectedStore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.addressoption.AddressData;
import com.example.yogiyo_project.src.selectedmenu.SelectedMenuMainActivity;

import java.util.ArrayList;

public class SelectedStoreListViewAdapter extends BaseAdapter {

    ArrayList<SelectedStoreListviewData> mDataArrayList;

    public SelectedStoreListViewAdapter(ArrayList<SelectedStoreListviewData> dataArrayList){
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
        Context context = parent.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.selected_store_menu_listview_item, parent, false);
        }

        TextView tvMenuName = view.findViewById(R.id.selected_store_menu_listview_tv_menuname);
        TextView tvMenuInfo = view.findViewById(R.id.selected_store_menu_listview_tv_menuinfo);
        TextView tvMenuPrice = view.findViewById(R.id.selected_store_menu_listview_tv_menuprice);
        ImageView tvMenuImage = view.findViewById(R.id.selected_store_menu_listview_iv_menuimage);

        SelectedStoreListviewData data = mDataArrayList.get(position);

        tvMenuName.setText(data.menuName);
        tvMenuInfo.setText(data.menuInfo);
        tvMenuPrice.setText(data.menuPrice);
        tvMenuImage.setImageResource(data.menuImageDrawable);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationClass.MENU_NAME = data.menuName;
                ApplicationClass.MENU_INFO = data.menuInfo;
                ApplicationClass.MENU_PRICE = data.menuPrice;
                ApplicationClass.MENU_IAMGE = data.menuImageDrawable;

                Intent intent = new Intent(view.getContext(), SelectedMenuMainActivity.class);
                view.getContext().startActivity(intent);
            }
        });



        return view;
    }
}
