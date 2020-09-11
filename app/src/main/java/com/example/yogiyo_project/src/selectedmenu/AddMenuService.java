package com.example.yogiyo_project.src.selectedmenu;

import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.login.interfaces.LogInRetrofitInterface;
import com.example.yogiyo_project.src.login.models.LogInBody;
import com.example.yogiyo_project.src.login.models.LogInResponse;
import com.example.yogiyo_project.src.main.interfaces.MainRetrofitInterface;
import com.example.yogiyo_project.src.orderchart.OrderChartListViewData;
import com.example.yogiyo_project.src.selectedmenu.interfaces.AddMenuActivityView;
import com.example.yogiyo_project.src.selectedmenu.interfaces.AddMenuRetrofitInterfaces;
import com.example.yogiyo_project.src.selectedmenu.models.AddMenuBody;
import com.example.yogiyo_project.src.selectedmenu.models.AddMenuResponse;
import com.example.yogiyo_project.src.selectedmenu.models.CartInquireResponse;
import com.example.yogiyo_project.src.selectedmenu.models.MenuDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit2;

public class AddMenuService {
    private final AddMenuActivityView mAddMenuActivityView;

    public AddMenuService(AddMenuActivityView addMenuActivityView) {
        this.mAddMenuActivityView = addMenuActivityView;
    }

    void postAddMenu(int count, int storeIdx, int menuIdx) {  //서버통신부분
        final AddMenuRetrofitInterfaces addMenuRetrofitInterface = getRetrofit2().create(AddMenuRetrofitInterfaces.class);  // 이 부분은 위랑 같이 그대로
        addMenuRetrofitInterface.getAddMenu(new AddMenuBody(count), storeIdx, menuIdx).enqueue(new Callback<AddMenuResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<AddMenuResponse> call, Response<AddMenuResponse> response) {
                final AddMenuResponse addMenuResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (addMenuResponse == null) {
                    System.out.println("addMenuResponse = null");
                    mAddMenuActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mAddMenuActivityView.AddMenuSuccess(addMenuResponse.addMenuResultMessage); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<AddMenuResponse> call, Throwable t) {
                System.out.println("fail");
                mAddMenuActivityView.validateFailure(null);
            }
        });
    }

    void getCartInquire() {  //서버통신부분
        final AddMenuRetrofitInterfaces addMenuRetrofitInterface = getRetrofit2().create(AddMenuRetrofitInterfaces.class);  // 이 부분은 위랑 같이 그대로
        addMenuRetrofitInterface.getCartInquire().enqueue(new Callback<CartInquireResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<CartInquireResponse> call, Response<CartInquireResponse> response) {
                final CartInquireResponse cartInquireResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (cartInquireResponse == null) {
                    System.out.println("logInResponse = null");
                    mAddMenuActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                ApplicationClass.mOrderChartDataList.clear();
                for(CartInquireResponse.CartInquireResult data : cartInquireResponse.cartInquireResult){
                    OrderChartListViewData item = new OrderChartListViewData();

                    item.menuName = data.selectedMenuName;
                    item.menuPrice = String.valueOf(data.price);
                    item.menuCount = String.valueOf(data.count);
                    item.cartIdx = data.cartIdx;
                    item.cartMenuIdx = data.cartMenuIdx;

                    ApplicationClass.mOrderChartDataList.add(item); // 주문표 리스트에 메뉴 정보 추가
                }
                System.out.println("size"+ApplicationClass.mOrderChartDataList.size());
                mAddMenuActivityView.CartInquireSuccess(cartInquireResponse.cartInquireResult.get(0).storeName); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<CartInquireResponse> call, Throwable t) {
                System.out.println("fail");
                mAddMenuActivityView.validateFailure(null);
            }
        });
    }

    void getMenuDetail() {  //서버통신부분
        System.out.println(ApplicationClass.STORE_IDX +" "+ ApplicationClass.MENU_IDX);
        final AddMenuRetrofitInterfaces addMenuRetrofitInterface = getRetrofit2().create(AddMenuRetrofitInterfaces.class);  // 이 부분은 위랑 같이 그대로
        addMenuRetrofitInterface.getMenuDetail(ApplicationClass.STORE_IDX,ApplicationClass.MENU_IDX).enqueue(new Callback<MenuDetailResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<MenuDetailResponse> call, Response<MenuDetailResponse> response) {
                final MenuDetailResponse menuDetailResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (menuDetailResponse == null) {
                    System.out.println("signInResponse = null");
                    mAddMenuActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mAddMenuActivityView.MenuDetailSuccess(menuDetailResponse.menuDetailResult.get(0).get(0).selectedMenuName,
                        menuDetailResponse.menuDetailResult.get(0).get(0).contents,
                        menuDetailResponse.menuDetailResult.get(0).get(0).price); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<MenuDetailResponse> call, Throwable t) {
                System.out.println("detail menu fail");
                mAddMenuActivityView.validateFailure(null);
            }
        });
    }
}
