import java.util.*;

public class fabo {
    public static int Rfabonacci(int num){
        if(num<=1){
            return num;
        }
        else{
            return Rfabonacci(num - 1) + Rfabonacci(num - 2);
        }
        
    }

    public static void NRfibonacci(int num){
        int a = 0, b = 1, c ;

        System.out.print(a+" "+b+" ");
        for(int i=2; i<num; i++){
            c = a+b;
            a = b;
            b = c;
            System.out.print(c+ " ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Recursive Fabaonacci series : ");
        for(int i=0; i<10; i++){
            System.out.print(Rfabonacci(i) + " ");

        }

        System.out.println();
        NRfibonacci(10);

        sc.close();
    }
}
