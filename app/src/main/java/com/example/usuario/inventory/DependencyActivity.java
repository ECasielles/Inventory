package com.example.usuario.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


import com.example.usuario.inventory.adapter.DependencyAdapter;
import com.example.usuario.inventory.pojo.Dependency;

/**
 * Contiene una lista que se maneja con un Adapter personalizado
 * que contiene distintas dependencias de tipo Dependency
 *
 * @author Enrique Casielles
 * @version 1.0
 * @see ListActivity
 * @see ArrayAdapter
 * @see Dependency
 */
public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Para listas genéricas, heredando de ListActivity,
        //activity_dependency debe tener una lista con id @android:id/list
        //De lo contrario debo crear un objeto ListView y findById.
        setContentView(R.layout.activity_dependency);

        //CASO 1: Adapter no personalizado
        /*adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                DependencyRepository.getInstance().getDependencies());*/

        //CASO 2: Adapter personalizado
        adapter = new DependencyAdapter(this);
        getListView().setAdapter(adapter);
    }
}
