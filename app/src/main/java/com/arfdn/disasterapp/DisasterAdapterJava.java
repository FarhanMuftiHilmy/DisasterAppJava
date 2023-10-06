package com.arfdn.disasterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arfdn.disasterapp.databinding.ItemDisasterBinding;

import java.util.List;

public class DisasterAdapterJava extends RecyclerView.Adapter<DisasterAdapterJava.ItemDisasterViewHolder> {

    private List<Disaster> listDisaster;
    private OnClickDisaster onClickDisaster;

    public DisasterAdapterJava(List<Disaster> listDisaster, OnClickDisaster onClickDisaster) {
        this.listDisaster = listDisaster;
        this.onClickDisaster = onClickDisaster;
    }

    @FunctionalInterface
    public interface OnClickDisaster {
        void onClick(Disaster disaster);
    }
    public class ItemDisasterViewHolder extends RecyclerView.ViewHolder {
        private ItemDisasterBinding binding;

        public ItemDisasterViewHolder(ItemDisasterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Disaster data) {
            binding.txtDisasterName.setText(data.getNameDisaster());
            binding.txtDisasterType.setText(data.getDisasterType());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickDisaster != null) {
                        onClickDisaster.onClick(data);
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public ItemDisasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDisasterBinding binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemDisasterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDisasterViewHolder holder, int position) {
        holder.bind(listDisaster.get(position));
    }

    @Override
    public int getItemCount() {
        return listDisaster.size();
    }
}
