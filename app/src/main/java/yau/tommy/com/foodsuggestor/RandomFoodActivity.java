package yau.tommy.com.foodsuggestor;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RandomFoodActivity extends AppCompatActivity {
    //UI widgets
    EditText startNumEditText;
    EditText endNumEditText;
    TextView resultText;
    Button okBtn;
    ConstraintLayout constraintLayout;

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
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startNumString = startNumEditText.getText().toString();
                String endNumString = endNumEditText.getText().toString();

                closeKeyboard(view);

                if( !(startNumString.equals("")) && !(endNumString.equals(""))){
                    int startNum = Integer.parseInt(startNumString);
                    int endNum = Integer.parseInt(endNumString);

                    if(startNum < endNum){

                        //get a random number
                        Random r = new Random(System.currentTimeMillis());
                        int number = r.nextInt((endNum - startNum)+1) + startNum;
                        resultText.setText(number+"");

                    }else{
                        //error message
                        Toast t = Toast.makeText(RandomFoodActivity.this,"Invalid input",Toast.LENGTH_SHORT);
                        t.show();

                    }
                }
            }
        });


        constraintLayout = findViewById(R.id.randomFoodLayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard(view);
            }
        });
    }


    public void closeKeyboard(View v){
        //================ Hide Virtual Key Board When  Clicking==================//

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

        //======== Hide Virtual Keyboard =====================//
    }
}
