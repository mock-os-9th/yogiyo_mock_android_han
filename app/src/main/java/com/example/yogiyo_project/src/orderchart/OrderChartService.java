package com.example.yogiyo_project.src.orderchart;

import com.example.yogiyo_project.src.myinfopage.inferfaces.MyInfoPageRetrofitInterface;
import com.example.yogiyo_project.src.myinfopage.models.MyInfoPageResponse;
import com.example.yogiyo_project.src.orderchart.interfaces.OrderChartActivityView;
import com.example.yogiyo_project.src.orderchart.interfaces.OrderChartRetrofitInterfaces;
import com.example.yogiyo_project.src.orderchart.models.OrderChartResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit4;

public class OrderChartService {
    private final OrderChartActivityView mOrderChartActivityView;

    public OrderChartService(OrderChartActivityView orderChartActivityView) {
        this.mOrderChartActivityView = orderChartActivityView;
    }

    void deleteOrderChart() {  //서버통신부분
        final OrderChartRetrofitInterfaces orderChartRetrofitInterface = getRetrofit4().create(OrderChartRetrofitInterfaces.class);
        orderChartRetrofitInterface.deleteOrderChart().enqueue(new Callback<OrderChartResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<OrderChartResponse> call, Response<OrderChartResponse> response) {
                final OrderChartResponse orderChartResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (orderChartResponse == null) {
                    System.out.println("reponse null");
                    mOrderChartActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mOrderChartActivityView.OrderChartDeleteSuccess(orderChartResponse.orderChartSuccessMessage);
            }

            @Override
            public void onFailure(Call<OrderChartResponse> call, Throwable t) {
                mOrderChartActivityView.validateFailure(null);
            }
        });
    }
}
