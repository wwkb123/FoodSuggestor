package yau.tommy.com.foodsuggestor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    Button addBtn;
    Button clearBtn;
    ListView databaseListView;
    ArrayList<String> databaseList;
    ArrayAdapter listAdapter;
    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        myDB = new DataBaseHelper(this);
        initUI();


    }

    public void initUI(){
        addBtn = findViewById(R.id.addBtn);
        clearBtn = findViewById(R.id.clearBtn);

        databaseListView = findViewById(R.id.databaseListView);
        databaseList = myDB.getArrayList();



        listAdapter = new ArrayAdapter<>(this,R.layout.list_item_view,databaseList);
        databaseListView.setAdapter(listAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.insertData("Tommy","Yau","100");
                listAdapter.notifyDataSetChanged();
            }
        });


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.clearAll();
                listAdapter.notifyDataSetChanged();
            }
        });



    }
}
