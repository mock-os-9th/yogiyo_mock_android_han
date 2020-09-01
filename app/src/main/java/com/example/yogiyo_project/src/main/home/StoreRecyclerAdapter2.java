package com.example.yogiyo_project.src.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogiyo_project.R;

import java.util.ArrayList;
                                    //우리동네 찜 많은 음식점   리사이클러뷰 어댑터
public class StoreRecyclerAdapter2 extends RecyclerView.Adapter<StoreRecyclerAdapter2.StoreRecyclerViewHolder2> {
    private ArrayList<StoreRecyclerData> mDataListStore2 = null;
    Context mContext;

    public StoreRecyclerAdapter2(Context context, ArrayList<StoreRecyclerData> datalist){
        mDataListStore2 = datalist;
        this.mContext = context;
    }


    @NonNull
    @Override
    public StoreRecyclerViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_home_recyclerview_store_item, parent, false);
        StoreRecyclerAdapter2.StoreRecyclerViewHolder2 vh = new StoreRecyclerAdapter2.StoreRecyclerViewHolder2(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreRecyclerViewHolder2 holder, int position) {
        StoreRecyclerData item = mDataListStore2.get(position);

        holder.ivStoreImage.setImageDrawable(item.getmDrawableStore());
        holder.tvStoreName.setText(item.getmStringStoreName());
        holder.tvStoreRating.setText(item.getmStringStoreRating());
        holder.tvStoreReviewCount.setText(item.getmStringReviewCount());
        holder.tvStoreAdditionalInfo.setText(item.getmStringAdditionalInfo());
        holder.linearLayoutSubInfoFavorite.setVisibility(View.VISIBLE);
        holder.tvStoreSubInfo.setText(item.getmStringSubInfoFavorite());
    }

    @Override
    public int getItemCount() {
        return mDataListStore2.size();
    }

    public class StoreRecyclerViewHolder2 extends RecyclerView.ViewHolder{
        ImageView ivStoreImage;
        TextView tvStoreName;
        TextView tvStoreRating;
        TextView tvStoreReviewCount;
        TextView tvStoreAdditionalInfo;
        LinearLayout linearLayoutSubInfoFavorite;
        TextView tvStoreSubInfo;

        public StoreRecyclerViewHolder2(@NonNull View itemView) {
            super(itemView);

            ivStoreImage = itemView.findViewById(R.id.fragment_home_recyclerview_store_iv);
            tvStoreName = itemView.findViewById(R.id.fragment_home_recyclerview_storename_tv);
            tvStoreRating = itemView.findViewById(R.id.fragment_home_recyclerview_rating_tv);
            tvStoreReviewCount = itemView.findViewById(R.id.fragment_home_recyclerview_review_count_tv);
            tvStoreAdditionalInfo = itemView.findViewById(R.id.fragment_home_recyclerview_additional_info);
            linearLayoutSubInfoFavorite = itemView.findViewById(R.id.fragment_home_recyclerview_sub_info_favorite_linearlayout);
            tvStoreSubInfo = itemView.findViewById(R.id.fragment_home_recyclerview_sub_info_favorite_tv);
        }
    }
}
