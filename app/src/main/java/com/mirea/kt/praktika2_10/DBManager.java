package com.mirea.kt.praktika2_10;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }
    public boolean SaveCarToDatabase(Car car){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Model",car.getModel());
        cv.put("License_plate",car.getLicense());
        cv.put("Production_year",car.getPrYear());
        long rowId = db.insert("TABLE_CARS",null,cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }
    public ArrayList<Car> loadAllCarsFromDatabase () {
        ArrayList<Car> cars = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_CARS", null, null, null, null, null, null);
        if (dbCursor.moveToFirst()) {
            do {
                String model = dbCursor.getString(dbCursor.getColumnIndexOrThrow("model"));
                String license = dbCursor.getString(dbCursor.getColumnIndexOrThrow("license_plate"));
                int prYear = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("production_year"));
                cars.add(new Car(model, license, prYear));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return cars;
    }
}
