package com.example.callbacks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeafletListAdapter extends RecyclerView.Adapter<LeafletListAdapter.LeafletViewHolder> {
    private ArrayList<Leaflet> learfletList;
    private Context context;

    public LeafletListAdapter(Context context, ArrayList<Leaflet> learfletList) {
        this.learfletList = learfletList;
        this.context = context;
    }

    @NonNull
    @Override
    public LeafletListAdapter.LeafletViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_leaflet, parent, false);
        return new LeafletListAdapter.LeafletViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeafletViewHolder holder, int position) {
        holder.txtGroup.setText(learfletList.get(position).getGroup());
        holder.txtDate.setText(learfletList.get(position).getDate());
        holder.imgButtonGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"Hola",Toast.LENGTH_SHORT).show();
                PopupMenuGetAll.generatePopupMenu(v.getContext(),v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return learfletList.size();
    }

    public static class LeafletViewHolder extends RecyclerView.ViewHolder {
        TextView txtGroup;
        TextView txtDate;
        ImageView imgUser;
        ImageButton imgButtonGroup;

        public LeafletViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGroup = (TextView) itemView.findViewById(R.id.txtGroup);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            imgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            imgButtonGroup = (ImageButton) itemView.findViewById(R.id.imgButtonGroup);
        }
    }

    private void getPopup(final Context context, final View textView, ArrayList<String> arrayList) {
        final PopupMenu popupMenu = new PopupMenu(context,textView);
        for (int i = 0; i < arrayList.size(); i++) {
            popupMenu.getMenu().add(i, Menu.FIRST, i, arrayList.get(i));
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        popupMenu.show();
    }
}