package com.example.usuario.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.usuario.inventory.pojo.Dependency;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Actividad que muestra los distintos inventarios y sus iconos.
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */

public class DashboardActivity extends AppCompatActivity {

    private GridLayout gdlDashboard;

    int[] images = {
            R.drawable.ic_format_list_bulleted_type,
            R.drawable.ic_archive,
            R.drawable.ic_map_marker_multiple,
            R.drawable.ic_locker_multiple,
            R.drawable.ic_format_indent_increase
    };

    //Buscar una forma más elegante de hacerlo
    HashMap<String, Integer> imgsId = new HashMap<>();

    //Especificando con LayoutParams: Fila, columna, espaciado y peso.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);
        gdlDashboard = (GridLayout) findViewById(R.id.gdlDashboard);

        final int INVENTARIO = View.generateViewId();
        final int PRODUCTO = View.generateViewId();
        final int DEPENDENCIAS = View.generateViewId();
        final int SECCION = View.generateViewId();
        final int PREFERENCIAS = View.generateViewId();

        int[] viewIds = {
                INVENTARIO,
                PRODUCTO,
                DEPENDENCIAS,
                SECCION,
                PREFERENCIAS
        };

        //Definir un array de ImageView

        //No se utiliza en Java/Android array de objetos (sí con tipos primitivos)
        //Se utiliza Vector o colecciones
        //ImageView[] imageViews = new ImageView[images.length];

        //No implementamos la clase Vector porque no trabajamos con hilos
        //Y no se requiere sincronización
        //Vector<ImageView> vectorImageViews = new Vector<ImageView>();

        //El ArrayList debe ser parametrizado
        /*ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();
        for (int i = 0; i < images.length; i++) {
            arrayImageViews.add(new ImageView(this));
            if (arrayImageViews.get(i) instanceof ImageView)
                ((ImageView) arrayImageViews.get(i)).setImageResource(images[i]);
        }*/

        //Debemos evitar la costumbre de crear un ArrayList siempre
        //GridLayout ya nos permite agregar los elementos vista como colección

        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);
        ImageView imageView;
        GridLayout.LayoutParams params;

        //Creamos los elementos de forma dinámica
        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);

            //Asigna Id y recurso al ImageView
            imageView.setId(viewIds[i]);
            imageView.setImageResource(images[i]);

            params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            //imageView.setLayoutParams(params);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = null;

                    if(v.getId() == INVENTARIO)
                        intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    if(v.getId() == PRODUCTO)
                        intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    if(v.getId() == DEPENDENCIAS)
                        intent = new Intent(DashboardActivity.this, DependencyActivity.class);

                    if (intent != null) startActivity(intent);
                }
            });
            gdlDashboard.addView(imageView, params);
        }
    }

}
