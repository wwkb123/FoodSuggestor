package yau.tommy.com.foodsuggestor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RandomFoodActivity extends AppCompatActivity {
    //UI widgets
    EditText startNumEditText;
    EditText endNumEditText;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_food);

        initUI();


    }

    public void initUI(){

        startNumEditText = findViewById(R.id.startNumEditText);
        endNumEditText = findViewById(R.id.endNumEditText);
        resultText = findViewById(R.id.resultText);

    }
}
