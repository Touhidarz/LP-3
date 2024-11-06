import java.util.*;

public class Knapsack01 {
    public static int knapsack(int[] weight, int[] values, int capacity){
        int n = values.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i=1; i<=n; i++){
            for(int w=0; w<=capacity; w++){
                if(weight[i-1] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1]+dp[i-1][w-weight[i-1]]);
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String args[]){
        int [] weight = {2,3,5,7,1,4,1};
        int [] values = {10,5,15,7,6,18,3};
        int capacity = 15;

        int result = knapsack(weight, values, capacity);

        System.out.println("Result : " + result);
    }
}
