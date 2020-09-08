package com.example.yogiyo_project.src.FoodCategory;

import com.example.yogiyo_project.src.FoodCategory.interfaces.FoodCategoryActivityView;
import com.example.yogiyo_project.src.FoodCategory.interfaces.FoodCategoryRetrofitInterface;
import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Body;
import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Response;
import com.example.yogiyo_project.src.addressoption.AddressData;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.example.yogiyo_project.src.addressoption.interfaces.AddressMainRetrofitInterface;
import com.example.yogiyo_project.src.addressoption.models.AddressResponse;
import com.example.yogiyo_project.src.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit;
import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit3;

class FoodCategoryMainService {
    private final FoodCategoryActivityView mFoodCategoryActivityView;

    FoodCategoryMainService(final FoodCategoryActivityView foodCategoryActivityView){
        this.mFoodCategoryActivityView = foodCategoryActivityView;
    }

    void getFoodList(double latitude, double longitude) {  //서버통신부분
        final FoodCategoryRetrofitInterface foodCategoryRetrofitInterface = getRetrofit3().create(FoodCategoryRetrofitInterface.class);
        foodCategoryRetrofitInterface.getAllStoreList(latitude, longitude).enqueue(new Callback<FoodCategory1Response>() {  //비동기 호출
            @Override
            public void onResponse(Call<FoodCategory1Response> call, Response<FoodCategory1Response> response) {
                final FoodCategory1Response foodCategory1Response = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (foodCategory1Response == null) {
                    System.out.println("reponse null");
                    mFoodCategoryActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                for(FoodCategory1Response.ResultAll data : foodCategory1Response.resultAll){
                    FoodCategoryListViewData item = new FoodCategoryListViewData();

                    item.storeName = data.storeName;
                    item.star = data.star;
                    item.reviews = data.reviews;
                    item.masterComments = data.masterComments;
                    item.signaturemenu = data.signaturemenu;
                    item.deliveryTime = data.deliveryTime;
                    item.cesco = data.cesco;

                    FoodCategoryMainActivity.allFoodDataArrayList.add(item);
                }
                FoodCategoryMainActivity.foodListAdapter.notifyDataSetChanged();
                System.out.println(FoodCategoryMainActivity.allFoodDataArrayList.size());
               // mFoodCategoryActivityView.getStoreListSuccess("가게 탐색에 성공했습니다");
                FoodCategoryFragment1.FoodFragment1();
                FoodCategoryFragment2.FoodFragment2();                              //MainActivity의 validateSuccess의 함수가 실행
            }

            @Override
            public void onFailure(Call<FoodCategory1Response> call, Throwable t) {
                mFoodCategoryActivityView.validateFailure(null);
            }
        });
    }
}
