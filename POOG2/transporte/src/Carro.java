public class Carro {

    public Carro() {
    }

    public String modelo;
    public String numeroChasis;
    public String placa;
    public String tipoMotor;
    public Integer velocidad;

    public Integer getVelocidades;

    public String getModelo() {
        return modelo;
    }
    public Carro(String modelo, String numeroChasis, String placa, String tipoMotor, Integer velocidad, Integer getVelocidades) {
        this.modelo = modelo;
        this.numeroChasis = numeroChasis;
        this.placa = placa;
        this.tipoMotor = tipoMotor;
        this.velocidad = velocidad;
        this.getVelocidades = getVelocidades;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getGetVelocidades() {
        return getVelocidades;
    }

    public void setGetVelocidades(Integer getVelocidades) {
        this.getVelocidades = getVelocidades;
    }


    public boolean acelerar() {
        return true;
    }

    public boolean bajarVenta() {
        return true;
    }

    public boolean encender() {
        return true;
    }

    public boolean frenar() {
        return true;
    }
    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", numeroChasis='" + numeroChasis + '\'' +
                ", placa='" + placa + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                ", velocidad=" + velocidad +
                ", getVelocidades=" + getVelocidades +
                '}';
    }
}
