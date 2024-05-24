package com.mirea.kt.praktika2_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextModel, editTextLicense, editTextYear;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        editTextModel = findViewById(R.id.etModel);
        editTextLicense = findViewById(R.id.etLicensePlate);
        editTextYear = findViewById(R.id.etProductionYear);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            if (this.dbManager != null) {
                String model = editTextModel.getText().toString();
                String license = editTextLicense.getText().toString();
                String prYear = editTextYear.getText().toString();
                if (!model.isEmpty() && !license.isEmpty() && !prYear.isEmpty()) {
                    boolean result = dbManager.SaveCarToDatabase(new Car(model, license, Integer.parseInt(prYear)));
                    if (result) {
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
        }else if(v.getId() == R.id.btnNext){
            startActivity(new Intent(this,CarActivity.class));
        }

    }
}