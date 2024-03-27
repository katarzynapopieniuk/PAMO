package com.pjatk.ui.dishes;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pjatk.R;
import com.pjatk.databinding.FragmentDishesBinding;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DishesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentDishesBinding binding;

    private TextView recipeTextView;

    private Map<String,String> recipes;

    public DishesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DishesViewModel dishesViewModel =
                new ViewModelProvider(this).get(DishesViewModel.class);

        binding = FragmentDishesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Spinner spinnerDishes = root.findViewById(R.id.spinnerDishes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.dishes_list,
                android.R.layout.simple_spinner_item
        );
        spinnerDishes.setAdapter(adapter);
        spinnerDishes.setOnItemSelectedListener(this);

        recipeTextView = root.findViewById(R.id.recipeTextView);

        recipes = parseRecipes(R.array.recipes);

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String data = parent.getItemAtPosition(position).toString();
        recipeTextView.setText(recipes.get(data));
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    private Map<String, String> parseRecipes(int recipesResourceId) {
        String[] stringArray = getResources().getStringArray(recipesResourceId);
        Map<String, String> map = new HashMap<>();
        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            map.put(splitResult[0], splitResult[1]);
        }
        return map;
    }
}