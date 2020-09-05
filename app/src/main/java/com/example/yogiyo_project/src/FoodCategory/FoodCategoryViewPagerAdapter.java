package com.example.yogiyo_project.src.FoodCategory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FoodCategoryViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    FoodCategoryFragment1 frag1 = new FoodCategoryFragment1();
    FoodCategoryFragment2 frag2 = new FoodCategoryFragment2();
    FoodCategoryFragment3 frag3 = new FoodCategoryFragment3();
    FoodCategoryFragment4 frag4 = new FoodCategoryFragment4();
    FoodCategoryFragment5 frag5 = new FoodCategoryFragment5();
    FoodCategoryFragment6 frag6 = new FoodCategoryFragment6();
    FoodCategoryFragment7 frag7 = new FoodCategoryFragment7();
    FoodCategoryFragment8 frag8 = new FoodCategoryFragment8();
    FoodCategoryFragment9 frag9 = new FoodCategoryFragment9();
    FoodCategoryFragment10 frag10 = new FoodCategoryFragment10();
    FoodCategoryFragment11 frag11= new FoodCategoryFragment11();
    FoodCategoryFragment12 frag12 = new FoodCategoryFragment12();
    FoodCategoryFragment13 frag13 = new FoodCategoryFragment13();



    public FoodCategoryViewPagerAdapter(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(frag1);
        items.add(frag2);
        items.add(frag3);
        items.add(frag4);
        items.add(frag5);
        items.add(frag6);
        items.add(frag7);
        items.add(frag8);
        items.add(frag9);
        items.add(frag10);
        items.add(frag11);
        items.add(frag12);
        items.add(frag13);

        itext.add("전체보기");
        itext.add("치킨");
        itext.add("중국집");
        itext.add("피자/양식");
        itext.add("한식");
        itext.add("분식");
        itext.add("카페/디저트");
        itext.add("1인분주문");
        itext.add("일식/돈까스");
        itext.add("족발/보쌈");
        itext.add("프랜차이즈");
        itext.add("야식");
        itext.add("편의점/마트");

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
