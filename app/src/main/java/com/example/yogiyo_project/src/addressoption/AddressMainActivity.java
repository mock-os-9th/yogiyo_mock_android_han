package com.example.yogiyo_project.src.addressoption;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;

public class AddressMainActivity extends AppCompatActivity {
    ImageView mIvAddressActivityBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_main);

        mIvAddressActivityBack = findViewById(R.id.fragment_home_iv_adress_back);
        mIvAddressActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
