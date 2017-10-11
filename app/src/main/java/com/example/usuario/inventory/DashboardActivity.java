package com.example.usuario.inventory;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;


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

    //Especificando con LayoutParams: Fila, columna, espaciado y peso.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gdlDashboard = (GridLayout) findViewById(R.id.gdlDashboard);

        //Defino un array de int con los id de las imágenes
        int[] images = {
                R.drawable.chair, R.drawable.closet, R.drawable.cpu,
                R.drawable.inventory, R.drawable.keyboard, R.drawable.monitor,
                R.drawable.mouse, R.drawable.printer, R.drawable.proyector,
                R.drawable.table, R.drawable.whiteboard
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

        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);

            params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            imageView.setLayoutParams(params);
            gdlDashboard.addView(imageView);
        }
    }
}
