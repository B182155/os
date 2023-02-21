import java.util.*;
public class sjf {
    static void swap(int a[],int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    static void sort(int a[],int b[],int p[],int n){
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            swap(a,i,min);
            swap(b,i,min);
            swap(p,i,min);
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter num of process :");
        int n=sc.nextInt();
        int p[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        float tat_sum=0,tat_avg;
        float wt_sum=0,wt_avg;
        System.out.println("Enter Arrival times and Burst times ");
        for(int i=0;i<n;i++){
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
            p[i]=i+1;
        }
        sort(at,bt,p,n);
        ArrayList<Integer> a=new ArrayList<>();
        int cpt=at[0];
        int count=0;
        while(count<n){
            int max=9999,index=-1;
            for(int j=0;j<n;j++){
                if(at[j]<=cpt && !a.contains(j) && bt[j]<max){
                    max=bt[j];
                    index=j;
                }
            }
            if(index!=-1){
                ct[index]=cpt+bt[index];
                cpt=ct[index];
                a.add(index);
                count++;
            }
            else{
                cpt=at[count];
            }
        }
        for(int i=0;i<n;i++){
            tat[i]=ct[i]-at[i];
            tat_sum=tat_sum+tat[i];
            wt[i]=tat[i]-bt[i];
            wt_sum=wt_sum+wt[i];
        }
        tat_avg=tat_sum/n;
        wt_avg=wt_sum/n;
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.printf("\nP%d\t%d\t%d\t%d\t%d\t%d",p[i],at[i],bt[i],ct[i],tat[i],wt[i]);
        }
        System.out.printf("\ntat avg :%f\nwt avg :%f\n",tat_avg,wt_avg);
    }
}
//7   0 6 0 3 1 4 2 2 3 1 4 5 6 2  ---->23 3 12 6 4 17 8
