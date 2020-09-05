package com.example.yogiyo_project.src.addressoption;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.addressdetailinfo.AddressDetailInfoMainActivity;

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
        tvChooseAddress.setText(data.addressChooseTv);

        tvChooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"pos "+ position, Toast.LENGTH_SHORT).show();

                ApplicationClass.MAIN_ADDRESS_NAME = data.mainAddressName;  //선택한 주소 정보들 담기
                ApplicationClass.ROAD_ADDRESS_NAME = data.roadAddressName;
                ApplicationClass.LATITUDE = data.latitude;
                ApplicationClass.LONGITUDE = data.longitude;
                ApplicationClass.DONG_NAME = data.dongName;
                ApplicationClass.MAIN_ADDRESS_NO = data.mainAddressNo;

                Intent intent = new Intent(context, AddressDetailInfoMainActivity.class);
                context.startActivity(intent);
            }
        });



        return view;
    }


}
