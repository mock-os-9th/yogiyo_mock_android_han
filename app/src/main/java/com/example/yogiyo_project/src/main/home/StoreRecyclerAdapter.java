package com.example.yogiyo_project.src.main.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;
import com.example.yogiyo_project.src.selectedStore.SelectedStoreMainActivity;

import java.util.ArrayList;
                                //나의 입맛 저격! 리사이클러뷰 어댑터
public class StoreRecyclerAdapter extends RecyclerView.Adapter<StoreRecyclerAdapter.StoreRecyclerViewHolder> {
    private ArrayList<StoreRecyclerData> mDataListStore = null;
    Context mContext;

    public StoreRecyclerAdapter(Context context, ArrayList<StoreRecyclerData> datalist){
        mDataListStore = datalist;
        this.mContext = context;
    }

    @NonNull
    @Override
    public StoreRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_home_recyclerview_store_item, parent, false);
        StoreRecyclerAdapter.StoreRecyclerViewHolder vh = new StoreRecyclerAdapter.StoreRecyclerViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreRecyclerViewHolder holder, int position) {
        StoreRecyclerData item = mDataListStore.get(position);

        holder.ivStoreImage.setImageDrawable(item.getmDrawableStore());
        holder.tvStoreName.setText(item.getmStringStoreName());
        holder.tvStoreRating.setText(item.getmStringStoreRating());
        holder.tvStoreReviewCount.setText(item.getmStringReviewCount());
        holder.tvStoreAdditionalInfo.setText(item.getmStringAdditionalInfo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), SelectedStoreMainActivity.class);
                holder.itemView.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataListStore.size();
    }


    public class StoreRecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView ivStoreImage;
        TextView tvStoreName;
        TextView tvStoreRating;
        TextView tvStoreReviewCount;
        TextView tvStoreAdditionalInfo;

        public StoreRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStoreImage = itemView.findViewById(R.id.fragment_home_recyclerview_store_iv);
            tvStoreName = itemView.findViewById(R.id.fragment_home_recyclerview_storename_tv);
            tvStoreRating = itemView.findViewById(R.id.fragment_home_recyclerview_rating_tv);
            tvStoreReviewCount = itemView.findViewById(R.id.fragment_home_recyclerview_review_count_tv);
            tvStoreAdditionalInfo = itemView.findViewById(R.id.fragment_home_recyclerview_additional_info);

        }
    }
}
