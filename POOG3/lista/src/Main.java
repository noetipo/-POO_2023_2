import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        // adicionar elementos a una lista
        frutas.add("Mango");
        frutas.add("Manzana");
        frutas.add("Piña");
        frutas.add("Zandia");
        frutas.add("Chirimoya");
        frutas.add("Fresa");
/*
        System.out.println("For Nativo de Java");
        for (int i = 0; i < frutas.size(); i++) {
            System.out.println(frutas.get(i));
        }
        System.out.println();
        System.out.println("For Recorrido");
        System.out.println();
        for (String fruta : frutas) {
            System.out.println(fruta);

        }
        System.out.println();*/
        System.out.println("For programacion funcional");
        // Editar un elemento de una lista
        frutas.set(1,"Uva");
        // Eliminar un elemento de una lista
        frutas.remove(5);
        // listar elementos de una lista
        frutas.forEach(System.out::println);
        System.out.println();
        // optener un elemento por el id
        System.out.println(frutas.get(1));
    }
}