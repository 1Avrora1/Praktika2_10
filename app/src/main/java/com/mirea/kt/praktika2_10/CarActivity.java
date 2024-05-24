package com.mirea.kt.praktika2_10;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarActivity extends AppCompatActivity {
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);}



    @Override
    protected void onResume(){
        super.onResume();
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        ArrayList<Car> cars = dbManager.loadAllCarsFromDatabase();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CarAdapter adapter = new CarAdapter(cars);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
}