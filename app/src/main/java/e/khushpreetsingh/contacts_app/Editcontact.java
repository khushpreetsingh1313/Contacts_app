package e.khushpreetsingh.contacts_app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Editcontact extends Activity {

    SQLiteDatabase db;
    static Cursor cursor;
    DatabaseHelper helper;
    EditText Name;
    EditText Lname;
    EditText phoneNo;
    EditText Email;
   // private Context ctx;
    Button save_contact;
    Button cancel;

    ArrayList<String> al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcontact);
        //  private Context ctx;

        //ctx = this;
        cancel = (Button) findViewById(R.id.cancel);

        Name = (EditText) findViewById(R.id.NAME);
        Lname = (EditText) findViewById(R.id.LNAME);
        phoneNo = (EditText) findViewById(R.id.PHONE);
        Email = (EditText) findViewById(R.id.EMAIL);
        save_contact = (Button) findViewById(R.id.save);
        helper = new DatabaseHelper(this);
       db = helper.getWritableDatabase();

        cancel.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent secondIntent = new Intent(Editcontact.this, Contactslist.class);
                                                startActivityForResult(secondIntent, 50);

        }
    });

        save_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1 = Name.getText().toString();
                String c2 = Lname.getText().toString();
                String c3 = phoneNo.getText().toString();
                String c4 = Email.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.KEY_NAME, c1);
                contentValues.put(DatabaseHelper.KEY_LastName, c2);
                contentValues.put(DatabaseHelper.KEY_PHONE, c3);
                contentValues.put(DatabaseHelper.KEY_Email, c4);

                db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

             //   db.close();
                Intent secondIntent = new Intent(Editcontact.this, Contactslist.class);
                startActivityForResult(secondIntent, 50);

            }
        });
    }
}

//        public class MyOpenHelper extends SQLiteOpenHelper {
//            public static final int VERSION_NUM = 1;
//            public static final String DATABASE_NAME= "contact.db";
//            public static final String TABLE_NAME= "chat";
//            public final static String KEY_ID="id_key";
//            public final static String KEY_NAME="name_key";
//            public final static String KEY_PHONE="name_phone";
//            public final static String KEY_LastName="name_Lname";
//            public final static String KEY_Email="name_Email";
//
//            public MyOpenHelper(Context ctx) {
//                super(ctx, DATABASE_NAME, null, VERSION_NUM);
//            }
//
//            @Override
//            public void onCreate(SQLiteDatabase db) {
//                db.execSQL( "CREATE TABLE " + TABLE_NAME + " ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +KEY_NAME+" text,"+KEY_LastName+" text,"+KEY_PHONE+" text,"+KEY_Email+" text,"+KEY_PHONE+" text);" );
//                Log.i("ChatDatabaseHelper", "Calling onCreate");
//            }
//            @Override
//            public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
//                db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
//                onCreate(db);  //make a new database
//                Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVer + " newVersion=" + newVer);
//            }
//
//            public void onDowngrade(SQLiteDatabase db, int oldVer, int newVer) // newVer < oldVer
//            {
//                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //delete any existing data
//                onCreate(db);  //make a new database
//            }
//
//            public void onOpen(SQLiteDatabase db) //always gets called
//            {
//                Log.i("DATABASE", "Database opened");
//            }
//        }
//    }


/*
 Name = (EditText) findViewById(R.id.NAME);
         Lname = (EditText) findViewById(R.id.LNAME);
         phoneNo = (EditText) findViewById(R.id.PHONE);
         Email = (EditText) findViewById(R.id.EMAIL);
         helper = new DatabaseHelper(this);


         Button save_contact = (Button)findViewById(R.id.save);

         save_contact.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();

        contentValues.put(DatabaseHelper.KEY_NAME,Name.getText().toString());
        //contentValues.put(DatabaseHelper.KEY_LastName,Lname.getText().toString());
        //contentValues.put(DatabaseHelper.KEY_PHONE,phoneNo.getText().toString());
        //contentValues.put(DatabaseHelper.KEY_Email,Email.getText().toString());

        db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

        db.close();
        Intent secondIntent = new Intent(Editcontact.this,Editcontact.class);
        startActivityForResult(secondIntent,50);
        }


        });
        }
        }
*/