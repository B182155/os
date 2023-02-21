import java.util.*;
public class fcfs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter num of requests :");
        int n=sc.nextInt();
        int f[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.printf("\nRequest[%d] :",i+1);
            f[i]=sc.nextInt();
        }
        System.out.print("Read/Write arm is at :");
        int RW=sc.nextInt();
        int HM=0,t;
        for(int i=0;i<n;i++){
            if(f[i]>=RW){
                t=f[i]-RW;
            }else{
                t=RW-f[i];
            }
            HM=HM+t;
            RW=f[i];
        }
        System.out.print("\nHead movements :"+HM);
    }
}
