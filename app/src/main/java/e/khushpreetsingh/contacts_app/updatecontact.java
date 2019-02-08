package e.khushpreetsingh.contacts_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class updatecontact extends Activity {
    Button update;
    DatabaseHelper db;
    EditText editName,editLname,editpHONE ,editemail;
    String n,l,p,e;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatecontact);
        db = new DatabaseHelper(this);
        update = (Button) findViewById(R.id.save);
        UpdateData();
        editName = (EditText)findViewById(R.id.NAME);
        editLname = (EditText)findViewById(R.id.LNAME);
        editpHONE = (EditText)findViewById(R.id.PHONE);
        editemail = (EditText)findViewById(R.id.EMAIL);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(updatecontact.this, Contactslist.class);
                startActivityForResult(secondIntent, 50);

            }
        });
//        editName.setText(n);
//        editLname.setText(l);
//        editpHONE.setText(p);
//        editemail.setText(e);


//       Intent intent = getIntent();
//        n = intent.getExtras().getString("na");
//        l = intent.getExtras().getString("ln");
//        p = intent.getExtras().getString("ph");
//        e = intent.getExtras().getString("em");



    }

    public void UpdateData() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isUpdate = db.UpdateData(
                           editName.getText().toString(),
                            editLname.getText().toString(),editName.getText().toString(),editemail.getText().toString(),editName.getText().toString());
                Intent secondIntent = new Intent(updatecontact.this, Contactslist.class);
                startActivityForResult(secondIntent, 50);

            }
        });
    }



}