public class Aviao extends Aeronave{
    public Passageiro[][] lugares;

    public Aviao(String modelo, int totalFil, int totalAss) {
        super(modelo);
        int i=0, j=0;
        Aeronave a = new Aeronave(modelo);
        this.lugares = new Passageiro[totalFil][totalAss];
    }
 
    public boolean verificaLugarOcupado(int lugarFil, int lugarAss){
        if(this.lugares[lugarFil][lugarAss]==null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Passageiro getPassageiro(int lugarFil, int lugarAss) {
        return this.lugares[lugarFil][lugarAss];
    }

    public void setPassageiro(int lugarFil, int lugarAss, Passageiro lugares) {
        this.lugares[lugarFil][lugarAss] = lugares;
    }
}
