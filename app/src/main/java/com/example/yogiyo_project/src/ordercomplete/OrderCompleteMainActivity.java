package com.example.yogiyo_project.src.ordercomplete;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.orderchart.OrderChartService;
import com.example.yogiyo_project.src.ordercomplete.interfaces.OrderCompleteActivityView;

public class OrderCompleteMainActivity extends BaseActivity implements OrderCompleteActivityView {
    TextView mTvTotalCost;
    TextView mTvOrderComplete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mTvTotalCost = findViewById(R.id.total_cost);
        mTvTotalCost.setText(String.valueOf(ApplicationClass.TOTAL_COST)); // 총 가격 대입

        mTvOrderComplete = findViewById(R.id.activity_payment_tv_ordercomplete);
        mTvOrderComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryOrderComplete();
            }
        });
    }



    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        System.out.println("orderComplete fail");
    }

    @Override
    public void OrderCompleteSuccess(String message) {
        hideProgressDialog();
        System.out.println("orderComplete success  message:" + message);
        //tryOrderList();
    }

    @Override
    public void OrderListSuccess(String message) {
        hideProgressDialog();
        System.out.println("orderlist 성공" + message);

        ApplicationClass.IS_ORDER = true;

    }

    private void tryOrderComplete() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final OrderCompleteService orderCompleteService = new OrderCompleteService(this);
        orderCompleteService.postOrderComplete();
        showCustomToast("주문이 완료되었습니다!");
    }

    private void tryOrderList() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final OrderCompleteService orderCompleteService = new OrderCompleteService(this);
        orderCompleteService.getOrderList();
        showCustomToast("주문 내역이 저장되었습니다");
    }
}
