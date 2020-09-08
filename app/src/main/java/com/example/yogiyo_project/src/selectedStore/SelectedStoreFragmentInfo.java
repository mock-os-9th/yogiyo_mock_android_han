package com.example.yogiyo_project.src.selectedStore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;

public class SelectedStoreFragmentInfo extends Fragment {

    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_selected_store_info, container, false);
        System.out.println("SelectedStore Fragment Info onCreateView");

        return mView;
    }
}
