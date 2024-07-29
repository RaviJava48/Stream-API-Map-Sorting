import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 6);
        map.put("b", 3);
        map.put("c", 9);
        map.put("d", 5);
        map.put("e", 1);

        System.out.println("Original Map: " + map);

        //Sort the map based on values in ASC order using Stream API
        Map<String, Integer> sortedMapAsc = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));
        System.out.println("Sorting in Asc order using Stream API: " + sortedMapAsc);

        //Sort the map based on values in DESC order using Stream API
        Map<String, Integer> sortedMapDesc = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                        ));
        System.out.println("Sorting in Desc order using Stream API: " + sortedMapDesc);

        //Sort the map based on values in ASC order using List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMapAscOrd = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> me: entryList){
            sortedMapAscOrd.put(me.getKey(), me.getValue());
        }
        System.out.println("Sorting in Asc order using List: " + sortedMapAscOrd);

        //Sort the map based on values in DESC order using List
        List<Map.Entry<String, Integer>> entryList1 = new ArrayList<>(map.entrySet());
        entryList1.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<String, Integer> sortedMapDescOrd = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> me: entryList1){
            sortedMapDescOrd.put(me.getKey(), me.getValue());
        }
        System.out.println("Sorting in Desc order using List: " + sortedMapDescOrd);
    }
}
