package com.example.usuario.inventory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Clase Adapter que maneja dependencias
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see ArrayAdapter
 * @see Dependency
 */
public class DependencyAdapter extends ArrayAdapter<Dependency>{


    /**
     * Constructor de DependencyAdapter
     * @param context Contexto de la actividad.
     */
    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    /**
     * Construye e infla la vista de cada elemento del ArrayList
     *
     * @param position Posición del elemento
     * @param convertView Objeto View que reutilizar cuando haya desplazamiento
     * @param parent Layout contenedor del elemento
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DependencyHolder dependencyHolder;
        View view = convertView;

        //Se realiza las N primeras veces por cada elemento hasta que el N-ésimo llene la pantalla
        if(convertView == null) {
            //1. Obtener el servicio del sistema en el contexto con LayoutInflater
            //De esta forma accedo directamente al servicio específico
            //LayoutInflater inflater = LayoutInflater.from(getContext());

            //Forma no recomendada, porque se obliga al contexto a venir de una actividad
            //LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();

            //Accede de forma genérica al servicio del sistema para que infle la vista del objeto vista
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            //2. Inflar la vista. Crea en memoria el objeto View con todos los widget de item_dependency.xml
            //Con null indica que no hay que introducirlo en un nuevo padre
            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();


            //3. Inicializar las variables a los objetos ya creados de los widget del xml.
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.mliIcon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvElementName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvElementShortName);


            //3.5. Guardar la referencia del objeto como Tag.
            //El Tag es un objeto comodín donde guardo la referencia al objeto
            //De esta forma no se pierde tampoco la referencia a cada objeto creado
            view.setTag(dependencyHolder);

        } else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        //4. Mostrar los datos del ArrayList mediante position.
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());

        return view;
    }

    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txvName, txvShortName;

    }

}
