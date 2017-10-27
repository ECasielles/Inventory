package com.example.usuario.inventory.repository;

import com.example.usuario.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Clase repositorio que genera los datos Dependency
 * como ArrayList de objetos Dependency
 * con un elemento único gracias al patrón singleton que
 * garantiza que la instancia de datos sea única y pública
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see ArrayList
 * @see Dependency
 */

public class DependencyRepository {

    /*DECLARACIÓN*/
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /*INICIALIZACIÓN*/
    //De esta forma inicializa los atributos de ámbito estático o de clase
    //Es la forma alternativa aunque puede ser costoso y se puede evitar
    static {
        dependencyRepository = new DependencyRepository();
    }
    /**
     * Constructor privado que garantiza una instancia única de la clase
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /*MÉTODOS*/

    /**
     * Inicializa la estructura de datos DependencyRepository
     */
    private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
    }
    /**
     * Accesor de la clase DependencyRepository
     * @return Devuelve la instancia de la clase como objeto DependencyRepository
     */
    public static DependencyRepository getInstance(){
        //Nunca va a valer null si no se hace inicialización estática
        /*if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();*/
        return dependencyRepository;
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
