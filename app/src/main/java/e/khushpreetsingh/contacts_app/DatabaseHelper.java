package e.khushpreetsingh.contacts_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by khushpreet singh on 2018-02-20.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION_NUM = 3;
    public static final String DATABASE_NAME= "cont.db";
    public static final String TABLE_NAME= "contact";
    public final static String KEY_ID="id_key";
    public final static String KEY_NAME="name_key";
    public final static String KEY_PHONE="name_phone";
    public final static String KEY_LastName="name_Lname";
    public final static String KEY_Email="name_Email";

    public DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL( "CREATE TABLE " + TABLE_NAME + " ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +KEY_NAME+" text, "+KEY_LastName+" text,"+KEY_PHONE+" text,"+KEY_Email+" text,"+KEY_PHONE+" text);" );
        db.execSQL( "CREATE TABLE " + TABLE_NAME + "( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME+" text, "+KEY_LastName+" text, "+KEY_PHONE+" text, "+KEY_Email+" text);");
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);  //make a new database
        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVer + " newVersion=" + newVer);
    }
    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("lname",cursor.getString(cursor.getColumnIndex(KEY_LastName)));
            user.put("phone",cursor.getString(cursor.getColumnIndex(KEY_PHONE)));
            user.put("email",cursor.getString(cursor.getColumnIndex(KEY_Email)));

            userList.add(user);
        }
        return  userList;
    }
    public Boolean UpdateData(String name, String lname,String phone,String email, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_NAME, name);
        cVals.put(KEY_LastName, lname);
        cVals.put(KEY_PHONE, phone);
        cVals.put(KEY_Email, email);

        int count = db.update(TABLE_NAME, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  true;
    }
    public void onOpen(SQLiteDatabase db)
    {
        Log.i(DATABASE_NAME, "Database opened");
    }



}

