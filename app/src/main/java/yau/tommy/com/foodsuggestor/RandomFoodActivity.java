package yau.tommy.com.foodsuggestor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

        String startNumString = startNumEditText.getText().toString();
        String endNumString = endNumEditText.getText().toString();

        if( !(startNumString.equals("")) && !(endNumString.equals(""))){
            int startNum = Integer.parseInt(startNumString);
            int endNum = Integer.parseInt(endNumString);

            if(startNum < endNum){

                Random r = new Random(System.currentTimeMillis());
                resultText.setText(r.nextInt((endNum - startNum)+1) + startNum);

            }else{

                Toast t = Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT);
                t.show();

            }
        }
    }

    public void initUI(){

        startNumEditText = findViewById(R.id.startNumEditText);
        endNumEditText = findViewById(R.id.endNumEditText);
        resultText = findViewById(R.id.resultText);

    }
}
