import java.util.ArrayList;
import java.util.List;
class A<T> {
    T value;
    A(T value) {
        this.value = value;
    }
    T get() {
        return value;
    }
}
public class TestDemo{
    //力扣1260 二维网格迁移
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        while(k!=0){
            List<Integer> lastCol = new ArrayList<>();
            for(int i = 0;i<n;i++){
                lastCol.add(grid[i][m-1]);
            }
            for(int i = 0;i<n;i++){
                for(int j = m-1;j>0;j--){
                    grid[i][j] = grid[i][j-1];
                }
            }
            for(int i = 1;i<n;i++){
                grid[i][0] = lastCol.get(i-1);
            }
            grid[0][0] = lastCol.get(n-1);
            k--;
        }
        List<List<Integer>> grid3 = new ArrayList<>();
        for(int i = 0;i<n;i++){
            List<Integer> grid2 = new ArrayList<>();
            for(int j = 0;j<m;j++){
                grid2.add(grid[i][j]);
            }
            grid3.add(grid2);
        }
        return grid3;
    }
    //力扣1013 将数组分为和相等的三个部分
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i = 0;i<A.length;i++){
            sum += A[i];
        }
        int ret = sum/3;
        int i = 0;
        int flag = 0;
        sum = 0;
        while(i<A.length){
            sum += A[i];
            if(sum==ret){
                sum = 0;
                flag++;
            }
            i++;
        }
        if(flag==3){
            return true;
        }else{
            return false;
        }
    }
    //力扣题690 员工的重要性
    /*
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        int i = 0;
        for(i = 0;i<employees.size();i++){
            if(employees.get(i).id == id){
                int count = employees.get(i).subordinates.size();
                if(count == 0){
                    return employees.get(i).importance;
                }
                for(int j = 0;j<count;j++){
                    int dirId = employees.get(i).subordinates.get(j);
                    sum += getImportance(employees,dirId);
                }
                sum += employees.get(i).importance;
                return sum;
            }

        }
        return 0;
    }
    */
    public static void main1(String[] args) {
        List<A<Integer>> list = new ArrayList<>();
        list.add(new A<>(10));
        list.add(new A<>(11));
        list.add(new A<>(12));
        System.out.println(list.size());//3
        System.out.println(list.isEmpty());//false
        System.out.println(list.remove(1).get());//11
        System.out.println(list.get(1).get());//12
    }
}