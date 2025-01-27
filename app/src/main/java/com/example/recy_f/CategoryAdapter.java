package com.example.recy_f;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recy_f.databinding.ItemCatagoryBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<category> categories;

    public CategoryAdapter(ArrayList<category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCatagoryBinding binding = ItemCatagoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ItemCatagoryBinding binding;

        public CategoryViewHolder(@NonNull ItemCatagoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(category categoryItem) {
            binding.categoryName.setText(categoryItem.getName());
            binding.categoryIcon.setImageResource(categoryItem.getIcon());
        }
    }
}
