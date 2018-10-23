package yau.tommy.com.foodsuggestor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //UI widgets
    ImageButton takePhotoBtn;
    ImageButton randomFoodBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


    }

    public void initUI(){
         takePhotoBtn = findViewById(R.id.takePhotoBtn);
         randomFoodBtn = findViewById(R.id.randomFoodBtn);

         takePhotoBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });


         randomFoodBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, RandomFoodActivity.class);
                 MainActivity.this.startActivity(i);
             }
         });


    }
}
