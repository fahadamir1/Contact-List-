package com.example.contact_list;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
ArrayList<String> arraylist=new ArrayList<String>();

EditText Name,contact;
ArrayAdapter<String> adapter;
ListView list;

int index=0;

int index1;
Button search,delete,update,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initcomponents();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index1=i;
            }
        });
    }
    public void initcomponents(){
        Name= findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        search=findViewById(R.id.search);
        delete=findViewById(R.id.Delete);
        add=findViewById(R.id.AddNew);
        update=findViewById(R.id.update);
        list=(ListView)findViewById(R.id.listview);
    }
    public void Newuseradd(View view) {
        String name = Name.getText().toString();
        if(name.isEmpty()){
            Toast.makeText(getApplicationContext(), "Write Name to add User", Toast.LENGTH_SHORT).show();
            return;
        }
            arraylist.add(name);
        index++;
         adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraylist);
        list.setAdapter(adapter);
            Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
            Name.setHint("Name");
            Name.setText("");
            contact.setText("");
            contact.setHint("Contact");

    }
    public void deleteItem(View view) {
        int i= list.getCheckedItemPosition();
        arraylist.remove(index1);
        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraylist);
        list.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_SHORT).show();
    }

    public void Update_User(View view) {
        String name=Name.getText().toString();
        arraylist.set(index1,name);
        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraylist);
        list.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "User Updated", Toast.LENGTH_SHORT).show();
    }

    public void Search_User(View view) {
        String name=Name.getText().toString();
        int i=0;
        int count=arraylist.size();
        boolean flag=false;
        while(i<arraylist.size()) {
            if(name.equals(arraylist.get(i))){
                Toast.makeText(getApplicationContext(), "User Found", Toast.LENGTH_SHORT).show();
                flag=true;
                i=0;
                break;
            }
            else if(i==count-1){
                Toast.makeText(getApplicationContext(), "User Not Found", Toast.LENGTH_SHORT).show();
            }
            i++;
        }
    }
}