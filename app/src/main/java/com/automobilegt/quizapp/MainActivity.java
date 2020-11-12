package com.automobilegt.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Morocco Quiz");
    }

    public void checkAnswer(View view) {
        int score = 0;
        if(!validateForm()){
            return;
        }else{
            RadioButton radioButtonRabat = findViewById(R.id.q1_radio_rabat);
            if (radioButtonRabat.isChecked()) {
                score += 1;
            }
            RadioButton radioButtonDirham = findViewById(R.id.q2_radio_moroccan_dirham);
            if (radioButtonDirham.isChecked()) {
                score += 1;
            }
            CheckBox checkBoxFast = findViewById(R.id.q3_checkbox_fast);
            CheckBox checkBoxPray = findViewById(R.id.q3_checkbox_pray);
            CheckBox checkBoxRead = findViewById(R.id.q3_checkbox_read_quran);
            CheckBox checkBoxEat = findViewById(R.id.q3_checkbox_eat_a_lot);
            if (checkBoxFast.isChecked() && checkBoxPray.isChecked() && checkBoxRead.isChecked() && !checkBoxEat.isChecked()) {
                score += 1;
            }

            RadioButton radioButtonNo = findViewById(R.id.q4_radio_no);
            if (radioButtonNo.isChecked()) {
                score += 1;
            }

            EditText editText44 = findViewById(R.id.q5_edittext_answer);
            if (editText44.getText().toString().equals("44")) {
                score += 1;
            }
        }

        Toast.makeText(this, "Your Score: " + score + "/5", Toast.LENGTH_SHORT).show();
    }


    private boolean validateForm() {
        boolean valid = true;

        RadioButton radioButtonRabat = findViewById(R.id.q1_radio_rabat);
        RadioButton radioButtonCasablanca = findViewById(R.id.q1_radio_casablanca);
        RadioButton radioButtonMarrakech = findViewById(R.id.q1_radio_marrakech);
        if (!radioButtonRabat.isChecked() && !radioButtonMarrakech.isChecked() && !radioButtonCasablanca.isChecked()) {
            radioButtonRabat.setError("Required.");
            radioButtonCasablanca.setError("Required.");
            radioButtonMarrakech.setError("Required.");
            valid = false;
        } else {
            radioButtonRabat.setError(null);
            radioButtonCasablanca.setError(null);
            radioButtonMarrakech.setError(null);
        }
        RadioButton radioButtonDirham = findViewById(R.id.q2_radio_moroccan_dirham);
        RadioButton radioButtonDollar = findViewById(R.id.q2_radio_moroccan_dollar);
        RadioButton radioButtonRiyal = findViewById(R.id.q2_radio_moroccan_riyal);
        if (!radioButtonDirham.isChecked() && !radioButtonDollar.isChecked() && !radioButtonRiyal.isChecked()) {
            radioButtonDirham.setError("Required.");
            radioButtonDollar.setError("Required.");
            radioButtonRiyal.setError("Required.");
            valid = false;
        } else {
            radioButtonDirham.setError(null);
            radioButtonDollar.setError(null);
            radioButtonRiyal.setError(null);
        }

        CheckBox checkBoxFast = findViewById(R.id.q3_checkbox_fast);
        CheckBox checkBoxPray = findViewById(R.id.q3_checkbox_pray);
        CheckBox checkBoxRead = findViewById(R.id.q3_checkbox_read_quran);
        CheckBox checkBoxEat = findViewById(R.id.q3_checkbox_eat_a_lot);
        if (!checkBoxFast.isChecked() && !checkBoxPray.isChecked() && !checkBoxRead.isChecked() && !checkBoxEat.isChecked()) {
            checkBoxFast.setError("Required.");
            checkBoxPray.setError("Required.");
            checkBoxRead.setError("Required.");
            checkBoxEat.setError("Required.");
            valid = false;
        } else {
            checkBoxFast.setError(null);
            checkBoxPray.setError(null);
            checkBoxRead.setError(null);
            checkBoxEat.setError(null);
        }

        RadioButton radioButtonNo = findViewById(R.id.q4_radio_no);
        RadioButton radioButtonYes = findViewById(R.id.q4_radio_yes);
        if (!radioButtonNo.isChecked() && !radioButtonYes.isChecked()) {
            radioButtonNo.setError("Required.");
            radioButtonYes.setError("Required.");
            valid = false;
        } else {
            radioButtonNo.setError(null);
            radioButtonYes.setError(null);
        }

        EditText editText44 = findViewById(R.id.q5_edittext_answer);
        if (editText44.getText().toString().isEmpty()) {
            editText44.setError("Required.");
            valid = false;
        } else {
            editText44.setError(null);
        }

        if (!valid){
            Toast.makeText(this, "Answer all the questions!", Toast.LENGTH_SHORT).show();
        }
        return valid;
    }
}