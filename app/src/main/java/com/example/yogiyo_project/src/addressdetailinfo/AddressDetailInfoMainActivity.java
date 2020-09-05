package com.example.yogiyo_project.src.addressdetailinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.BaseActivity;
import com.example.yogiyo_project.src.addressoption.AddressMainActivity;
import com.example.yogiyo_project.src.addressoption.interfaces.AddressMainActivityView;
import com.example.yogiyo_project.src.main.MainActivity;
import com.example.yogiyo_project.src.main.home.HomeFragment;

public class AddressDetailInfoMainActivity extends BaseActivity implements AddressMainActivityView {
    EditText mEtAddressDetailInput;
    TextView mTvAddressInputComplete;
    ImageView mIvBackToAddressMain;

    TextView mTvMainAddressName;
    TextView mTvRoadAddressName;

    boolean deliveryHere = false;

    public static AddressDetailInfoMainActivity activity = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) { // 이전 주소 선택에서 위경도 값을 받고 여기서 다시 http 통신으로 보내야 할듯?
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_detail_info);

        activity=this;

        mTvMainAddressName = findViewById(R.id.activity_address_detailinfo_tv_mainaddressname);
        mTvRoadAddressName = findViewById(R.id.activity_address_detailinfo_tv_roadaddressname);

        mTvMainAddressName.setText(ApplicationClass.MAIN_ADDRESS_NAME);
        mTvRoadAddressName.setText(ApplicationClass.ROAD_ADDRESS_NAME);

        mIvBackToAddressMain = findViewById(R.id.activity_address_detailinfo_iv_back_to_addressmain); //뒤로가기
        mIvBackToAddressMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mEtAddressDetailInput = findViewById(R.id.activity_address_detailinfo_et_input_hint);
        mTvAddressInputComplete = findViewById(R.id.activity_address_detailinfo_tv_addresscomplete);

        mEtAddressDetailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                        if (!mEtAddressDetailInput.getText().toString().trim().equals("")) {
                            if (mEtAddressDetailInput.getText().length() != 0) {
                                mTvAddressInputComplete.setBackgroundColor(Color.RED);
                                deliveryHere = true;
                            }
                        }

                if(mEtAddressDetailInput.getText().toString().trim().equals("")){
                    if (mEtAddressDetailInput.getText().length() == 0){
                        mTvAddressInputComplete.setBackgroundColor(Color.parseColor("#A3A3A3"));
                    }
                }

            }
        });

        mTvAddressInputComplete.setOnClickListener(new View.OnClickListener() {  //요기로 배달 눌렀을 시
            @Override
            public void onClick(View view) {
                if(deliveryHere) {
                    ApplicationClass.InputAddress = true; // 주소 선택 완료 했으므로  true로!!
                    if (AddressMainActivity.activity != null) { //이전 AddressMain 액티비티 살아있다면 끄기
                        AddressMainActivity activity = (AddressMainActivity) AddressMainActivity.activity;
                        activity.finish();
                    }
                    finish(); //AddressDeatail도 스택에서 사라지기!
                }
            }
        });


    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void adressSuccess(String message) {

    }
}
