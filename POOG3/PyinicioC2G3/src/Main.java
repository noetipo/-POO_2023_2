import basicos.Docente;
import basicos.Estudiante;
import basicos.Persona;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
   /* private static List<Persona> personas = new ArrayList<>();

    private static Scanner teclado = Input.getInstance();

    private static List<Persona> adicionarEstaticamente() {
        Persona persona = new Persona();
        persona.setDni("47259697");
        persona.setNombre("Adan");
        persona.setApellido("Tipo");
        persona.setEstatura(1.6);
        persona.setOcupacion("Web Dev");
        personas.add(persona);
        return personas;
    }

    private static void listarPersonas() {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());

        }
    }

    private static List<Persona> agregar() {
        Persona persona = new Persona();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dni:");
        persona.setDni(scanner.nextLine());

        System.out.println("Nombre: ");
        persona.setNombre(teclado.nextLine());

        System.out.println("Apellido: ");
        persona.setApellido(teclado.nextLine());

        System.out.println("Ocupacion: ");
        persona.setOcupacion(teclado.nextLine());

        System.out.println("Estatura: ");
        persona.setEstatura(teclado.nextDouble());
        personas.add(persona);
        listarPersonas();
        return personas;
    }

    private static Persona buscar() {
        System.out.println("Ingrese DNI para buscar persona: ");

        Scanner scanner = new Scanner(System.in);
        String dni = scanner.nextLine();
        Persona persona = new Persona();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equals(dni)) {
                System.out.println(personas.get(i).toString());
                persona = personas.get(i);
            }
        }
        return persona;
    }

    private static Persona actualizar() {

        System.out.println("Ingrese dni para buscar y actualizar persona: ");
        Scanner scanner1 = new Scanner(System.in);
        String dni = scanner1.nextLine();
        Persona persona = new Persona();

        for (int i = 0; i < personas.size(); i++) {

            if (personas.get(i).getDni().equals(dni)) {
                System.out.println(personas.get(i).toString());

                System.out.println("Nombre: ");
                personas.get(i).setNombre(scanner1.nextLine());

                System.out.println("Apellido: ");
                personas.get(i).setApellido(scanner1.nextLine());

                System.out.println("Ocupacion: ");
                personas.get(i).setOcupacion(scanner1.nextLine());

                System.out.println("Estatura: ");
                personas.get(i).setEstatura(scanner1.nextDouble());
                persona = personas.get(i);
            }
        }
        return persona;
    }

    private static void menu() {
        System.out.println("REGISTRO DE PERSONAS");
        System.out.println("======================");
        System.out.println("1. Listar personas.");
        System.out.println("2. Registrar persona.");
        System.out.println("3. Buscar.");
        System.out.println("4. Actualizar.");
        System.out.println("0. Salir.");
        System.out.println("======================");
        System.out.print("Ingresar opción: ");
    }
*/

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("2011236",
                "Noe",
                "Tipo",
                1.6,
                "Estudiante",
                "2011326",
                "Ing. de sistemas");
        System.out.println(estudiante.toString());

        List<Persona> personas = new ArrayList<>();
        personas.add(estudiante);
        personas.add(new Docente());
        personas.add(new Persona());
        for (Persona persona : personas) {
            System.out.println(persona.saludo());

        }


        /* adicionarEstaticamente();
        listarPersonas();
        Scanner teclado = Input.getInstance();
        int opcion = -1;

        do {
            menu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    listarPersonas();
                    break;
                case 2:
                    agregar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 0:
                    System.out.println("Chau");
                    break;
            }
        } while (opcion != 0);*/

    }


}