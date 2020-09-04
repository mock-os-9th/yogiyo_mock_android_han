package com.example.yogiyo_project.src.login;

import com.example.yogiyo_project.src.login.interfaces.LogInActivityView;
import com.example.yogiyo_project.src.login.interfaces.LogInRetrofitInterface;
import com.example.yogiyo_project.src.login.models.LogInBody;
import com.example.yogiyo_project.src.login.models.LogInResponse;
import com.example.yogiyo_project.src.signup.Interfaces.SignUpActivityView;
import com.example.yogiyo_project.src.signup.Interfaces.SignUpRetrofitInterface;
import com.example.yogiyo_project.src.signup.models.SignUpBody;
import com.example.yogiyo_project.src.signup.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

import static com.example.yogiyo_project.src.ApplicationClass.getRetrofit2;

class LogInMainService {
    private final LogInActivityView mLogInActivityView;

    LogInMainService(final LogInActivityView logInActivityView){
        this.mLogInActivityView = logInActivityView;
    }

    void postLogIn(String id, String pw) {  //서버통신부분
        final LogInRetrofitInterface logInRetrofitInterface = getRetrofit2().create(LogInRetrofitInterface.class);  // 이 부분은 위랑 같이 그대로
        logInRetrofitInterface.logInTest(new LogInBody(id, pw)).enqueue(new Callback<LogInResponse>() {  //비동기 호출
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                final LogInResponse logInResponse = response.body(); //response = 서버에서 api통신을 통해 얻은 json..?
                if (logInResponse == null) {
                    System.out.println("logInResponse = null");
                    mLogInActivityView.validateFailure(null);  //아직 view가 호출되지 않았는데 함수가 더 빨리 실행되서 오류가 나오는 등 상황 발생할 수 있다
                    return;   //MainActivity의 validateFailure 호출된다
                }

                mLogInActivityView.logInSuccess(logInResponse.getMessage(), logInResponse.getLogInResult()); //MainActivity의 validateSuccess의 함수가 실행

            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                System.out.println("fail");
                mLogInActivityView.validateFailure(null);
            }
        });
    }

}
