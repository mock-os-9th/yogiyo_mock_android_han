package com.example.yogiyo_project.src.selectedStore;

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

public class SelectedStoreRecyclerAdpater extends RecyclerView.Adapter<SelectedStoreRecyclerAdpater.RecyclerViewHolder> {

    private ArrayList<SelectedStoreRecyclerData> rData = null;
    Context context;

    public SelectedStoreRecyclerAdpater(ArrayList<SelectedStoreRecyclerData> datalist){
        rData = datalist;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.selected_store_menu_recyclerview_item, parent, false);
        SelectedStoreRecyclerAdpater.RecyclerViewHolder vh = new SelectedStoreRecyclerAdpater.RecyclerViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        SelectedStoreRecyclerData item = rData.get(position);

        holder.menuName.setText(item.menuName);
        holder.menuPrice.setText(item.menuPrice);

    }

    @Override
    public int getItemCount() {
        return rData.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{ //뷰홀더 클래스 어댑터 클래스 안에서 생성해주기!!!!!

        ImageView storeImageView;
        TextView menuName;
        TextView menuPrice;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            storeImageView = itemView.findViewById(R.id.selected_store_recycleritem_iv_menu);
            menuName = itemView.findViewById(R.id.selected_store_recycleritem_tv_menu);
            menuPrice = itemView.findViewById(R.id.selected_store_recycleritem_tv_price);
        }
    }
}
