package com.example.usuario.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.usuario.inventory.adapter.SectorAdapter;

/**
 * Actividad que maneja el alta de secciones
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */
public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = (RecyclerView) findViewById(R.id.rvwSector);

        //Se comprueba si viene de un estado anterior
        if(savedInstanceState != null) {
            //En caso de que no se tenga un constructor de Parcelable
            //sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
            sectorAdapter = new SectorAdapter(savedInstanceState.getParcelableArrayList("sector"));
        } else
            sectorAdapter = new SectorAdapter();

        //Indicamos el tipo de LayoutManager
        //recyclerSector.setLayoutManager(new LinearLayoutManager(this));
        //Pone los elementos en 2 columnas
        //recyclerSector.setHasFixedSize(true);
        //recyclerSector.setLayoutManager(new GridLayoutManager(this, 2));
        //Del tirón
        recyclerSector.setLayoutManager(new GridLayoutManager(this, sectorAdapter.getItemCount()));
        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        //En algunos casos devuelve true directamente porque es igual
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almacena los sectores que se han modificado en la vista y no han sido guardados
     * para visualizar el estado correcto en onCreate().
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getModifiedSectors());
    }

}
