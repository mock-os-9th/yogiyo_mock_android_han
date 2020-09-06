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
    public static String BASE_URL_2 = "https://yogiyo.shop/"; //요기요 서버 주소
    public static String BASE_URL_CATEGORY = "https://minzzu.shop/"; //현재 가게조회 테스트 서버

    public static String KAKAO_BASE_URL = "https://dapi.kakao.com/";
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
    public static Retrofit retrofit3;

    //MyYogiyo 프래그먼트에서 로그인 전후로 바뀌는 광고 상태   비로그인시 false  로그인 시 true
    public static boolean logInState = false;

    //카카오 주소 API 키
    public static String KAKAO_API_KEY = "f8c69dbfdf18a626af6d5ef9678dfd34";

    //주소명 / 도로명주소 / 위도 / 경도 / 동이름 / 주소번호
    public static String MAIN_ADDRESS_NAME;
    public static String ROAD_ADDRESS_NAME;
    public static String LATITUDE;
    public static String LONGITUDE;
    public static String DONG_NAME;
    public static String MAIN_ADDRESS_NO;

    //주소 선택이 되었는지 체크
    public static boolean INPUT_ADDRESS = false;

    //홈 화면 메뉴 카테고리 리사이클러뷰에서 특정 카테고리 선택 시 화면 전환되면서 해당 카테고리의 탭 아이템 선택되게 하기
    public static int MENU_CATEGORY_NUM = 1;

   @Override
    public void onCreate() {
        super.onCreate();

        if (sSharedPreferences == null) {
            sSharedPreferences = getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
    }

    public static Retrofit getRetrofit() {  //카카오 주소 API를 위한 getRetrofit
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new XAccessTokenInterceptor()) // JWT 자동 헤더 전송
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(KAKAO_BASE_URL)
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
    public static Retrofit getRetrofit3() {  //가게정보 테스트를 위한 retrofit3
        if (retrofit3 == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new XAccessTokenInterceptor()) // JWT 자동 헤더 전송
                    .build();

            retrofit3 = new Retrofit.Builder()
                    .baseUrl(BASE_URL_CATEGORY)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit3;
    }
}