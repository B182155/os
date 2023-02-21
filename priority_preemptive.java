import java.util.*;
public class priority_preemptive {
    static void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void sort(int a[],int b[],int p[],int pr[],int tbt[],int n){
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<=a[min]){
                    min=j;
                }
            }
            swap(a,i,min);
            swap(b,i,min);
            swap(p,i,min);
            swap(pr, i, min);
            swap(tbt, i, min);
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter num of process :");
        int n=sc.nextInt();
        int p[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int tbt[]=new int [n];
        int pr[]=new int[n];
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        float tat_sum=0,tat_avg;
        float wt_sum=0,wt_avg;
        System.out.println("Enter Arrival times and Burst times ");
        for(int i=0;i<n;i++){
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
            pr[i]=sc.nextInt();
            tbt[i]=bt[i];
            p[i]=i+1;
        }
        sort(at,bt,p,pr,tbt,n);
        ArrayList<Integer> a=new ArrayList<>();
        int cpt=0;
        int count=0;
        while(count<n){
            int min=0,index=-1;
            for(int i=0;i<n;i++){
                if(at[i]<=cpt && !a.contains(i) && pr[i]>min){
                    min=pr[i];
                    index=i;
                }
            }
            if(index!=-1){
                bt[index]--;
                cpt++;
                if(bt[index]==0){
                    ct[index]=cpt;
                    a.add(index);
                    count++;
                }
            }
            else{
                cpt=at[count];
            }
        }
        for(int i=0;i<n;i++){
            tat[i]=ct[i]-at[i];
            tat_sum=tat_sum+tat[i];
            wt[i]=tat[i]-tbt[i];
            wt_sum=wt_sum+wt[i];
        }
        tat_avg=tat_sum/n;
        wt_avg=wt_sum/n;
        System.out.println("PID\tAT\tBT\tPR\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.printf("\nP%d\t%d\t%d\t%d\t%d\t%d\t%d",p[i],at[i],tbt[i],pr[i],ct[i],tat[i],wt[i]);
        }
        System.out.printf("\ntat avg :%f\nwt avg :%f\n",tat_avg,wt_avg);
    }
}
//6  0 4 4 1 2 5 2 3 6 3 1 10 4 2 9 5 6 7 --> 18 15 14 4 6 12

