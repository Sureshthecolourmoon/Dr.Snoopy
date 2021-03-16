package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.PetrecyclerModel;
import com.example.drsnoopy.R;

import java.util.List;

public class PetrecyclerAdapter extends RecyclerView.Adapter<PetrecyclerAdapter.ViewHolder> {
    Context context;
    List<PetrecyclerModel> petrecyclerModelList;

    public PetrecyclerAdapter(Context context, List<PetrecyclerModel> petrecyclerModelList) {
        this.context = context;
        this.petrecyclerModelList = petrecyclerModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pets_itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PetrecyclerModel petrecyclerModel = petrecyclerModelList.get(position);
        holder.textpet.setText(petrecyclerModel.getText());
        holder.imagepet.setImageResource(petrecyclerModel.getImage());

    }

    @Override
    public int getItemCount() {
        return petrecyclerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagepet;
        TextView textpet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagepet = itemView.findViewById(R.id.image_pet);
            textpet = itemView.findViewById(R.id.text_pet);

        }
    }
}
