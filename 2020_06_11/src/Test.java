import java.util.*;

public class Test {
    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = in.nextInt();
            }
            for(int i=0; i<n; i++){
                int tmp = arr[i];
                int j = i-1;
                while(j>=0 && arr[j]>=tmp){
                    j--;
                }
                System.out.print(j+" ");
                j = i+1;
                while(j<n && arr[j]>=tmp){
                    j++;
                }
                if(j==n){
                    System.out.print(-1);
                }else{
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }
    //数组中值出现了一次的数字
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++){
                arr[i] = in.nextInt();
                if(!set.contains(arr[i])){
                    set.add(arr[i]);
                }else{
                    set.remove(arr[i]);
                }
            }

            for(Integer i :set){
                System.out.print(i+" ");
            }
            for(Iterator i = set.iterator();i.hasNext();){
                System.out.println(i.next()+ " ");
            }
        }
    }
}
