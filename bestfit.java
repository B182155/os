import java.util.ArrayList;
import java.util.Scanner;

public class bestfit{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter num of blocks :");
        int n=sc.nextInt();
        int mm[]=new int[n];
        int p[]=new int[n];
        ArrayList<Integer> a=new ArrayList<>();
        System.out.println("Enter sizes of Memory");
        for(int i=0;i<n;i++){
            System.out.printf("Memory[%d] :",(i+1));
            mm[i]=sc.nextInt();
        }
        boolean A=true;
        while(A){
            System.out.print("\nEnter process size :");
            int ch=sc.nextInt();
            int i;
            int min=Integer.MAX_VALUE,index=-1;
            for (i=0;i<n;i++){
                if(ch<=mm[i] && !a.contains(i) && mm[i]<min){
                    min=mm[i];
                    index=i;
                }
            }
            if(index!=-1){
                a.add(index);
                p[index]=ch;
            }
            if(a.size()==n){
                System.out.println("Memory is full");
                A=false;
            }
            if(a.size()!=n && index==-1){
                System.out.println("process size is greater than memory partitions size");
            }
            if(A){
                System.out.print("Press 1 for another process else 0 :");
                int c=sc.nextInt();
                if(c==0){
                    A=false;
                }
            }
        }
        System.out.println("*****************************");
        System.out.println("MS\tPS");
        for(int i=0;i<n;i++){
            if(p[i]==0){
                System.out.println(mm[i]+"\tNot Allocated");
            }else{
                System.out.println(mm[i]+"\t"+p[i]);
            }
        }
        System.out.println("*****************************");

        sc.close();
    }   
}
