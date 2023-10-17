import clases.Examen;
import clases.Tarea;
import clases.TareaComun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Tarea> tareas = new ArrayList<>();

    private static void menuCrud() {
        System.out.println("======Menu=====");
        System.out.println("Opcion 0: Salir");
        System.out.println("Opcion 1: Listar");
        System.out.println("Opcion 2: Agregar");

    }

    private static List<Tarea> listarTareas() {
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(tareas.get(i).toString());
        }
        return tareas;
    }

    private static void agregarTarea() {
        System.out.println("1: para agragar tarea");
        System.out.println("2: para agragar examen");
        System.out.println("3: para agragar tarea comun");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            tareas.add(new Tarea(tareas.size() + 1,
                    "Tarea",
                    "Descripcion",
                    LocalDate.of(2023, 9, 20),
                    LocalDate.of(2023, 9, 21)));

        } else if (opcion == 2) {

            tareas.add(new Examen(tareas.size() + 1,
                    "Examen",
                    "Descripcion Examen",
                    LocalDate.of(2023, 9, 20),
                    LocalDate.of(2023, 9, 21),
                    "POO"));

        } else if (opcion == 3) {
            tareas.add(new TareaComun(tareas.size() + 1,
                    "TareaComun",
                    "Descripcion TareaComun",
                    LocalDate.of(2023, 9, 20),
                    LocalDate.of(2023, 9, 21),
                    "POO",
                    "A"));

        }


    }

    public static void main(String[] args) {

        int opcion = -1;
        do {
            menuCrud();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Listar");
                    listarTareas();
                    break;
                case 2:
                    System.out.println("Registrar");
                    agregarTarea();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }


        } while (opcion != 0);
    }
}