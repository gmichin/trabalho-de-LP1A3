public class Voo {
    private Aviao aeronave;
    private int nro;
    private String data;
    private String hora;

    public Voo(Aviao aeronave, int nro, String data, String hora){
        this.aeronave = aeronave;
        this.nro = nro;
        this.data = data;
        this.hora = hora;
    }

    public void setAviao(int fileira, int assento, Passageiro passageiro){
        this.aeronave.lugares[fileira][assento] = passageiro;
    }

    public boolean verificaLugarOcupado(int lugarFil, int lugarAss){
        return this.aeronave.verificaLugarOcupado(lugarFil, lugarAss);
    }

    public Passageiro getPassageiro(int lugarFil, int lugarAss) {
        return aeronave.lugares[lugarFil][lugarAss];
    }


    public int getNro() {
        return nro;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
}
