package com.example.yogiyo_project.src.addressoption;

import com.example.yogiyo_project.src.addressoption.interfaces.AddressMainActivityView;
import com.example.yogiyo_project.src.addressoption.interfaces.AddressMainRetrofitInterface;
import com.example.yogiyo_project.src.addressoption.models.AddressResponse;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;

import java.util.ArrayList;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class AddressMainService {
    private final AddressMainActivityView mAddressMainActivityView;

    AddressMainService(final AddressMainActivityView addressMainActivityView){
        this.mAddressMainActivityView = addressMainActivityView;
    }


    void getMyAddress(String addressInput) {  //서버통신부분
        final AddressMainRetrofitInterface addressmainRetrofitInterface = getRetrofit().create(AddressMainRetrofitInterface.class);
        addressmainRetrofitInterface.getAddressData(addressInput).enqueue(new Callback<AddressResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                final AddressResponse addressResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (addressResponse == null) {
                    mAddressMainActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                for(AddressResponse.KakaoAddress data : addressResponse.getKakaoAddress()){
                    AddressData item = new AddressData();

                    item.mainAddressName = data.getAddress().getAddress_name();
                    item.roadAddressName = data.getRoad_address();
                    item.latitude = data.getAddressLatitude();
                    item.longitude = data.getAddressLongitude();
                    item.dongName = data.getAddress().getRegion_3depth_name();
                    item.mainAddressNo = data.getAddress().getMain_address_no();

                    AddressMainActivity.addressDataArrayList.add(item);
                }
                AddressMainActivity.addressAdapter.notifyDataSetChanged();

                System.out.println(addressResponse.getKakaoAddress().get(0).getAddressLatitude() +"\n"+
                        addressResponse.getKakaoAddress().get(0).getAddressLongitude() +"\n"+
                        addressResponse.getKakaoAddress().get(0).getRoad_address()+"\n"+
                        addressResponse.getKakaoAddress().get(0).getAddress().getAddress_name()+"\n"+
                        addressResponse.getKakaoAddress().get(0).getAddress().getRegion_3depth_name()+"\n"+
                        addressResponse.getKakaoAddress().get(0).getAddress().getMain_address_no());
                mAddressMainActivityView.adressSuccess("주소 검색에 성공했습니다"); //MainActivity의 validateSuccess의 함수가 실행
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                mAddressMainActivityView.validateFailure(null);
            }
        });
    }
}
