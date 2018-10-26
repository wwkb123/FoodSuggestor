package yau.tommy.com.foodsuggestor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Yiu Chung Yau on 10/25/18.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";

    SQLiteDatabase db;
    ArrayList<String> arrayList;
    int id = 0;



//    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
//        super(context, name, factory, version);
//    }

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
        arrayList = new ArrayList<>();
        Cursor cursor = getAllData();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                id++;
                arrayList.add("ID: "+cursor.getString(0)+" "+ cursor.getString(1)+" "+ cursor.getString(2)+" "+ cursor.getString(3)+"\n");
            }while (cursor.moveToNext());

            cursor.close();
        }


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public boolean insertData(String name, String surname, String marks){
        db = this.getWritableDatabase();

//        String id = "0";
//        String query = "SELECT * FROM SQLITE_SEQUENCE";
//        Cursor cursor = db.rawQuery(query, null);
//        if (cursor.moveToFirst()){
//            do{
//                id = cursor.getString(cursor.getColumnIndex("seq"));
//
//            }while (cursor.moveToNext());
//        }
//
//        cursor.close();
        id++;
        arrayList.add("ID: "+id+" "+ name+" "+ surname+" "+ marks+"\n");

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        //db.close();

        return (result==-1)?false:true;
    }

    public Cursor getAllData(){
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME, null);
        return cursor;
    }

    public void clearAll(){
        db.execSQL("DELETE FROM " + TABLE_NAME);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE where name='"+TABLE_NAME+"'");
        arrayList.clear();

        id = 0;

    }

    public void closeDB(){
        db.close();
    }

    public ArrayList getArrayList(){
        return arrayList;
    }
}
