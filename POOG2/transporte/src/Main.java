public class Main {
    public static void main(String[] args) {
    Carro carro = new Carro();
    carro.setModelo("Hilux");
    carro.setNumeroChasis("M2001215135");
    carro.setPlaca("A2Z-254");
    carro.setTipoMotor("4200");
    carro.setVelocidad(80);
    carro.setGetVelocidades(5);
    System.out.println(carro.toString());


    }
}