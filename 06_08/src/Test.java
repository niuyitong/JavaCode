class Person{
    int id;
    String name;

    Person(int id, String name){
        this.id = id;
        this.name = name;
    }
}
public class Test {
    //删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        // 使用双指针
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        Person person = new Person(1,"he");
        String str = "aa";
        System.out.println(str.getClass());
        System.out.println(person.getClass());
        int a = 2;
        int[] arr = new int[5];
        System.out.println(arr.getClass());
    }
}
