package yau.tommy.com.foodsuggestor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //UI widgets
    ImageButton takePhotoBtn;
    ImageButton randomFoodBtn;
    Button databaseBtn;
    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


    }

    public void initUI(){
         takePhotoBtn = findViewById(R.id.takePhotoBtn);
         randomFoodBtn = findViewById(R.id.randomFoodBtn);
         mySwitch = findViewById(R.id.switch1);

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


         mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 Toast t = Toast.makeText(MainActivity.this,(b?"On":"Off"),Toast.LENGTH_SHORT);
                 t.show();
             }
         });
    }
}
