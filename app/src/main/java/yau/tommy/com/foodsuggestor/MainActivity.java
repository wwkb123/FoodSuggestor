package yau.tommy.com.foodsuggestor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //UI widgets
    ImageButton takePhotoBtn;
    ImageButton randomFoodBtn;
    Button databaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


    }

    public void initUI(){
         takePhotoBtn = findViewById(R.id.takePhotoBtn);
         randomFoodBtn = findViewById(R.id.randomFoodBtn);

         databaseBtn = findViewById(R.id.databaseBtn);

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


         databaseBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, DatabaseActivity.class);
                 MainActivity.this.startActivity(i);
             }
         });
    }
}
