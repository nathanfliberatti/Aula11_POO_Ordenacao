public class PaisProva {

    private String pais;
    private String prova;
    private Genero genero;
    private boolean ouro = false;
    private boolean prata = false;
    private boolean bronze = false;

    public PaisProva(String pais, String prova, Genero genero) {
        this.pais = pais;
        this.prova = prova;
        this.genero = genero;
    }

    public void setOuro(boolean ouro) {
        this.ouro = ouro;
    }

    public void setPrata(boolean prata) {
        this.prata = prata;
    }

    public void setBronze(boolean bronze) {
        this.bronze = bronze;
    }

    @Override
    public String toString() {
        return "PaisProva{" +
                "pais='" + pais + '\'' +
                ", prova='" + prova + '\'' +
                ", genero=" + genero +
                ", ouro=" + ouro +
                ", prata=" + prata +
                ", bronze=" + bronze +
                "}\n";
    }
}
