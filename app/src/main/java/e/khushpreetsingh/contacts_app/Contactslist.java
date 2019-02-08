package e.khushpreetsingh.contacts_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Contactslist extends Activity {
    static DatabaseHelper helper;
    ListView lv;
   ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactslist);
        Button add_contact = (Button) findViewById(R.id.button4);
        //call = (ImageView)findViewById(R.id.);
        helper = new DatabaseHelper(this);
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        lv = (ListView) findViewById(R.id.listView1);
        ListAdapter adapter = new SimpleAdapter(Contactslist.this, userList, R.layout.view_contact, new String[]{"name", "lname", "phone", "email"}, new int[]{R.id.name, R.id.lname, R.id.phone, R.id.email});
        lv.setAdapter(adapter);


        add_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(Contactslist.this, Editcontact.class);
                startActivityForResult(secondIntent, 50);
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(Contactslist.this, updatecontact.class);
                startActivityForResult(intent, 50);
              //  String name = intent.getExtras().getString("na");
                //String lnam = intent.getExtras().getString("ln");
                //String phone = intent.getExtras().getString("ph");
                //String email = intent.getExtras().getString("em");

            }

        });
    }
}