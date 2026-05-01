public class Pais {

    private String nome;
    private int ouro = 0;
    private int prata = 0;
    private int bronze = 0;

    public Pais(String nome) {
        this.nome = nome;
    }

    public int getTamanho() {
        return this.nome.length();
    }

    public void addOuro() {
        this.ouro++;
    }

    public void addPrata() {
        this.prata++;
    }

    public void addBronze() {
        this.bronze++;
    }

    public String getNome() {
        return nome;
    }

    public int getOuro() {
        return ouro;
    }

    public int getPrata() {
        return prata;
    }

    public int getBronze() {
        return bronze;
    }

    @Override
    public String toString() {
        return "\nPais{" +
                "nome='" + nome + '\'' +
                ", ouro=" + ouro +
                ", prata=" + prata +
                ", bronze=" + bronze +
                '}';
    }
}
