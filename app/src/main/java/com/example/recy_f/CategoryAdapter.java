package com.example.recy_f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recy_f.databinding.ItemCatagoryBinding;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<category> categories;

    public CategoryAdapter(Context context, List<category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCatagoryBinding binding = ItemCatagoryBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        category categoryItem = categories.get(position);

        holder.binding.categoryIcon.setImageResource(categoryItem.getIcon());
        holder.binding.categoryName.setText(categoryItem.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ItemCatagoryBinding binding;

        public CategoryViewHolder(@NonNull ItemCatagoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
