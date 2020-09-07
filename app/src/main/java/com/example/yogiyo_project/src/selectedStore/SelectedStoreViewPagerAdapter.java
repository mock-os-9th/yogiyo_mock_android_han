package com.example.yogiyo_project.src.selectedStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yogiyo_project.src.ApplicationClass;

import java.util.ArrayList;

public class SelectedStoreViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    SelectedStoreFragmentMenu frag_menu = new SelectedStoreFragmentMenu();
    SelectedStoreFragmentCleanReview frag_clean_review = new SelectedStoreFragmentCleanReview();
    SelectedStoreFragmentInfo frag_info = new SelectedStoreFragmentInfo();

    public SelectedStoreViewPagerAdapter(FragmentManager fm){
        super(fm);

        items = new ArrayList<Fragment>();
        items.add(frag_menu);
        items.add(frag_clean_review);
        items.add(frag_info);

        itext.add("메뉴 " + String.valueOf(ApplicationClass.MENU_COUNT));
        itext.add("클린리뷰 " + String.valueOf(ApplicationClass.REVIEW_COUNT));
        itext.add("정보");

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
