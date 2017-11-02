package com.example.usuario.inventory.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.pojo.Sector;
import com.example.usuario.inventory.repository.SectorRepository;

import java.util.ArrayList;


/**
 * Clase Adapter que maneja secciones o armarios de productos.
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see Sector
 * @see RecyclerView.Adapter
 * @see ArrayList
 * @see SectorRepository
 */
public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {

    private ArrayList<Sector> sectors;

    //Arraylist que almacenará las secciones que se hayan modificado en la interfaz y no se hayan
    //guardado aún en la base de datos
    private ArrayList<Sector> modifiedSectors;
    private OnSwitchCheckedChangedListener onSwitchCheckedChangedListener;

    /**
     * Constructor de SectorAdapter. Inicializa el array desde SectorRepository.
     * Se llama cuando SectorActivity se ejecute por primera vez.
     */
    public SectorAdapter() {
        sectors = SectorRepository.getInstance().getSectors();
        this.modifiedSectors = new ArrayList<>();
        onSwitchCheckedChangedListener = new OnSwitchCheckedChangedListener();
    }
    /**
     * Constructor de SectorAdapter. Inicializa el array desde SectorRepository.
     * Se llama cuando SectorActivity se haya recreado desde un cambio de configuración,
     * habiendo salvado su estado dinámico.
     * @param modifiedSectors ArrayList de objetos Parcelable
     */
    public SectorAdapter(ArrayList<Sector> modifiedSectors) {
        sectors = SectorRepository.getInstance().getSectors();
        this.modifiedSectors = modifiedSectors;
        onSwitchCheckedChangedListener = new OnSwitchCheckedChangedListener();
    }

    /**
     * Infla la vista y crea en memoria el objeto ViewHolder.
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Aquí llama a parent.getContext porque parent ya tiene la vista padre
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Infla la vista
        View view = inflater.inflate(R.layout.item_sector, null);
        //Crea el objeto ViewHolder a partir de la vista
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }

    /**
     * Vincula los elementos del ViewHolder a la lista ArrayList y los inicializa
     * @param sectorViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(final SectorViewHolder sectorViewHolder, int position) {
        sectorViewHolder.swtEnabled.setChecked(sectors.get(position).isEnabled());
        sectorViewHolder.swtEnabled.setTag(sectors.get(position));

        sectorViewHolder.txvName.setText(sectors.get(position).getShortname());
        sectorViewHolder.swtEnabled.setOnCheckedChangeListener(onSwitchCheckedChangedListener);
        /*sectorViewHolder.swtEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sectors.get(sectorViewHolder.getAdapterPosition()).setEnabled(isChecked);
            }
        });*/
        if(sectors.get(position).isDefault())
            sectorViewHolder.txvSectorDefault.setText(R.string.txvSectorDefault);
    }

    /**
     * Se crearán tantos elementos SectorViewHolder como elementos haya en
     * el ArrayList definido dentro de la clase
     * @return Cantidad de elementos del array sectors
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }

    /**
     * Devuelve el array de los sectores que el usuario ha modificado
     * cuando la activity estaba visible y que aún no se ha guardado en
     * la base de datos (persistente).     *
     * @return ArrayList de sectores modificados.
     */
    public ArrayList<Sector> getModifiedSectors() {
        return modifiedSectors;
    }


    /**
     * Clase SectorViewHolder que representa cada elemento del RecyclerView
     *
     * @author Enrique Casielles Lapeira
     * @version 1.0
     * @see RecyclerView.ViewHolder
     */
    public static class SectorViewHolder extends RecyclerView.ViewHolder {
        private Switch swtEnabled;
        private TextView txvName, txvSectorDefault;

        public SectorViewHolder(View itemView) {
            super(itemView);
            swtEnabled = (Switch) itemView.findViewById(R.id.swtSector);
            txvName = (TextView) itemView.findViewById(R.id.txvSectorName);
            txvSectorDefault = (TextView) itemView.findViewById(R.id.txvSectorDefault);
        }
    }


    private class OnSwitchCheckedChangedListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            ((Sector) buttonView.getTag()).setEnabled(isChecked);
        }
    }
}
