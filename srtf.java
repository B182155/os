import java.util.*;
public class srtf {
    static void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void sort(int a[],int b[],int p[],int t[],int n){
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
            swap(t, i, min);
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
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        float tat_sum=0,tat_avg;
        float wt_sum=0,wt_avg;
        System.out.println("Enter Arrival times and Burst times ");
        for(int i=0;i<n;i++){
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
            tbt[i]=bt[i];
            p[i]=i+1;
        }
        sort(at,bt,p,tbt,n);
        ArrayList<Integer> a=new ArrayList<>();
        int cpt=0;
        int count=0;
        while(count<n){
            int max=9999,index=-1;
            for(int i=0;i<n;i++){
                if(at[i]<=cpt && !a.contains(i) && bt[i]<max){
                    max=bt[i];
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
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.printf("\nP%d\t%d\t%d\t%d\t%d\t%d",p[i],at[i],tbt[i],ct[i],tat[i],wt[i]);
        }
        System.out.printf("\ntat avg :%f\nwt avg :%f\n",tat_avg,wt_avg);
    }
}

//6  0 6 1 4 2 1 3 2 4 1 5 3  --> 17 9 3 5 6 2


