public class Main {
    public static void main(String[] args) {
        AnnotationTracker at = new AnnotationTracker();
        at.add(5, "Clarify this sentence");
        at.add(2, "Check data consistency");
        at.add(7, "Expand background section");
        at.add(5, "Duplicate");
        System.out.println(at.peekEarliest());
        System.out.println(at.getSortedIds());
        System.out.println(at.exists(7));
        System.out.println(at.removeEarliest());
        System.out.println(at.size());
        System.out.println(at.exists(3));
        at.add(10, "summarize findings");
        System.out.println(at.removeById(7));
        System.out.println(at.size());
        at.add(1, "fix typo");
        at.clear();
        System.out.println(at.size());
    }
}
