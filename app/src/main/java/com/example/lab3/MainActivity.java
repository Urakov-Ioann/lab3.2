package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button add, replace, btnview, save;
    EditText editname, edittime, editsurname, editpatronymic;
    DatabaseHelper mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.btnadd);
        replace = (Button) findViewById(R.id.btreplace);
        btnview = (Button) findViewById(R.id.btnView);
        save = (Button) findViewById(R.id.btnsave);
        editsurname = (EditText) findViewById(R.id.addsurname);
        editname = (EditText) findViewById(R.id.addname);
        editpatronymic = (EditText) findViewById(R.id.addpatronymic);
        edittime = (EditText) findViewById(R.id.addtime);
        mData = new DatabaseHelper(this);
        DeleteData();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editsurname.setVisibility(View.VISIBLE);
                editname.setVisibility(View.VISIBLE);
                editpatronymic.setVisibility(View.VISIBLE);
                edittime.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(editname.getText().length() == 0 || edittime.getText().length() == 0 || editsurname.getText().length() == 0 || editpatronymic.getText().length() == 0){
                   toastMessage("Поля не должны быть пустыми!");
               }
               else{
                   String surname = editsurname.getText().toString();
                   String name = editname.getText().toString();
                   String patronymic = editpatronymic.getText().toString();
                   String time = edittime.getText().toString();
                   editsurname.setText("");
                   editname.setText("");
                   editpatronymic.setText("");
                   edittime.setText("");
                   mData.addData(surname,name,patronymic,time);
                   editsurname.setVisibility(View.GONE);
                   editname.setVisibility(View.GONE);
                   editpatronymic.setVisibility(View.GONE);
                   edittime.setVisibility(View.GONE);
                   save.setVisibility(View.GONE);
               }
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editsurname.getVisibility() == View.VISIBLE || editname.getVisibility() == View.VISIBLE || editpatronymic.getVisibility() == View.VISIBLE || edittime.getVisibility() == View.VISIBLE || save.getVisibility() == View.VISIBLE){
                    editsurname.setVisibility(View.GONE);
                    editname.setVisibility(View.GONE);
                    editpatronymic.setVisibility(View.GONE);
                    edittime.setVisibility(View.GONE);
                    save.setVisibility(View.GONE);
                }
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editsurname.getVisibility() == View.VISIBLE || editname.getVisibility() == View.VISIBLE || editpatronymic.getVisibility() == View.VISIBLE || edittime.getVisibility() == View.VISIBLE || save.getVisibility() == View.VISIBLE){
                    editsurname.setVisibility(View.GONE);
                    editname.setVisibility(View.GONE);
                    editpatronymic.setVisibility(View.GONE);
                    edittime.setVisibility(View.GONE);
                    save.setVisibility(View.GONE);
                }
                mData.replace("Иванов", "Иван", "Иванович");
            }
        });
    }
    private void toastMessage(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    public void DeleteData() {
        Random random=new Random();
        String[] Names={"Семен","Илья","Андрей","Федор","Максим","Матвей","Данила","Григорий","Давид"};
        String[] Patronymic ={"Семенович","Ильич","Андреевич","Федорович","Максимович","Матвеевич","Данилович","Григорьевич","Давидович"};
        String[] Surnames ={"Семенов","Ильичов","Андреев","Федоров","Максимов","Матвеев","Данилов","Григорьев","Давидов"};
        String[]time={"12:14","13:21","10:10","15:15","23:56","14:32","12:23","14:21"};
        int i=random.nextInt(8);
        mData.DeleteandAdd(0,Surnames[i],Names[i],Patronymic[i],time[i]);
        i=random.nextInt(8);
        mData.DeleteandAdd(1,Surnames[i],Names[i],Patronymic[i],time[i]);
        i=random.nextInt(8);
        mData.DeleteandAdd(1,Surnames[i],Names[i],Patronymic[i],time[i]);
        i=random.nextInt(8);
        mData.DeleteandAdd(1,Surnames[i],Names[i],Patronymic[i],time[i]);
        i=random.nextInt(8);
        mData.DeleteandAdd(1,Surnames[i],Names[i],Patronymic[i],time[i]);
    }
}
