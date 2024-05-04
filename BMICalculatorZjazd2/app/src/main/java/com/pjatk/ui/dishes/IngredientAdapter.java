package com.pjatk.ui.dishes;

import static android.graphics.Paint.STRIKE_THRU_TEXT_FLAG;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pjatk.R;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private final List<Ingredient> ingredients;

    public IngredientAdapter(List<Ingredient> ingredients) {
        this.ingredients = new ArrayList<>(ingredients);
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.ingredient_check,
                        parent,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Ingredient curIngredient = ingredients.get(position);
        holder.getTextView().setText(curIngredient.getName());
        holder.getCheckBox().setChecked(curIngredient.isChecked());
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                curIngredient.toggle();
                toggleStrikeThrough(holder.getTextView(), isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    private void toggleStrikeThrough(TextView name, boolean isChecked) {
        if(isChecked) {
            name.setPaintFlags(name.getPaintFlags() | STRIKE_THRU_TEXT_FLAG);
        } else {
            name.setPaintFlags(name.getPaintFlags() & ~STRIKE_THRU_TEXT_FLAG);
        }
    }

    public static class IngredientViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final CheckBox checkBox;

        public IngredientViewHolder(@NonNull View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.ingredientTV);

            this.checkBox = view.findViewById(R.id.ingredientCB);
        }

        public TextView getTextView() {
            return textView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

}
