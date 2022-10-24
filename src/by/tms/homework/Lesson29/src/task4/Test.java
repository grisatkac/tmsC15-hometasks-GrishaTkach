package task4;

public class Test {

    public static void main(String[] args) {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("a");
        linkedList.add("d");


        System.out.println(linkedList.toString());
        linkedList.add(2, "f");
        System.out.println("--- result after adding element ---");
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
        linkedList.remove(3);
        System.out.println(linkedList);
    }
}
