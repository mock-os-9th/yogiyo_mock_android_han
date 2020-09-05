package com.example.yogiyo_project.src.addressoption;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.addressoption.interfaces.AddressMainActivityView;

import java.util.ArrayList;


public class AddressMainActivity extends BaseActivity implements AddressMainActivityView {
    ImageView mIvAddressActivityBack;
    EditText mEtAddressActivitySearch;
    String addressInput;
    TextView mTvAddressActivityGoToSearch;

    public static AddressMainActivity activity = null;

    ListView mLvAddressActivityAddressListView; //주소 검색 결과 담을 리스트뷰
    public static ArrayList<AddressData> addressDataArrayList = new ArrayList<>();
    public static AddressAdapter addressAdapter = new AddressAdapter(addressDataArrayList);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_main);

        activity = this;

        mLvAddressActivityAddressListView = findViewById(R.id.activity_address_listview); //리스트뷰 어댑터 설정
        mLvAddressActivityAddressListView.setAdapter(addressAdapter);

        mIvAddressActivityBack = findViewById(R.id.fragment_home_iv_adress_back); //뒤로가기 버튼
        mIvAddressActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mTvAddressActivityGoToSearch = findViewById(R.id.activity_address_tv_gotosearch);  //주소를 제대로 입력 시 검색 버튼 나타나게 하기
        mTvAddressActivityGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressInput = mEtAddressActivitySearch.getText().toString();  //입력한 주소 전달하기 위한 String 변수 선언
                tryGetAddress();
            }
        });

        mEtAddressActivitySearch = findViewById(R.id.activity_address_et_search_hint);  //검색한 주소를 가져오기 위함
        mEtAddressActivitySearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!mEtAddressActivitySearch.getText().toString().trim().equals("")) {
                    if (mEtAddressActivitySearch.getText().length() != 0) {
                        mTvAddressActivityGoToSearch.setVisibility(View.VISIBLE);
                    }
                }
                if(mEtAddressActivitySearch.getText().toString().trim().equals("")){
                    if (mEtAddressActivitySearch.getText().length() == 0){
                        mTvAddressActivityGoToSearch.setVisibility(View.GONE);
                    }
                }

            }
        });


    }

    private void tryGetAddress(){
        showProgressDialog();  //로딩시작!  // 서버통신전에 로딩을 띄워주는것
        final AddressMainService addressMainService = new AddressMainService(this);
        addressMainService.getMyAddress(addressInput);
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();  //통신이 끝나면 로딩 hide시켜준다
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog(); //통신이 끝나면 로딩 hide시켜준다
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);

    }

    @Override
    public void adressSuccess(String message) {
        hideProgressDialog();
    }
}
