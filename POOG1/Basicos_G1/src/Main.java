public class Main {
    /*private static List<Persona> personas = new ArrayList<>();
    private static Scanner tecladoInput = Input.getInstance();

    private static void menu() {
        System.out.println("REGISTRO DE PERSONAS");
        System.out.println("=============================");
        System.out.println("1. Listar");
        System.out.println("2. Registrar");
        System.out.println("3. Buscar");
        System.out.println("4. Editar");
        System.out.println("0. Salir");
        System.out.println("=============================");
        System.out.print("Ingresar opción:");
    }

    private static List<Persona> agregarEstaticamente() {
        Persona persona = new Persona();
        persona.setDni("47259697");
        persona.setNombre("Noe Wilber");
        persona.setApellido("Tipo Mamani");
        persona.setEstatura(1.6);
        persona.setOcupacion("Web Developer");
        persona.setNumeroCelular(997124032);
        personas.add(persona);
        return personas;
    }

    private static void listarPersona() {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());
        }
    }

    private static List<Persona> agregarPersona() {
        Persona persona = new Persona();

        System.out.println("DNI ");
        persona.setDni(tecladoInput.next());

        System.out.println("Nombre ");
        persona.setNombre(tecladoInput.next());

        System.out.println("Apellido");
        persona.setApellido(tecladoInput.next());

        System.out.println("Ocupacion: ");
        persona.setOcupacion(tecladoInput.next());

        System.out.println("Estatura: ");
        persona.setEstatura(tecladoInput.nextDouble());

        System.out.println("Nro Cel: ");
        persona.setNumeroCelular(tecladoInput.nextInt());

        personas.add(persona);
        return personas;
    }

    private static Persona buscarPersona() {
        System.out.println("Ingrese Dni de la persona para buscar: ");
        String dni = tecladoInput.next();
        Persona persona = new Persona();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equals(dni)) {
                System.out.println(personas.get(i).toString());
                persona = personas.get(i);
            }
        }
        return persona;
    }


    private static Persona editarPersona() {
        System.out.println("Ingrese Dni de la persona para buscar y editar: ");
        String dni = tecladoInput.next();
        Persona persona = new Persona();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equals(dni)) {
                System.out.println("Nombre ");
                personas.get(i).setNombre(tecladoInput.next());

                System.out.println("Apellido");
                personas.get(i).setApellido(tecladoInput.next());

                System.out.println("Ocupacion: ");
                personas.get(i).setOcupacion(tecladoInput.next());

                System.out.println("Estatura: ");
                personas.get(i).setEstatura(tecladoInput.nextDouble());

                System.out.println("Nro Cel: ");
                personas.get(i).setNumeroCelular(tecladoInput.nextInt());
                System.out.println(personas.get(i).toString());
                persona = personas.get(i);
            }
        }
        return persona;
    }*/

    public static void main(String[] args) {
        /*agregarEstaticamente();
        int opcion = -1;
        do {
            menu();
            opcion = tecladoInput.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Listar");
                    listarPersona();
                    break;
                case 2:
                    System.out.println("Registrar");
                    agregarPersona();
                    break;
                case 3:
                    System.out.println("Buscar");
                    buscarPersona();
                    break;
                case 4:
                    System.out.println("Editar");
                    editarPersona();
                    break;
                case 0:
                    System.out.println("Salir");
                    break;

            }

        } while (opcion != 0);
*/
    }
}