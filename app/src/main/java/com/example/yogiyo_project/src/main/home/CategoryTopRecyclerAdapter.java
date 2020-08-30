package com.example.yogiyo_project.src.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;

import java.util.ArrayList;

public class CategoryTopRecyclerAdapter extends RecyclerView.Adapter<CategoryTopRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<CategoryTopRecyclerData> mDataListCategoryTop = null;
    Context mContext;

    public CategoryTopRecyclerAdapter(ArrayList<CategoryTopRecyclerData> datalist){
        mDataListCategoryTop = datalist;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_home_recyclerview_category_top_item, parent, false);
        CategoryTopRecyclerAdapter.RecyclerViewHolder vh = new CategoryTopRecyclerAdapter.RecyclerViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        CategoryTopRecyclerData item = mDataListCategoryTop.get(position);

        holder.ivMenu.setImageDrawable(item.getmDrawableMenu());
        holder.tvMenu.setText(item.getmStringMenu());
    }

    @Override
    public int getItemCount() {
        return mDataListCategoryTop.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{ //뷰홀더 클래스 어댑터 클래스 안에서 생성해주기!!!!!

        ImageView ivMenu;
        TextView tvMenu;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMenu = itemView.findViewById(R.id.fragment_home_recyclerview_category_top_item_iv);
            tvMenu = itemView.findViewById(R.id.fragment_home_recyclerview_category_top_item_tv);
        }
    }
}
