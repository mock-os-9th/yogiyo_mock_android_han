package com.example.yogiyo_project.src.myinfopage;

import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryFragment1;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryFragment2;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryListViewData;
import com.example.yogiyo_project.src.FoodCategory.FoodCategoryMainActivity;
import com.example.yogiyo_project.src.FoodCategory.interfaces.FoodCategoryRetrofitInterface;
import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Response;
import com.example.yogiyo_project.src.myinfopage.inferfaces.MyInfoPageActivityView;
import com.example.yogiyo_project.src.myinfopage.inferfaces.MyInfoPageRetrofitInterface;
import com.example.yogiyo_project.src.myinfopage.models.MyInfoPageResponse;
import com.example.yogiyo_project.src.myinfopage.models.WithdrwalResponse;
import com.example.yogiyo_project.src.selectedStore.Interfaces.SelectStoreRetrofitInterface;
import com.example.yogiyo_project.src.selectedStore.models.SelectStoreResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit3;
import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit4;

public class MyInfoPageService {

    private final MyInfoPageActivityView mMyInfoPageActivityView;

    public MyInfoPageService(MyInfoPageActivityView myInfoPageActivityView) {
        this.mMyInfoPageActivityView = myInfoPageActivityView;
    }

    void getMyInfo() {  //서버통신부분
        final MyInfoPageRetrofitInterface myInfoRetrofitInterface = getRetrofit4().create(MyInfoPageRetrofitInterface.class);
        myInfoRetrofitInterface.getMyInfo().enqueue(new Callback<MyInfoPageResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<MyInfoPageResponse> call, Response<MyInfoPageResponse> response) {
                final MyInfoPageResponse myInfoResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (myInfoResponse == null) {
                    System.out.println("reponse null");
                    mMyInfoPageActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }



                        mMyInfoPageActivityView.MyInfoSuccess(myInfoResponse.myInfoResult.get(0).userEmail,
                                myInfoResponse.myInfoResult.get(0).password,
                                myInfoResponse.myInfoResult.get(0).phoneNum,
                                myInfoResponse.myInfoResult.get(0).nickName); //MainActivity의 validateSuccess의 함수가 실행
            }

            @Override
            public void onFailure(Call<MyInfoPageResponse> call, Throwable t) {
                mMyInfoPageActivityView.validateFailure(null);
            }
        });
    }

    void getWithDrwal() {  //서버통신부분
        final MyInfoPageRetrofitInterface myInfoRetrofitInterface = getRetrofit4().create(MyInfoPageRetrofitInterface.class);
        myInfoRetrofitInterface.getWithDrwal().enqueue(new Callback<WithdrwalResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<WithdrwalResponse> call, Response<WithdrwalResponse> response) {
                final WithdrwalResponse withdrwalResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (withdrwalResponse == null) {
                    System.out.println("reponse null");
                    mMyInfoPageActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mMyInfoPageActivityView.WithdrwalSuccess(withdrwalResponse.withDrwalMessage);
            }

            @Override
            public void onFailure(Call<WithdrwalResponse> call, Throwable t) {
                mMyInfoPageActivityView.validateFailure(null);
            }
        });
    }

}
