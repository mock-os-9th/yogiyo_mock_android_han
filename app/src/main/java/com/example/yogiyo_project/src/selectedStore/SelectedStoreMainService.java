package com.example.yogiyo_project.src.selectedStore;

import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.main.interfaces.MainRetrofitInterface;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreActivityView;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreRetrofitInterface;
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
}
