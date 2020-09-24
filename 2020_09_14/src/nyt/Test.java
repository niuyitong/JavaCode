package nyt;

public class Test {
    public void MaxLength(int[] arr,int k){
        int max = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = arr[i];
            if(sum==k){
                if(1>max){
                    max = 1;
                }
                continue;
            }
            for(int j=i+1; j<arr.length; j++){
                sum += arr[j];
                if(sum<k){
                    continue;
                }else if(sum>k){
                    break;
                }else{
                    if(j-i+1>max){
                        max = j-i+1;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
