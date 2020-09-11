package com.example.yogiyo_project.src.orderchart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.myinfopage.MyInfoPageService;
import com.example.yogiyo_project.src.orderchart.interfaces.OrderChartActivityView;
import com.example.yogiyo_project.src.ordercomplete.OrderCompleteMainActivity;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreListViewAdapter;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreListviewData;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreMainActivity;
import com.example.yogiyo_project.src.selectedmenu.SelectedMenuMainActivity;

import java.util.ArrayList;



public class OrderChartMainActivity extends BaseActivity implements OrderChartActivityView {
    ListView mListView = null;
    OrderChartListViewAdapter mOrderChartAdapter = null;
    //public static ArrayList<OrderChartListViewData> mOrderChartDataList = new ArrayList<>();

    TextView mTvTotalPrice;
    TextView mTvStoreName;
    TextView mTvDeliveryCharge;

    TextView mTvGoToOrderComplete;
    TextView mTvAddMoreMenu;

    ImageView mIvDeleteAllOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_chart_2);
        System.out.println("size"+ApplicationClass.mOrderChartDataList.size());

        mTvDeliveryCharge = findViewById(R.id.order_chart_2_deliverycharge);
        mIvDeleteAllOrder = findViewById(R.id.activity_orderchart_2_iv_trashcan);
        mIvDeleteAllOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIvDeleteAllOrder.setVisibility(View.INVISIBLE); //장바구니에 품목 0 이면 장바구니 들어올 수 있는 아이콘 사라짐
                tryDeleteOrder();
                mTvTotalPrice.setText("0원");
                mTvDeliveryCharge.setText("-");
                mTvStoreName.setText("-");
            }
        });
        mTvStoreName = findViewById(R.id.activity_orderchart_2_tv_storename);
        mTvTotalPrice = findViewById(R.id.order_chart_2_totalprice);
        mTvGoToOrderComplete = findViewById(R.id.activity_orderchart_2_tv_gotopay);
        mTvGoToOrderComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderChartMainActivity.this, OrderCompleteMainActivity.class);

                startActivity(intent);
            }
        });
        mTvAddMoreMenu = findViewById(R.id.activity_orderchart_tv_addmenu);
        mTvAddMoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderChartMainActivity.this, SelectedStoreMainActivity.class);
                startActivity(intent);
            }
        });

        mListView = findViewById(R.id.activity_orderchart_2_lv);
        mOrderChartAdapter = new OrderChartListViewAdapter(ApplicationClass.mOrderChartDataList);
        mListView.setAdapter(mOrderChartAdapter);


        mOrderChartAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(ApplicationClass.STORE_deliverycharge);
        String str = ApplicationClass.STORE_deliverycharge;
        System.out.println(str.substring(0,4));
        int deliveryCharge = Integer.parseInt(str.substring(0,4));
        mTvDeliveryCharge.setText(deliveryCharge+"원");
        int totalprice = 0;

        mTvStoreName.setText(ApplicationClass.STORE_NAME);
        for(int i = 0; i < ApplicationClass.mOrderChartDataList.size(); i++){
            totalprice += Integer.parseInt(ApplicationClass.mOrderChartDataList.get(i).menuPrice) *  Integer.parseInt(ApplicationClass.mOrderChartDataList.get(i).menuCount);
        }
        mTvTotalPrice.setText(String.valueOf(totalprice + deliveryCharge)+"원");
        ApplicationClass.TOTAL_COST = totalprice + deliveryCharge; //총 가격 저장

        System.out.println(ApplicationClass.mOrderChartDataList.get(0).menuName);
    }


    /*public void setListViewHeight(OrderChartListViewAdapter adpater, ListView listView) {
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int size = 0; size < listView.getCount(); size++) {
            View listItem = adpater.getView(size, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listView.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }*/

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        System.out.println("장바구니 전체 지우기 실패");
    }

    @Override
    public void OrderChartDeleteSuccess(String message) {
        hideProgressDialog();
        System.out.println("선택된 메뉴가 없습니다");
        showCustomToast("선택된 메뉴가 없습니다");
        ApplicationClass.mOrderChartDataList.clear();
        mOrderChartAdapter.notifyDataSetChanged();
    }

    private void tryDeleteOrder() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final OrderChartService orderChartService = new OrderChartService(this);
        orderChartService.deleteOrderChart();
    }
}
