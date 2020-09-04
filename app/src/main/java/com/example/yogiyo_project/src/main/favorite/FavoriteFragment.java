package com.example.yogiyo_project.src.main.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yogiyo_project.R;

public class FavoriteFragment extends Fragment {
    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_favorite, container, false);
        System.out.println("FavoriteFragment onCreateView");

        return mView;
    }
}
