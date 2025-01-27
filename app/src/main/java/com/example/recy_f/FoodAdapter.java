package com.example.recy_f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recy_f.databinding.ItemFoodBinding;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<food> foods;

    public FoodAdapter(ArrayList<food> foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(foods.get(position));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ItemFoodBinding binding;

        public FoodViewHolder(@NonNull ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(food foodItem) {
            binding.foodImage.setImageResource(foodItem.getImage());
            binding.foodName.setText(foodItem.getName());
            binding.foodPrice.setText(foodItem.getPrice());
        }
    }
}
