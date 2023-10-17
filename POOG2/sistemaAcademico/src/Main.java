public class Main {
    public static void main(String[] args) {
    Persona persona = new Persona();
    persona.setDni("47259697");
    persona.setEstatura(45.12);
    persona.setNombre("Noe Wilber Tipo Mamani");
    persona.setOcupacion("Web Developer");
    System.out.println(persona.toString());

    Persona persona1= new Persona("5855522",78.20,"Persona 2","Programador");
    System.out.println(persona1.toString());
    }
}