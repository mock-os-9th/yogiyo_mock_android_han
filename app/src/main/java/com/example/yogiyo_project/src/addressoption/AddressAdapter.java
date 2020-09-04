package com.example.yogiyo_project.src.addressoption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yogiyo_project.R;

import java.util.ArrayList;

public class AddressAdapter extends BaseAdapter {

    ArrayList<AddressData> mDataArrayList;

    public AddressAdapter(ArrayList<AddressData> dataArrayList){
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
            view = inflater.inflate(R.layout.item_activity_address_listview, parent, false);
        }

        TextView tvMainAddressName = view.findViewById(R.id.tv_mainaddressname);
        TextView tvRoadAddressName = view.findViewById(R.id.tv_roadaddressname);
        TextView tvChooseAddress = view.findViewById(R.id.tv_choose_address);  //주소 선택 시 다음 이벤트 하기  

        AddressData data = mDataArrayList.get(position);

        tvMainAddressName.setText(data.mainAddressName);
        tvRoadAddressName.setText(data.roadAddressName);



        return view;
    }
}
