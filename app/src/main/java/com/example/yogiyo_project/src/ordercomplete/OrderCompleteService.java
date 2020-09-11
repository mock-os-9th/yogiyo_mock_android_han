package com.example.yogiyo_project.src.ordercomplete;

import com.example.yogiyo_project.src.orderchart.interfaces.OrderChartRetrofitInterfaces;
import com.example.yogiyo_project.src.orderchart.models.OrderChartResponse;
import com.example.yogiyo_project.src.ordercomplete.interfaces.OrderCompleteActivityView;
import com.example.yogiyo_project.src.ordercomplete.interfaces.OrderCompleteRetrofitInterfaces;
import com.example.yogiyo_project.src.ordercomplete.models.OrderCompleteBody;
import com.example.yogiyo_project.src.ordercomplete.models.OrderCompleteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit4;

public class OrderCompleteService {
    private final OrderCompleteActivityView mOrderCompleteActivityView;

    public OrderCompleteService(OrderCompleteActivityView orderCompleteActivityView) {
        this.mOrderCompleteActivityView = orderCompleteActivityView;
    }

    void postOrderComplete() {  //서버통신부분
        final OrderCompleteRetrofitInterfaces orderCompleteRetrofitInterface = getRetrofit4().create(OrderCompleteRetrofitInterfaces.class);
        orderCompleteRetrofitInterface.postOrderComplete(new OrderCompleteBody("Y")).enqueue(new Callback<OrderCompleteResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<OrderCompleteResponse> call, Response<OrderCompleteResponse> response) {
                final OrderCompleteResponse orderCompleteResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (orderCompleteResponse == null) {
                    System.out.println("orderComplete null");
                    mOrderCompleteActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mOrderCompleteActivityView.OrderCompleteSuccess(orderCompleteResponse.orderCompleteMessage);
            }
            @Override
            public void onFailure(Call<OrderCompleteResponse> call, Throwable t) {
                mOrderCompleteActivityView.validateFailure(null);
            }
        });
    }
}
