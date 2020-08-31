package com.example.yogiyo_project.src.main.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;

import java.util.ArrayList;

public class CategoryTopRecyclerAdapter extends RecyclerView.Adapter<CategoryTopRecyclerAdapter.CategoryTopRecyclerViewHolder> {
    private ArrayList<CategoryTopRecyclerData> mDataListCategoryTop = null;
    Context mContext;

    public CategoryTopRecyclerAdapter(Context context,ArrayList<CategoryTopRecyclerData> datalist){
        mDataListCategoryTop = datalist;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CategoryTopRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_home_recyclerview_category_top_item, parent, false);
        CategoryTopRecyclerAdapter.CategoryTopRecyclerViewHolder vh = new CategoryTopRecyclerAdapter.CategoryTopRecyclerViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryTopRecyclerViewHolder holder, int position) {
        CategoryTopRecyclerData item = mDataListCategoryTop.get(position);

        holder.ivMenu.setImageDrawable(item.getmDrawableMenu());
        holder.tvMenu.setText(item.getmStringMenu());

    }

    @Override
    public int getItemCount() {
        return mDataListCategoryTop.size();
    }

    public class CategoryTopRecyclerViewHolder extends RecyclerView.ViewHolder{ //뷰홀더 클래스 어댑터 클래스 안에서 생성해주기!!!!!

        ImageView ivMenu;
        TextView tvMenu;

        public CategoryTopRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMenu = itemView.findViewById(R.id.fragment_home_recyclerview_category_top_item_iv);
            tvMenu = itemView.findViewById(R.id.fragment_home_recyclerview_category_top_item_tv);
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {  //수정 다시 하기
                    int action = motionEvent.getAction();

                    if(action == MotionEvent.ACTION_BUTTON_PRESS){
                        itemView.setBackgroundColor(Color.GRAY);
                    }
                    else if(action == MotionEvent.ACTION_UP){
                        itemView.setBackgroundColor(Color.WHITE);
                    }
                    return true;
                }
            });

        }
    }

}
