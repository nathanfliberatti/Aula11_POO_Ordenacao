import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String caminho = "C:\\Users\\nathan.fliberatti\\Documents\\";
        String arquivo = "Dados_atletismo.txt";

        File file = new File(caminho + arquivo);

        Scanner sc = new Scanner(file);

        Map<String, Pais> paises = new HashMap<>();

        while(sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.charAt(0) != '#') {
                String[] dados = linha.split(",");
                String modalidade = dados[0];
                String paisOuro = dados[1];
                String paisPrata = dados[2];
                String paisBronze = dados[3];

                if (!paises.containsKey(paisOuro)) {
                    paises.put(paisOuro, new Pais(paisOuro));
                }

                if (!paises.containsKey(paisPrata)) {
                    paises.put(paisPrata, new Pais(paisPrata));
                }

                if (!paises.containsKey(paisBronze)) {
                    paises.put(paisBronze, new Pais(paisBronze));
                }

                paises.get(paisOuro).addOuro();
                paises.get(paisPrata).addPrata();
                paises.get(paisBronze).addBronze();
            }
        }

        List<Pais> listaPaises = new ArrayList<>(paises.values());

        listaPaises.sort(new ComparadorPaises());

        System.out.println(listaPaises);

    }
}