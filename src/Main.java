import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String caminho = "C:\\Users\\nathan.fliberatti\\Documents\\";
        String arquivo = "reduzido.txt";

        File file = new File(caminho + arquivo);

        Scanner sc = new Scanner(file);

        Map<String, Pais> paises = new HashMap<>();
        Map<PaisChave, PaisProva> paisesProvas = new HashMap<>();

        Genero genero = Genero.misto;

        while(sc.hasNextLine()) {
            String linha = sc.nextLine();

            if (linha.contains("## Masculino")) {
                genero = Genero.masculino;
            } else if (linha.contains("## Feminino")) {
                genero = Genero.feminino;
            } else if (linha.contains("## Misto")) {
                genero = Genero.misto;
            }

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

                //--Parte 2-- Paises / Provas
                PaisChave pcOuro = new PaisChave(paisOuro, modalidade, genero);
                PaisChave pcPrata = new PaisChave(paisPrata, modalidade, genero);
                PaisChave pcBronze = new PaisChave(paisBronze, modalidade, genero);

                if (!paisesProvas.containsKey(pcOuro)) {
                    paisesProvas.put(pcOuro, new PaisProva(paisOuro, modalidade, genero));
                }
                if (!paisesProvas.containsKey(pcPrata)) {
                    paisesProvas.put(pcPrata, new PaisProva(paisPrata, modalidade, genero));
                }
                if (!paisesProvas.containsKey(pcBronze)) {
                    paisesProvas.put(pcBronze, new PaisProva(paisBronze, modalidade, genero));
                }
                paisesProvas.get(pcOuro).setOuro(true);
                paisesProvas.get(pcPrata).setPrata(true);
                paisesProvas.get(pcBronze).setBronze(true);
            }
        }

        List<Pais> listaPaises = new ArrayList<>(paises.values());

        listaPaises.sort(new ComparadorPaises());

        System.out.println(listaPaises);

//        System.out.println(paisesProvas.values());

        //--Sistema de pesquisa
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o país: ");
        String pesqPais = scan.nextLine();
        System.out.print("Digite o prova: ");
        String pesqProva = scan.nextLine();
        System.out.print("Digite o gênero: ");
        String pesqGeneroStr = scan.nextLine();
        Genero pesqGenero = Genero.misto;

        if (pesqGeneroStr.equals("m")) {
            pesqGenero = Genero.masculino;
        } else if (pesqGeneroStr.equals("f")) {
            pesqGenero = Genero.feminino;
        }

        PaisChave pesqChave = new PaisChave(pesqPais, pesqProva, pesqGenero);

        if (paisesProvas.containsKey(pesqChave)) {
            System.out.println(paisesProvas.get(pesqChave));
        } else {
            System.out.println("Pesquisa Inválida");
        }

    }
}