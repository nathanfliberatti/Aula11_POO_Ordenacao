import java.util.Comparator;

public class ComparadorPaises implements Comparator<Pais> {

    @Override
    public int compare(Pais o1, Pais o2) {
        int diffOuro = o2.getOuro() - o1.getOuro();
        if (diffOuro != 0) {
            return diffOuro;
        }

        int diffPrata = o2.getPrata() - o1.getPrata();
        if (diffPrata != 0) {
            return diffPrata;
        }

        return o2.getBronze() - o1.getBronze();
    }
}
