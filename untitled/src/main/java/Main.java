import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Object> set1 = new HashSet<>();
        Set<Object> set2 = new HashSet<>();
        set1.add(set2);
        set2.add(set1);
        System.out.println(set1);
    }
}
