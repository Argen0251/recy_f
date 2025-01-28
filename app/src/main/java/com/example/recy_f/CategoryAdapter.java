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

    public void moveToFirstPosition(int position) {
        if (position >= 0 && position < categories.size()) {
            category selectedCategory = categories.remove(position);
            categories.add(0, selectedCategory);
            notifyItemMoved(position, 0);
            notifyDataSetChanged();
        }
    }
    public void searchAndMoveToFirstPosition(String cate1) {
        for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getName().equalsIgnoreCase(cate1)) {
                moveToFirstPosition(i);
                return;
            }
        }

    }

    public void DeleteItem(int position) {
        categories.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCatagoryBinding binding = ItemCatagoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position), position);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private int selectedPosition = 0;
        private ItemCatagoryBinding binding;

        public CategoryViewHolder(@NonNull ItemCatagoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(category categoryItem, int position) {
            binding.categoryName.setText(categoryItem.getName());
            binding.categoryIcon.setImageResource(categoryItem.getIcon());

            if (position == selectedPosition) {
                binding.categoryC.setBackgroundResource(R.drawable.ramk_red);
            } else {
                binding.categoryC.setBackgroundResource(R.drawable.ramk);
            }

            binding.getRoot().setOnClickListener(view -> {
                moveToFirstPosition(getAdapterPosition());
            });
            binding.delet.setOnClickListener(view -> {
                DeleteItem(getAdapterPosition());
            });
        }
    }
}
