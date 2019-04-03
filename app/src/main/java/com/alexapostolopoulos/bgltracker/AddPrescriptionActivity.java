package com.alexapostolopoulos.bgltracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AddPrescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescription);

        //Prescription input fields
        configureTypeSpinner();
        configureFrequencySpinner();
        configureAdviceSpinner();
        EditText x = findViewById(R.id.addPresc_X_editText);
        EditText quantity = findViewById(R.id.addPrescr_quantity_editText);
        EditText notes = findViewById(R.id.addPrescr_notes_editText);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_add,menu);
        return true;
    }

    private void configureTypeSpinner() {
        Spinner typeSpinner = findViewById(R.id.addPrescr_type_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.addPresc_type_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout prescLayout = findViewById(R.id.addPrescr_presc_layout);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                params.weight = 1;
                params.gravity = Gravity.CENTER_VERTICAL;

                switch(parent.getItemAtPosition(position).toString()) {
                    case "General":
                        prescLayout.removeAllViews();
                        TextView nameTextView = new TextView(AddPrescriptionActivity.this);
                        EditText nameInput = new EditText(AddPrescriptionActivity.this);

                        nameTextView.setText("Name");
                        nameTextView.setTextAppearance(R.style.CustomTextTitle);
                        prescLayout.addView(nameTextView, params);

                        nameInput.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                        prescLayout.addView(nameInput,params);
                        break;

                    case "Insulin":
                        prescLayout.removeAllViews();
                        TextView selectInsulinTextView = new TextView(AddPrescriptionActivity.this);
                        Spinner insulinSpinner = new Spinner(AddPrescriptionActivity.this);

                        selectInsulinTextView.setText("Select Insulin");
                        selectInsulinTextView.setTextAppearance(R.style.CustomTextTitle);
                        prescLayout.addView(selectInsulinTextView, params);

                        //Set custom adapter to spinner before adding it to the view and also populate all its fields
                        prescLayout.addView(insulinSpinner);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void configureFrequencySpinner() {
        Spinner freqSpinner = findViewById(R.id.addPrescr_freq_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.addPresc_freq_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freqSpinner.setAdapter(adapter);
        freqSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Do when user presses frequency spinner
                switch(position) {
                    case 0: break;
                    case 1: break;
                    case 2: break;
                    case 3: break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void configureAdviceSpinner() {
        Spinner adviceSpinner = findViewById(R.id.addPrescr_advice_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.addPresc_advice_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adviceSpinner.setAdapter(adapter);
        adviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Do when user presses advice spinner
                switch(position) {
                    case 0: break;
                    case 1: break;
                    case 2: break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
