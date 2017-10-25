package com.example.usuario.inventory;

import android.app.Application;

import com.example.usuario.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Clase singleton (hereda de Application) que contiene los datos
 * @author Enrique Casielles
 * @version 1.0
 * @see android.app.Application
 * @see ArrayList
 * @see Dependency
 */

//IMPORTANTE: Comprobar en el manifest que está name:.InventoryApplication
public class InventoryApplication extends Application {

    ArrayList<Dependency> dependencies;

    public InventoryApplication() {
        dependencies = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));

    }

    /**
     * Método que añade una dependencia
     * @param dependency Dependencia de clase Dependency
     */
    private void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }

    /**
     * Devuelve la referencia al objeto
     * @return referencia al objeto ArrayList
     */
    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
