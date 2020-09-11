package com.example.yogiyo_project.src.selectedStore;

import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreActivityView;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreRetrofitInterface;
import com.example.yogiyo_project.src.selectedStore.models.BestMenuResponse;
import com.example.yogiyo_project.src.selectedStore.models.EachCategoryMenuResponse;
import com.example.yogiyo_project.src.selectedStore.models.MenuCategoryResponse;
import com.example.yogiyo_project.src.selectedStore.models.SelectStoreResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit4;

public class SelectedStoreMainService {
    private final SelectStoreActivityView mSelectStoreActivityView;

    public SelectedStoreMainService(SelectStoreActivityView selectStoreActivityView) {
        this.mSelectStoreActivityView = selectStoreActivityView;
    }

    void getSelectedStore() {  //서버통신부분
        System.out.println("통신 시작");
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getSelectStore(ApplicationClass.STORE_IDX).enqueue(new Callback<SelectStoreResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<SelectStoreResponse> call, Response<SelectStoreResponse> response) {
                System.out.println("통신 성공");
                System.out.println(ApplicationClass.STORE_IDX);
                final SelectStoreResponse selectStoreResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (selectStoreResponse == null) {
                    System.out.println("signInResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                //가게 선택 시 가게 정보 가져오는 부분
                ApplicationClass.STORE_NAME = selectStoreResponse.selectedStoreInfo.get(0).storeName;
                ApplicationClass.STORE_IDX = selectStoreResponse.selectedStoreInfo.get(0).storeIdx;
                ApplicationClass.STORE_ISDISCOUNT = selectStoreResponse.selectedStoreInfo.get(0).isDiscount;
                ApplicationClass.STORE_DELIVERY_TIME = selectStoreResponse.selectedStoreInfo.get(0).deliveryTime;
                ApplicationClass.STORE_minimumCharge = selectStoreResponse.selectedStoreInfo.get(0).minimumCharge;
                ApplicationClass.STORE_totalScore = selectStoreResponse.selectedStoreInfo.get(0).totalScore;
                ApplicationClass.STORE_wishCnt = selectStoreResponse.selectedStoreInfo.get(0).wishCnt;
                ApplicationClass.STORE_menuCnt = selectStoreResponse.selectedStoreInfo.get(0).menuCnt;
                ApplicationClass.STORE_reviewCnt= selectStoreResponse.selectedStoreInfo.get(0).reviewCnt;
                ApplicationClass.STORE_isWished = selectStoreResponse.selectedStoreInfo.get(0).isWished;
                ApplicationClass.STORE_deliverycharge = selectStoreResponse.selectedStoreInfo.get(0).deliveryCharge;

                mSelectStoreActivityView.SelectStoreSuccess(selectStoreResponse.selectedStoreInfo.get(0).storeName); //성공시 수행

            }

            @Override
            public void onFailure(Call<SelectStoreResponse> call, Throwable t) {
                System.out.println("fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }

    void getBestMenu() {  //서버통신부분
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getBestMenu(ApplicationClass.STORE_IDX).enqueue(new Callback<BestMenuResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<BestMenuResponse> call, Response<BestMenuResponse> response) {
                final BestMenuResponse bestMenuResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (bestMenuResponse == null) {
                    System.out.println("signInResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                for(BestMenuResponse.BestMenuResult data : bestMenuResponse.bestMenuResult){
                    SelectedStoreRecyclerData item = new SelectedStoreRecyclerData();
                    SelectedStoreListviewData item2 = new SelectedStoreListviewData();

                    item.menuName = data.menuName;
                    item.menuPrice = String.valueOf(data.price);
                    item.menuIdx = data.menuIdx;

                    item2.menuName = data.menuName;
                    item2.menuPrice = String.valueOf(data.price);
                    item2.menuInfo = data.contents;
                    item2.menuIdx = data.menuIdx;

                    SelectedStoreMainActivity.mBestMenuRecyclerList.add(item);
                    SelectedStoreMainActivity.mBestMenuListViewList.add(item2);
                }

                mSelectStoreActivityView.BestMenuSuccess(bestMenuResponse.bestMenuResult.get(0).menuName); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<BestMenuResponse> call, Throwable t) {
                System.out.println("베스트메뉴 fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }

    void getMenuCategory() {  //서버통신부분
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getMenuCategory(ApplicationClass.STORE_IDX).enqueue(new Callback<MenuCategoryResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<MenuCategoryResponse> call, Response<MenuCategoryResponse> response) {
                final MenuCategoryResponse menuCategoryResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (menuCategoryResponse == null) {
                    System.out.println("menuCategoryResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                SelectedStoreMainActivity.Category1Name = menuCategoryResponse.menuCategoryResult.get(0).categoryName;
                SelectedStoreMainActivity.Category2Name = menuCategoryResponse.menuCategoryResult.get(1).categoryName;
                SelectedStoreMainActivity.Category3Name = menuCategoryResponse.menuCategoryResult.get(2).categoryName;

                ApplicationClass.menuCategoryIdx1 = menuCategoryResponse.menuCategoryResult.get(0).menuCategoryIdx;
                ApplicationClass.menuCategoryIdx2 = menuCategoryResponse.menuCategoryResult.get(1).menuCategoryIdx;
                ApplicationClass.menuCategoryIdx3 = menuCategoryResponse.menuCategoryResult.get(2).menuCategoryIdx;
                System.out.println("카테고리번호" +  ApplicationClass.menuCategoryIdx1);
                SelectedStoreFragmentMenu.mTvCategory1Name.setText(SelectedStoreMainActivity.Category1Name);
                SelectedStoreFragmentMenu.mTvCategory2Name.setText(SelectedStoreMainActivity.Category2Name);
                SelectedStoreFragmentMenu.mTvCategory3Name.setText(SelectedStoreMainActivity.Category3Name);
                mSelectStoreActivityView.MenuCategorySuccess("메뉴카테고리"); //MainActivity의 validateSuccess의 함수가 실행
            }

            @Override
            public void onFailure(Call<MenuCategoryResponse> call, Throwable t) {
                System.out.println("메뉴카테고리 가져오기 fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }

    void get1CategoryMenu() {  //카테고리1 메뉴들 정보 가져오는 것   나중에 2,3 같이 만들어주기
        SelectedStoreMainActivity.mCategory1List.clear();
        System.out.println("카테고리번호" +  ApplicationClass.menuCategoryIdx1);
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getEachCategoryMenu(ApplicationClass.STORE_IDX, 8).enqueue(new Callback<EachCategoryMenuResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<EachCategoryMenuResponse> call, Response<EachCategoryMenuResponse> response) {
                final EachCategoryMenuResponse eachCategoryMenuResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (eachCategoryMenuResponse == null) {
                    System.out.println("signInResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                for(EachCategoryMenuResponse.EachCategoryMenuResult data : eachCategoryMenuResponse.eachCategoryMenuResult) {
                    SelectedStoreListviewData item = new SelectedStoreListviewData();

                    item.menuIdx = data.menuIdx;
                    item.menuInfo = data.contents;
                    item.menuPrice = String.valueOf(data.price);
                    item.menuName = data.menuName;

                    SelectedStoreMainActivity.mCategory1List.add(item);
                }

                mSelectStoreActivityView.Category1Success("메뉴카테고리1 가져오기 성공");
            }

            @Override
            public void onFailure(Call<EachCategoryMenuResponse> call, Throwable t) {
                System.out.println("카테고리1 메뉴 가져오기 fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }

    void get2CategoryMenu() {  //카테고리1 메뉴들 정보 가져오는 것   나중에 2,3 같이 만들어주기
        SelectedStoreMainActivity.mCategory2List.clear();  //중복 피하기 위해
        System.out.println("카테고리번호" +  ApplicationClass.menuCategoryIdx2);
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getEachCategoryMenu(ApplicationClass.STORE_IDX, 9).enqueue(new Callback<EachCategoryMenuResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<EachCategoryMenuResponse> call, Response<EachCategoryMenuResponse> response) {
                final EachCategoryMenuResponse eachCategoryMenuResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (eachCategoryMenuResponse == null) {
                    System.out.println("signInResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                for(EachCategoryMenuResponse.EachCategoryMenuResult data : eachCategoryMenuResponse.eachCategoryMenuResult) {
                    SelectedStoreListviewData item = new SelectedStoreListviewData();

                    item.menuIdx = data.menuIdx;
                    item.menuInfo = data.contents;
                    item.menuPrice = String.valueOf(data.price);
                    item.menuName = data.menuName;

                    SelectedStoreMainActivity.mCategory2List.add(item);
                }

                mSelectStoreActivityView.Category2Success("메뉴카테고리2 가져오기 성공");
            }

            @Override
            public void onFailure(Call<EachCategoryMenuResponse> call, Throwable t) {
                System.out.println("카테고리2 메뉴 가져오기 fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }
    void get3CategoryMenu() {//카테고리1 메뉴들 정보 가져오는 것   나중에 2,3 같이 만들어주기
        SelectedStoreMainActivity.mCategory3List.clear();
        System.out.println("카테고리번호" +  ApplicationClass.menuCategoryIdx3);
        final SelectStoreRetrofitInterface mainRetrofitInterface = getRetrofit4().create(SelectStoreRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        mainRetrofitInterface.getEachCategoryMenu(ApplicationClass.STORE_IDX, 10).enqueue(new Callback<EachCategoryMenuResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<EachCategoryMenuResponse> call, Response<EachCategoryMenuResponse> response) {
                final EachCategoryMenuResponse eachCategoryMenuResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (eachCategoryMenuResponse == null) {
                    System.out.println("signInResponse = null");
                    mSelectStoreActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                for(EachCategoryMenuResponse.EachCategoryMenuResult data : eachCategoryMenuResponse.eachCategoryMenuResult) {
                    SelectedStoreListviewData item = new SelectedStoreListviewData();

                    item.menuIdx = data.menuIdx;
                    item.menuInfo = data.contents;
                    item.menuPrice = String.valueOf(data.price);
                    item.menuName = data.menuName;

                    SelectedStoreMainActivity.mCategory3List.add(item);
                }

                mSelectStoreActivityView.Category3Success("메뉴카테고리3 가져오기 성공");
            }

            @Override
            public void onFailure(Call<EachCategoryMenuResponse> call, Throwable t) {
                System.out.println("카테고리3 메뉴 가져오기 fail");
                mSelectStoreActivityView.validateFailure(null);
            }
        });
    }

}
