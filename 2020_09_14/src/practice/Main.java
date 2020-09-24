package practice;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        int s = 1;
        int[][] arr = {{1,1,1},{1,1,1},{1,0,1}};

        int[][] mark = new int[3][3];
        mark[0][0] = 1;
        numOfPath(s,arr,0,0,mark);
        System.out.println(res);
    }
    private static int res = 0;
    public static void numOfPath(int s,int[][] arr,int i,int j ,int[][] mark){
        if(i==arr.length-1 && j==arr.length-1){
            res++;
            return;
        }
        if(i-s>=0 && arr[i-s][j]==1){
            int[][] tmp = new int[mark.length][mark[0].length];
            tmp[0][0] = 1;
            tmp[i-s][j] = 1;
            numOfPath(s,arr,i-s,j,tmp);
        }
        if(i+s<=arr.length-1 && arr[i+s][j]==1){
            int[][] tmp = new int[mark.length][mark[0].length];
            tmp[0][0] = 1;
            tmp[i-s][j] = 1;
            numOfPath(s,arr,i+s,j,tmp);
        }
        if(j-s>=0 && arr[i][j-s]==1){
            int[][] tmp = new int[mark.length][mark[0].length];
            tmp[0][0] = 1;
            tmp[i-s][j] = 1;
            numOfPath(s,arr,i,j-s,tmp);
        }
        if(j+s<=arr[0].length-1 && arr[i][j+s]==1){
            int[][] tmp = new int[mark.length][mark[0].length];
            tmp[0][0] = 1;
            tmp[i-s][j] = 1;
            numOfPath(s,arr,i,j+s,tmp);
        }
    }
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            map.put(5,0);
            map.put(10,0);
            map.put(20,0);
            for(int i=0; i<n; i++){
                int tmp = in.nextInt();
                if(tmp==5){
                    map.put(tmp,map.get(tmp)+1);
                }else if(tmp==10 && map.get(5)!=0){
                    map.put(tmp,map.get(tmp)+1);
                    map.put(5,map.get(5)-1);

                }else if(tmp==20&&(map.get(5)>=3 || (map.get(5)>=1 && map.get(10)>=1))){
                    if(map.get(5)>=3){
                        map.put(5,map.get(5)-3);
                        map.put(20,map.get(20)+1);
                    }else if(map.get(5)>=1 && map.get(10)>=1){
                        map.put(5,map.get(5)-1);
                        map.put(10,map.get(10)-1);
                        map.put(20,map.get(20)+1);
                    }
                }else{
                    System.out.println(false);
                }
            }

        }
    }



























    //小米
    public static void main2(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            List<String> list = new ArrayList<>();
            while(in.hasNextLine()){
                while(in.hasNextLine()){
                    String input = in.nextLine();
                    list.add(input);
                    if(!input.contains(",")){
                        break;
                    }
                }
            }
            int n = list.size()-1;
            String[] tmp = list.get(0).split(",");
            int m = tmp.length;
            char[][] arr = new char[m][n];
            for(int i=0; i<n; i++){
                tmp = list.get(0).split(",");
                for(int j=0; j<n; j++){
                    arr[n][m] = tmp[j].charAt(0);
                }
            }
            String word = list.get(list.size()-1);
            System.out.println(exist(arr,word));
        }
    }
    private static boolean exist(char[][] arr, String word){
        if(arr==null || arr.length==0){
            return false;
        }
        boolean[][] flg = new boolean[arr.length][arr[0].length];
        boolean res = false;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==word.charAt(0)){
                    res = res || findWord(arr,word,0,i,j,flg);
                }
                if(res){
                    return res;
                }
            }
        }
        return res;
    }
    private static boolean findWord(char[][] arr,String word, int index, int row, int col, boolean[][] flg){
        if(index==word.length()){
            return true;
        }
        if(row>=arr.length || row<0 || col>=arr[0].length || col<0|| word.charAt(index)!=arr[row][col] || flg[row][col]){
            return false;
        }
        flg[row][col] = true;
        if(findWord(arr,word,index+1,row-1,col,flg) ||
                findWord(arr,word,index+1,row,col+1,flg) ||
                findWord(arr,word,index+1,row+1,col,flg) ||
                findWord(arr,word,index+1,row,col-1,flg)){
            return true;
        }
        flg[row][col] = false;
        return false;
    }
}