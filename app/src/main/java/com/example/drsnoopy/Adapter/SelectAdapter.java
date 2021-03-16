package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.SelectModel;
import com.example.drsnoopy.R;

import java.util.List;

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {
    Context context;
    List<SelectModel> selectModelList;

    public SelectAdapter(Context context, List<SelectModel> selectModelList) {
        this.context = context;
        this.selectModelList = selectModelList;
    }

    public interface selecteditemlistlistner {
        void Onselecteditemlistner(int position);
    }

    public selecteditemlistlistner selecteditemlistlistner;

    public void setSelecteditemlistlistner(SelectAdapter.selecteditemlistlistner selecteditemlistlistner) {
        this.selecteditemlistlistner = selecteditemlistlistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.select_itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SelectModel selectModel = selectModelList.get(position);
        holder.textView.setText(selectModel.getText());
        holder.image.setImageResource(selectModel.getImage());


    }

    @Override
    public int getItemCount() {
        return selectModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_select);
            textView = itemView.findViewById(R.id.text_select);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    selecteditemlistlistner.Onselecteditemlistner(position);
                }
            });
        }
    }
}
