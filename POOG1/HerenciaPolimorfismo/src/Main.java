public class Main {
    public static void main(String[] args) {/*
        Estudiante estudiante = new Estudiante("47259697",
                "Noe",
                "Tipo",
                1.6,
                "Informatico",
                "20113362",
                "Ing. de sistemas",
                "Mi cada");
        System.out.println(estudiante.saludar());*/

        Persona persona = new Persona();
        System.out.println(persona.saludar());
        persona= new Estudiante();
        System.out.println(persona.saludar());
        persona= new Docente();
        System.out.println(persona.saludar());
    }
}