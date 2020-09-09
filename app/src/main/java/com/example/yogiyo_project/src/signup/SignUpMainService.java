package com.example.yogiyo_project.src.signup;

import com.example.yogiyo_project.src.main.interfaces.MainActivityView;
import com.example.yogiyo_project.src.main.interfaces.MainRetrofitInterface;
import com.example.yogiyo_project.src.myinfopage.MyInfoPageMainActivity;
import com.example.yogiyo_project.src.signup.Interfaces.SignUpActivityView;
import com.example.yogiyo_project.src.signup.Interfaces.SignUpRetrofitInterface;
import com.example.yogiyo_project.src.signup.models.SignUpBody;
import com.example.yogiyo_project.src.signup.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit;
import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit2;

class SignUpMainService {
    private final SignUpActivityView mSignUpActivityView;

    SignUpMainService(final SignUpActivityView signUpActivityView){
        this.mSignUpActivityView = signUpActivityView;
    }

    void postSignUp(String method, String userEmail, String password, String checkPassword, String nickName, String phoneNum) {  //서버통신부분
        final SignUpRetrofitInterface signUpRetrofitInterface = getRetrofit2().create(SignUpRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        signUpRetrofitInterface.signUpTest(new SignUpBody(method, userEmail, password, checkPassword, nickName, phoneNum)).enqueue(new Callback<SignUpResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                final SignUpResponse signUpResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (signUpResponse == null) {
                    System.out.println("signUpResponse = null");
                    mSignUpActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }
                //MyInfoPageMainActivity.MyInfoInput(userEmail, password, nickName, phoneNum);
                mSignUpActivityView.signUpSuccess(signUpResponse.getMessage()); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                System.out.println("fail");
                mSignUpActivityView.validateFailure(null);
            }
        });
    }
}
