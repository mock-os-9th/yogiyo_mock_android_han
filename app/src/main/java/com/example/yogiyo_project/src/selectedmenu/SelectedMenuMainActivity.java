package com.example.yogiyo_project.src.selectedmenu;

import android.media.AsyncPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.orderchart.OrderChartListViewData;
import com.example.yogiyo_project.src.selectedmenu.interfaces.AddMenuActivityView;

import java.util.ArrayList;

public class SelectedMenuMainActivity extends BaseActivity implements AddMenuActivityView {


    ImageView mIvMenuImage;
    TextView mTvMenuName;
    TextView mTvMenuInfo;
    TextView mTvMenuPrice;

    TextView mTvTotalCount;
    TextView mTvPlus;
    TextView mTvMinus;
    TextView mTvTotalPrice;
    TextView mTvMinimumCharge;

    TextView mTvAddOrderChart; //주문표에 추가

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_menu);

        mIvMenuImage = findViewById(R.id.selected_menu_iv_menuimage);
        mTvMenuName = findViewById(R.id.selected_menu_tv_menuname);
        mTvMenuInfo = findViewById(R.id.selected_menu_tv_menuinfo);
        mTvMenuPrice = findViewById(R.id.selected_menu_tv_menuprice);
        mTvMinimumCharge = findViewById(R.id.selected_menu_tv_minimumcharge);

        mIvMenuImage.setImageResource(R.drawable.chicken_cap);

        tryGetMenuDetail(); //상세정보 가져오는 api
        /*mTvMenuName.setText(ApplicationClass.MENU_NAME);
        mTvMenuInfo.setText(ApplicationClass.MENU_INFO);
        mTvMenuPrice.setText(ApplicationClass.MENU_PRICE);*/
        mTvMinimumCharge.setText("(최소주문금액 "+ ApplicationClass.STORE_minimumCharge +")");  //가게 선택 시 저장했던 최소 주문 금액 값 가져오기

        mTvTotalCount = findViewById(R.id.selected_menu_tv_count_presentmenutotal);
        mTvPlus = findViewById(R.id.selected_menu_tv_plus);
        mTvMinus = findViewById(R.id.selected_menu_tv_minus);
        mTvTotalPrice = findViewById(R.id.selected_menu_tv_price_presentmenutotal);
        //mTvTotalPrice.setText(ApplicationClass.MENU_PRICE);

        mTvAddOrderChart = findViewById(R.id.selected_menu_tv_addorderchart);
        mTvAddOrderChart.setOnClickListener(new View.OnClickListener() {   //주문표 추가 누를 시 통신 시작!!!
            @Override
            public void onClick(View view) {
                showCustomToast("메뉴가 주문표에 추가되었습니다");

                tryPostAddMenu();

                OrderChartListViewData selectedItem = new OrderChartListViewData();  // 선택한 메뉴를 주문표에 추가하기 위함
               /* selectedItem.menuName = ApplicationClass.MENU_NAME;
                selectedItem.menuCount = mTvTotalCount.getText().toString();
                selectedItem.menuPrice = mTvMenuPrice.getText().toString();

                ApplicationClass.mOrderChartDataList.add(selectedItem); */

                ApplicationClass.PICK_MENU = true;   //주문표 이동할 수 있는 카트아이콘 표시
            }
        });


        mTvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int count = Integer.parseInt(mTvTotalCount.getText().toString());
                    count += 1;
                    mTvTotalCount.setText(String.valueOf(count));
                int menuPrice = Integer.parseInt(mTvMenuPrice.getText().toString());
                int totalPrice = menuPrice * count;
                mTvTotalPrice.setText(String.valueOf(totalPrice));
            }
        });
        mTvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(mTvTotalCount.getText().toString());
                if(count >= 2){
                    count -= 1;
                }
                mTvTotalCount.setText(String.valueOf(count));
                int menuPrice = Integer.parseInt(mTvMenuPrice.getText().toString());
                int totalPrice = menuPrice * count;
                mTvTotalPrice.setText(String.valueOf(totalPrice));
            }
        });

    }

    private void tryPostAddMenu() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것

        int menucount = Integer.parseInt(mTvTotalCount.getText().toString()); //선택 메뉴의 수량 가져오기

        final AddMenuService addMenuService = new AddMenuService(this);
        addMenuService.postAddMenu(menucount, ApplicationClass.STORE_IDX, ApplicationClass.MENU_IDX);
    }

    private void tryGetCartInquire() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것

        final AddMenuService addMenuService = new AddMenuService(this);
        addMenuService.getCartInquire();
    }

    private void tryGetMenuDetail() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것

        final AddMenuService addMenuService = new AddMenuService(this);
        addMenuService.getMenuDetail();
    }


    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
    }

    @Override
    public void AddMenuSuccess(String message) {
        hideProgressDialog();
        System.out.println("주문표 담기 성공");
        showCustomToast(message);

        tryGetCartInquire();  //주문표 담고  주문표 조회 통신하면서 주문표 리스트 업데이트 하기
    }

    @Override
    public void CartInquireSuccess(String message) {
        hideProgressDialog();
        System.out.println("주문표 조회 성공  음식점 이름 : " + message);
    }

    @Override
    public void MenuDetailSuccess(String menuName, String contents, int price) {
        hideProgressDialog();
        System.out.println("메뉴 상세정보 가져오기 성공 " + menuName);

        mTvMenuName.setText(menuName);
        mTvMenuInfo.setText(contents);
        mTvMenuPrice.setText(String.valueOf(price));
        mTvTotalPrice.setText(String.valueOf(price));
    }
}
