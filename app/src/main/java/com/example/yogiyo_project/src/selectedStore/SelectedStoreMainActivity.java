package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreActivityView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class SelectedStoreMainActivity extends BaseActivity implements SelectStoreActivityView {
    TabLayout mTl;
    ViewPager mVp;
    SelectedStoreViewPagerAdapter mVpAdapter;

    TextView mTvSelectedStoreName;
    TextView mTvScore;
    TextView mTvDeliveryTime;
    TextView mTvMinimumCharge;
    TextView mTvWishCnt;
    TextView mTvDeliveryCharge;

    public static ArrayList<SelectedStoreRecyclerData> mBestMenuRecyclerList = new ArrayList<>();
    public static SelectedStoreRecyclerAdpater mSelectedRecyclerAdapter = new SelectedStoreRecyclerAdpater(SelectedStoreMainActivity.mBestMenuRecyclerList);

    public static ArrayList<SelectedStoreListviewData> mBestMenuListViewList = new ArrayList<>();  //인기메뉴 받기 위한 리스트
    public static SelectedStoreListViewAdapter mSelectedListAdapter = new SelectedStoreListViewAdapter(mBestMenuListViewList);

    public static ArrayList<SelectedStoreListviewData> mCategory1List = new ArrayList<>(); //메뉴카테고리1 받기 위한 리스트
    public static SelectedStoreListViewAdapter mCategory1Adapter = new SelectedStoreListViewAdapter(mCategory1List);

    public static ArrayList<SelectedStoreListviewData> mCategory2List = new ArrayList<>();
    public static SelectedStoreListViewAdapter mCategory2Adapter = new SelectedStoreListViewAdapter(mCategory2List);

    public static ArrayList<SelectedStoreListviewData> mCategory3List = new ArrayList<>();
    public static SelectedStoreListViewAdapter mCategory3Adapter = new SelectedStoreListViewAdapter(mCategory3List);

    public static String Category1Name = null; //카테고리 1,2,3 이름에 넣을 String
    public static String Category2Name = null;
    public static String Category3Name = null;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_store_info);

        mBestMenuRecyclerList.clear();  //다시 들어갈때는 초기화 해주기
        mBestMenuListViewList.clear();
        mCategory1List.clear();

        System.out.println("SelectStore onCreate");


        mVp = findViewById(R.id.selected_stroe_viewpager);
        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mVpAdapter);
        mTl = findViewById(R.id.selected_stroe_tablayout);
        mTl.setupWithViewPager(mVp);

        mTvSelectedStoreName = findViewById(R.id.selected_store_tv_storename);
        mTvDeliveryTime = findViewById(R.id.selected_store_tv_deliverytime);
        mTvScore  = findViewById(R.id.selected_store_tv_rating);
        mTvMinimumCharge = findViewById(R.id.selected_stroe_tv_min_cost);
        mTvWishCnt = findViewById(R.id.selected_store_tv_like_count);
        mTvDeliveryCharge = findViewById(R.id.selected_stroe_tv_delivery_cost);

       /* mTvSelectedStoreName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("통신시작버튼눌림");
                tryGetSelectStore();
            }
        }); */
        tryGetSelectStore();  // 가게 정보 가져오기 통신 시작

        tryGetMenuCategory(); // 메뉴 카테고리 조회

        tryGetBestMenu();  // 해당가게의 인기 메뉴 가져오기


        tryGet1CategoryMenu();
        tryGet2CategoryMenu();
        tryGet3CategoryMenu();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void validateFailure(String message) {
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void SelectStoreSuccess(String message) {
            hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
            System.out.println("가게선택성공  "+ message);

            mTvSelectedStoreName.setText(ApplicationClass.STORE_NAME);
        mTvDeliveryTime.setText(ApplicationClass.STORE_DELIVERY_TIME);
        mTvScore.setText(String.valueOf(ApplicationClass.STORE_totalScore));
        mTvMinimumCharge.setText(ApplicationClass.STORE_minimumCharge);
        mTvWishCnt.setText(String.valueOf(ApplicationClass.STORE_wishCnt));
        mTvDeliveryCharge.setText(ApplicationClass.STORE_deliverycharge);

        ApplicationClass.REVIEW_COUNT = ApplicationClass.STORE_reviewCnt;
        ApplicationClass.MENU_COUNT = ApplicationClass.STORE_menuCnt;

        mVpAdapter = new SelectedStoreViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mVpAdapter);
        mTl.setupWithViewPager(mVp);

        mVpAdapter.notifyDataSetChanged();

    }

    @Override
    public void BestMenuSuccess(String message) {
        hideProgressDialog();
        System.out.println("인기 메뉴 가져오기 성공" + message);
        mSelectedRecyclerAdapter.notifyDataSetChanged();
        mSelectedListAdapter.notifyDataSetChanged();

    }

    @Override
    public void MenuCategorySuccess(String message) {
        hideProgressDialog();
        System.out.println("메뉴 카테고리 가져오기 성공");
    }

    @Override
    public void Category1Success(String message) {   //메뉴 카테고리중 첫 번째 카테고리
        hideProgressDialog();
        System.out.println("카테고리1 메뉴 가져오기 성공");
        mCategory1Adapter.notifyDataSetChanged();

    }

    @Override
    public void Category2Success(String message) {
        hideProgressDialog();
        System.out.println("카테고리2 메뉴 가져오기 성공");
        mCategory2Adapter.notifyDataSetChanged();
    }

    @Override
    public void Category3Success(String message) {
        hideProgressDialog();
        System.out.println("카테고리3 메뉴 가져오기 성공");
        mCategory3Adapter.notifyDataSetChanged();
    }


    private void tryGetSelectStore() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.getSelectedStore();
    }

    private void tryGetBestMenu() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.getBestMenu();
    }

    private void tryGetMenuCategory() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.getMenuCategory();
    }

    private void tryGet1CategoryMenu() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.get1CategoryMenu();
    }
    private void tryGet2CategoryMenu() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.get2CategoryMenu();
    }
    private void tryGet3CategoryMenu() {
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        System.out.println("로딩시작");
        final SelectedStoreMainService selectedStoreMainService = new SelectedStoreMainService(this);
        selectedStoreMainService.get3CategoryMenu();
    }
}
