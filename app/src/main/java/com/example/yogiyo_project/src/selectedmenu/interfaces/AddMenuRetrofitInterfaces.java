package com.example.yogiyo_project.src.selectedmenu.interfaces;

import com.example.yogiyo_project.src.login.models.LogInBody;
import com.example.yogiyo_project.src.login.models.LogInResponse;
import com.example.yogiyo_project.src.selectedmenu.models.AddMenuBody;
import com.example.yogiyo_project.src.selectedmenu.models.AddMenuResponse;
import com.example.yogiyo_project.src.selectedmenu.models.CartInquireResponse;
import com.example.yogiyo_project.src.selectedmenu.models.MenuDetailResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AddMenuRetrofitInterfaces {
    @POST("store/{storeIdx}/menu/{menuIdx}")
    Call<AddMenuResponse> getAddMenu(@Body AddMenuBody params,
                                     @Path("storeIdx")int storeNum,
                                     @Path("menuIdx")int menuNum);

    @GET("user/cart")
    Call<CartInquireResponse>getCartInquire();

    @GET("store/{storeIdx}/menu/{menuIdx}")
    Call<MenuDetailResponse> getMenuDetail(@Path("storeIdx")int storeIdx, @Path("menuIdx")int menuIdx);
}
