public class Test2 {
    public static void main(String[] args){
        Test List = new Test();
        List.add(0,5);
        List.add(1,3);
        List.add(2,57);
        List.add(0,57);
        List.display();
        System.out.println("pos:"+List.search(3));
        System.out.println(List.getPos(2));
        System.out.println(List.size());
        List.remove(57);
        List.display();
        List.clear();
    }
}
