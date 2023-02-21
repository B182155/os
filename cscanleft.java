import java.util.*;
public class cscanleft {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter num of cylinders :");
        int num=sc.nextInt();
        int cn=num*2-1;
        System.out.print("Enter num of requests :");
        int n=sc.nextInt();
        int f[]=new int[n];
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.printf("\nRequest[%d] :",i+1);
            f[i]=sc.nextInt();
        }
        System.out.print("Read/Write arm is at :");
        int RW=sc.nextInt();
        int HM=0,t;
        System.out.println("\nArm should move towards the larger value(Press 1)\nArm should move towards the lower value(Press 0)");
        System.out.print("choose option :");
        int ch=sc.nextInt();
        for(int p=0;p<n;){
            if(ch==1){
                t=cn-RW;
                HM+=t;
                RW=cn;
                ch=1-ch;
            }
            else{
                int max=0,index=-1;
                for(int i=0;i<n;i++){
                    if(f[i]<RW && !a.contains(i) && f[i]>max){
                        max=f[i];
                        index=i;
                    }
                }
                if(index!=-1){
                    t=RW-f[index];
                    HM+=t;
                    RW=f[index];
                    a.add(index);
                    p++;
                }else{
                    t=RW-0;
                    HM+=t;
                    RW=0;
                    ch=1-ch;
                }
            }
        }
        System.out.print("\nHead movements :"+HM);
    }
}


