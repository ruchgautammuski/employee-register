package com.example.myapplication.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.model.Employee;

import java.util.ArrayList;

public class DbEmployeeHandler extends SQLiteOpenHelper {


    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "employee_database";
    private static final String TABLE_EMPLOYEE = "employee";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DOB = "dob";
    private static final String KEY_DESIGNATION = "degination";
    private static final String KEY_YOE = "year of experience";
    private static final String KEY_ADDRESS  = "address";


    public DbEmployeeHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_DOB + " TEXT,"
                + KEY_DESIGNATION + " TEXT,"
                + KEY_YOE + " TEXT,"
                + KEY_ADDRESS + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        // Create tables again
        onCreate(db);
    }

    public void insertEmployee(String name, String dob, String degination, String yoe, String address ){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("degination", degination);
        contentValues.put("yoe", yoe);
        contentValues.put("address", address);


        long newRow = db.insert(TABLE_EMPLOYEE, null, contentValues);
        db.close();


    }

    public ArrayList<Employee> getAllEmployee(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Employee> notasList = new ArrayList<>();

        String query = "SELECT * FROM "+TABLE_EMPLOYEE+ " ORDER BY "+KEY_ID+" DESC";
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(query, null);


        while(cursor.moveToNext()){

            @SuppressLint("Range") Employee employee = new Employee(
                    cursor.getString(cursor.getColumnIndex(KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(KEY_NAME)),
                    cursor.getString(cursor.getColumnIndex(KEY_DOB)),
                    cursor.getString(cursor.getColumnIndex(KEY_DESIGNATION)),
                            cursor.getString(cursor.getColumnIndex(KEY_YOE)),
                            cursor.getString(cursor.getColumnIndex(KEY_ADDRESS))
            );

            notasList.add(employee);

        }


        return notasList;
    }



//    public void deleteNota(String nota_id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NOTAS, KEY_ID+" = ?", new String[]{nota_id});
//        db.close();
//    }
//
//    public int deleteAllNotas(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete (TABLE_NOTAS, String.valueOf (1), null);
//    }
//
//
//    public int updateNota(String nota_id, String name, String description, String status){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("description", description);
//        contentValues.put("status", status);
//
//        return db.update(TABLE_NOTAS, contentValues, KEY_ID+" = ?",new String[]{nota_id});
//    }
//
//    public int updateStatus(String status, String nota_id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("status", status);
//        return db.update(TABLE_NOTAS, contentValues, KEY_ID+" = ?",new String[]{nota_id});
//    }
}
