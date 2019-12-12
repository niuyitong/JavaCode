public class TestDemo {
    //力扣997 找到小镇的法官
    //思路：创建一个一维数组，根据条件一，信赖其他人的都排除，将数组对应位
    // 置的值设为-1；根据条件二，有人被信赖且他没有信赖其他人，则其被
    // 信赖数+1，将数组对应位置的值+1；最后遍历数组，返回值为N-1的索引。
    public static int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
        int[] arr = new int[N+1];
        for(int i = 0;i<N+1;i++){
            arr[i] = 0;
        }
        for(int j = 0;j < trust.length;j++){
            int tmp = trust[j][0];
            arr[tmp] = -1;
        }
        for(int k = 0;k<trust.length;k++){
            int tmp = trust[k][1];
            arr[tmp] = arr[tmp]+1;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==N-1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1,3},{2,3}};
        int ret = findJudge(N,trust);
        System.out.println(ret);
    }
}