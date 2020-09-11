package com.example.yogiyo_project.src.main.orderList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.orderchart.OrderChartListViewData;
import com.example.yogiyo_project.src.selectedmenu.SelectedMenuMainActivity;

import java.util.ArrayList;

public class OrderListViewAdapter extends BaseAdapter {
    ArrayList<OrderListViewData> mDataArrayList;

    public OrderListViewAdapter(ArrayList<OrderListViewData> dataArrayList){
        this.mDataArrayList = dataArrayList;
    }

    @Override
    public int getCount() {
        return mDataArrayList.size();
    }

    @Override
    public Object getItem(int pos) {
        return mDataArrayList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        Context context = parent.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_complete_order_listview, parent, false);
        }

        TextView storeName = view.findViewById(R.id.order_storename);
        TextView orderMenu = view.findViewById(R.id.order_menu);
        TextView orderDate = view.findViewById(R.id.order_date);

        OrderListViewData data = mDataArrayList.get(pos);

        storeName.setText(data.storeName);
        orderDate.setText(data.orderDate);
        orderMenu.setText(ApplicationClass.mOrderChartDataList.get(0).menuName);


        return view;
    }
}
