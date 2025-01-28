package com.example.recy_f;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recy_f.databinding.ActivityFoodBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<category> categories = new ArrayList<>();
        categories.add(new category("Burgers", R.drawable.ic_burgermini));
        categories.add(new category("Pizza", R.drawable.ic_pizza));
        categories.add(new category("Chicken", R.drawable.ic_chickenfull));
        categories.add(new category("Sushi", R.drawable.ic_sushii));

        String imag = "https://miro.medium.com/v2/resize:fit:1400/0*wjigoZrTnRmQJhCQ";
        Glide.with(FoodActivity.this)
                .load(imag)
                .apply(RequestOptions.circleCropTransform())
                .error(R.color.black)
                .into(binding.avatar);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        binding.categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRecyclerView.setAdapter(categoryAdapter);

        ArrayList<food> foods = new ArrayList<>();
        foods.add(new food("Salad Burger", "$12", R.drawable.ic_bigburger));
        foods.add(new food("Big Burger", "$20", R.drawable.ic_burgerbig));
        foods.add(new food("Combo Burger", "$25", R.drawable.ic_combo));
        foods.add(new food("KFC", "$6", R.drawable.ic_chicken));

        FoodAdapter foodAdapter = new FoodAdapter( foods);
        binding.foodRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.foodRecyclerView.setAdapter(foodAdapter);


        binding.searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String food1 = charSequence.toString().trim();
                if (!food1.isEmpty()) {
                    foodAdapter.search(food1);
                    categoryAdapter.search(food1);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }
}
