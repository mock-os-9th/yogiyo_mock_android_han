package com.example.yogiyo_project.src;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yogiyo_project.R;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity{
    public ProgressDialog mProgressDialog;

    public void showCustomToast(final String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();   // BaseActivity의 함수들 사용하기
    }

    public void showProgressDialog() {  //원모양으로 돌아가는 로딩 띄우기
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {  //로딩 없애기
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {   //Base를 상속받은 액티비티의 onStop에서는 모두 hideProgressDialog 된다  //설명영상 7분대
        super.onStop();
        hideProgressDialog();
    }

}
