package com.example.yogiyo_project.src.orderchart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreListviewData;

import java.util.ArrayList;

public class OrderChartListViewAdapter extends BaseAdapter {

    ArrayList<OrderChartListViewData> mDataArrayList;

    public OrderChartListViewAdapter(ArrayList<OrderChartListViewData> dataArrayList){
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
            view = inflater.inflate(R.layout.item_orderchart_listview, parent, false);
        }

        TextView menuName = view.findViewById(R.id.item_orderchart_listview_tv_menuname);
        TextView menuPrice = view.findViewById(R.id.item_orderchart_listview_tv_menuprice);
        TextView menuCount = view.findViewById(R.id.activity_orderchart_tv_count_presentmenutotal);

        OrderChartListViewData data = mDataArrayList.get(position);

        int menuEachPrice = Integer.parseInt(data.menuPrice) * Integer.parseInt(data.menuCount);

        menuName.setText(data.menuName);
        menuPrice.setText(String.valueOf(menuEachPrice));
        menuCount.setText(data.menuCount);


        return view;
    }
}
