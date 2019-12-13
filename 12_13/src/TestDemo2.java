public class TestDemo2 {
    public static void main(String[] args){
        Test List = new Test();
        List.add(0,10);
        List.add(1,20);
        List.add(2,30);
        List.add(0,25);
        List.display();
        System.out.println("pos:"+List.search(3));
        System.out.println(List.getPos(2));
        System.out.println(List.size());
        List.remove(57);
        List.display();
        List.clear();
    }
}

