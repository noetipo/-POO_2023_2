import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> vehiculos = new ArrayList<>();
        // Adicionar elementos a una lista
        vehiculos.add("Moto");
        vehiculos.add("Camioneta");
        vehiculos.add("Burro");
        vehiculos.add("Avion");
        vehiculos.add("Moto Taxi");
/*
        // Listar elementos
        // for nativo
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.get(i));
        }
        // for recorrido
        System.out.println();
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }*/
        // editar un elemento de la lista
        vehiculos.set(0,"Camello");
        // recorrido con programacion funcional

        // eliminar un elemento de la lista

        vehiculos.remove(4);

        System.out.println();
        vehiculos.forEach(System.out::println);

        // obtener un elemento de la lista
        System.out.println();
        System.out.println(vehiculos.get(2));
    }
}