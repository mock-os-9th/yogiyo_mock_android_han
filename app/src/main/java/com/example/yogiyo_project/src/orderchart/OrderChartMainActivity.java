package com.example.yogiyo_project.src.orderchart;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreListViewAdapter;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreListviewData;

import java.util.ArrayList;

import static com.example.yogiyo_project.src.ApplicationClass.mOrderChartDataList;

public class OrderChartMainActivity extends BaseActivity {
    ListView mListView = null;
    OrderChartListViewAdapter mOrderChartAdapter = null;
    //public static ArrayList<OrderChartListViewData> mOrderChartDataList = new ArrayList<>();

    TextView mTvTotalPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_chart);

        mTvTotalPrice = findViewById(R.id.activity_orderchart_tv_totalprice);

        mListView = findViewById(R.id.activity_orderchart_listview);
        mOrderChartAdapter = new OrderChartListViewAdapter(mOrderChartDataList);
        mListView.setAdapter(mOrderChartAdapter);
        mOrderChartAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        int totalprice = 0;
        for(int i = 0; i < mOrderChartDataList.size(); i++){
            totalprice += Integer.parseInt(mOrderChartDataList.get(i).menuPrice) *  Integer.parseInt(mOrderChartDataList.get(i).menuCount);
        }
        mTvTotalPrice.setText(String.valueOf(totalprice));
    }
}
