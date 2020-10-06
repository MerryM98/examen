package com.example.examen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private ListView mListView;
    private List<Modelo> mLista = new ArrayList<>();
    ListView mAdapter;
    Modelo modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);

        mLista.add(new Modelo("mery", "22",R.mipmap.ic_launcher_round));
        mLista.add(new Modelo("Sandra", "25",R.mipmap.ic_launcher));
        mLista.add(new Modelo("Juan", "32",R.mipmap.ic_launcher));
        /*modelo = new Modelo();
        modelo.setEdad("23");
        modelo.setNombre("Pedro");
        modelo.setImage(R.mipmap.ic_launcher_round);
        mLista.add(modelo);*/
        mAdapter = new ListAdapter(MainActivity.this,R.layout.item_row,mLista);
        mListView.setAdapter(mAdapter);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
        Toast.makeText(this, "Elemento:" +position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("nombre",mAdapter.getItem(position).getNombre());
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode == 1 && requestCode == RESULT_OK){

        }
    }
}