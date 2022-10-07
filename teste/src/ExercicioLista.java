import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioLista {
    public static void main(String[] args) {
        List<String> listaNomes = new ArrayList<>();

//        listaNomes = Arrays.asList("Pietro","Joao","Eduardo","Gabi","Pedro");
//        listaNomes = List.of("Pietro","Joao","Eduardo","Gabi","Pedro");
        listaNomes.add("Pietro");
        listaNomes.add("Joao");
        listaNomes.add("Eduardo");
        listaNomes.add("Gabi");
        listaNomes.add("Pedro");
        listaNomes.add("PZetro");
        listaNomes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

//        System.out.println(listaNomes.get(listaNomes.size()-2));
//        System.out.println(listaNomes.get(0));
//        System.out.println(listaNomes.remove(listaNomes.size()-1));
        System.out.println(listaNomes);

    }
}
