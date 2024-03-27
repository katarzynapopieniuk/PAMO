package com.pjatk.ui.calories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pjatk.R;
import com.pjatk.databinding.FragmentCaloriesBinding;

public class CaloriesFragment extends Fragment {

    private FragmentCaloriesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CaloriesViewModel caloriesViewModel =
                new ViewModelProvider(this).get(CaloriesViewModel.class);

        binding = FragmentCaloriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final SeekBar genderSeekBar = root.findViewById(R.id.genderSeekBar);
        final EditText bodyMassText = root.findViewById(R.id.editTextNumberDecimalPpmMass);
        final EditText heightText = root.findViewById(R.id.editTextNumberDecimalPpmHeight);
        final EditText ageText = root.findViewById(R.id.editTextNumberAge);
        final TextView resultTextView = root.findViewById(R.id.ppmResultTextView);

        final Button button = root.findViewById(R.id.calculateCaloriesButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    boolean isMale = genderSeekBar.getProgress() == 1;
                    double bodyMass = Double.parseDouble(bodyMassText.getText().toString());
                    double height = Double.parseDouble(heightText.getText().toString());
                    double age = Double.parseDouble(ageText.getText().toString());
                    double ppm = isMale ?
                            66.47 + (13.7 * bodyMass) + (5.0 * height * 100) - (6.76 * age)
                            :
                            655.1 + (9.567 * bodyMass) + (1.85 * height * 100) - (4.68 * age);

                    resultTextView.setText(String.valueOf(ppm));
                } catch (NumberFormatException e) {
                    resultTextView.setText("provide data first");
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}