package com.example.recy_f;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recy_f.databinding.ItemFoodBinding;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<food> foods;
    private int selectedPosition = 0;

    public FoodAdapter(ArrayList<food> foods) {
        this.foods = foods;
    }

    public void moveToFirstPosition(int position) {
        if (position >= 0 && position < foods.size()) {
            food foods0 = foods.remove(position);
            foods.add(0, foods0);
            notifyItemMoved(position, 0);
            notifyDataSetChanged();
        }
    }

    public void DeleteItem(int position) {
        foods.remove(position);
        notifyItemRemoved(position);

    }

    public void searchAndMoveToFirstPosition(String food1) {
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equalsIgnoreCase(food1)) {
                moveToFirstPosition(i);
                return;
            }
        }

    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(foods.get(position), position);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ItemFoodBinding binding;

        public FoodViewHolder(@NonNull ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(food foodItem, int position) {
            binding.foodImage.setImageResource(foodItem.getImage());
            binding.foodName.setText(foodItem.getName());
            binding.foodPrice.setText(foodItem.getPrice());

            if (position == selectedPosition) {
                binding.foodd.setBackgroundResource(R.drawable.ramk_burg);
            } else {
                binding.foodd.setBackgroundResource(R.drawable.ramk_bur_red);
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
