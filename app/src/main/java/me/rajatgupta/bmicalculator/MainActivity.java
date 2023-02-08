package me.rajatgupta.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public void clear(View v){
        EditText wt = findViewById(R.id.weight);
        EditText ht = findViewById(R.id.height);
        TextView BMIBlock = findViewById(R.id.Result);
        wt.setText("");
        ht.setText("");
        BMIBlock.setText("");
        BMIBlock.setBackgroundColor(0);
    }
    public void calculate(View v){
        try {
            EditText wt = findViewById(R.id.weight);
            EditText ht = findViewById(R.id.height);
            TextView BMIBlock = findViewById(R.id.Result);
            double wght = Double.parseDouble(wt.getText().toString());
            double hght = Double.parseDouble(ht.getText().toString());
            double BMI = ((double) ((int) (((wght / (hght * hght)) * 1000000))) / 100);
            String BMIText = "BMI: " + BMI;
            BMIBlock.setText(BMIText);
            if(BMI>=18.6&&BMI<=24.9){
                BMIBlock.setBackgroundColor(Color.GREEN);
            }
            else {
                BMIBlock.setBackgroundColor(Color.RED);
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
        catch (Exception e){
            Log.d("Null", "Null");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}