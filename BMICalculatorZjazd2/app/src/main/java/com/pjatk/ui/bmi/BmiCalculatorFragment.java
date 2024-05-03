package com.pjatk.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pjatk.R;
import com.pjatk.control.BmiCalculator;
import com.pjatk.databinding.FragmentBmiBinding;

public class BmiCalculatorFragment extends Fragment {

    private FragmentBmiBinding binding;

    private BmiCalculator bmiCalculator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BmiCalculatorViewModel bmiCalculatorViewModel =
                new ViewModelProvider(this).get(BmiCalculatorViewModel.class);

        binding = FragmentBmiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText bodyMassText = root.findViewById(R.id.editTextBodyMass);
        final EditText heightText = root.findViewById(R.id.editTextHeight);
        final TextView resultTextView = root.findViewById(R.id.resultTextView);

        final Button button = root.findViewById(R.id.calculateButton);

        bmiCalculator = new BmiCalculator();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    double bodyMass = Double.parseDouble(bodyMassText.getText().toString());
                    double height = Double.parseDouble(heightText.getText().toString());
                    double bmi = bmiCalculator.calculate(bodyMass, height);
                    resultTextView.setText(String.valueOf(bmi));
                } catch (NumberFormatException e) {
                    resultTextView.setText("provide data first");
                }
            }
        });

        WebView webView = root.findViewById(R.id.bmiChartWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/bmi_chart.html");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}