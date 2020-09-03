package com.example.yogiyo_project.src;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.yogiyo_project.config.XAccessTokenInterceptor;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationClass extends Application {
    public static MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=uft-8");
    public static MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");

    // 테스트 서버 주소
    public static String BASE_URL = "http://52.78.11.153/";     //필요한 여러 값들을 저장하는 클래스이다 / 다른 클래스에서 자유자재로 사용가능한 static 변수들
    public static String BASE_URL_2 = "http://13.209.19.46/";
    // 실서버 주소
//    public static String BASE_URL = "https://template.softsquared.com/";

    public static SharedPreferences sSharedPreferences = null;  //클래스별로 sharedpreference 생성x / 여기 선언된 sharedpreference 사용하기

    // SharedPreferences 키 값
    public static String TAG = "TEMPLATE_APP";

    // JWT Token 값
    public static String X_ACCESS_TOKEN = "X-ACCESS-TOKEN";  //서버에서 받아온 jwt 토큰 넣는 것이다

    //날짜 형식
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

    // Retrofit 인스턴스
    public static Retrofit retrofit;
    public static Retrofit retrofit2;

    @Override
    public void onCreate() {
        super.onCreate();

        if (sSharedPreferences == null) {
            sSharedPreferences = getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new XAccessTokenInterceptor()) // JWT 자동 헤더 전송
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Retrofit getRetrofit2() {
        if (retrofit2 == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new XAccessTokenInterceptor()) // JWT 자동 헤더 전송
                    .build();

            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL_2)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit2;
    }
}