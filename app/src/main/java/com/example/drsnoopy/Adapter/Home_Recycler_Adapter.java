package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.Home_recycler_Model;
import com.example.drsnoopy.R;

import java.util.List;

public class Home_Recycler_Adapter extends RecyclerView.Adapter<Home_Recycler_Adapter.ViewHolder> {
    Context context;
    List<Home_recycler_Model>home_recycler_modelslist;

    public Home_Recycler_Adapter(Context context, List<Home_recycler_Model> home_recycler_modelslist) {
        this.context = context;
        this.home_recycler_modelslist = home_recycler_modelslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.homerecycle_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Home_recycler_Model home_recycler_model=home_recycler_modelslist.get(position);
        holder.image.setImageResource(home_recycler_model.getImage());
        holder.text.setText(home_recycler_model.getText());

    }

    @Override
    public int getItemCount() {
        return home_recycler_modelslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.home_image_recycler);
            text=itemView.findViewById(R.id.home_text_recycler);
        }
    }
}
