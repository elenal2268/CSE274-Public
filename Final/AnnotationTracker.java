import java.util.*;

public class AnnotationTracker {
    private LinkedList<Integer> list;
    private HashMap<Integer, String> map;

    public AnnotationTracker() {
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public AnnotationTracker(AnnotationTracker other) {
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        for (Integer i : other.list) {
            this.list.add(i);
        }
        for (Integer i : other.map.keySet()) {
            this.map.put(i, other.map.get(i));
        }

    }

    public void add(int id, String comment) {
        if (!list.contains(id)) { // if list doesn't have id
            list.add(id);
            map.put(id, comment);
        }
    }

    public String removeEarliest() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("No annotations to remove.");
        }
        return map.remove(list.removeFirst());
    }

    public boolean exists(int id) {
        if (map.containsKey(id)) {
            return true;
        }
        return false;
    }

    public String peekEarliest() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("No annotations to remove.");
        }
        return map.get(list.getFirst());
    }

    public int size() {
        return list.size();
    }

    public String removeById(int id) {
        if (list.isEmpty() || !map.containsKey(id)) {
            throw new NoSuchElementException("No annotations to remove.");
        }
        String s = null;

        for (Integer i : list) {
            if (i == id) {
                s = map.get(i);
                list.remove(i);
                map.remove(i);
            }
        }
        return s;
    }

    public List<Integer> getSortedIds() {
        List<Integer> newList = new ArrayList<>();

        for (Integer i : list) {
            newList.add(i);
        }
        return newList;
    }

    public void clear() {
        list.clear();
        map.clear();
    }

}
