import java.util.*;
class roundrobin{
	static void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	static void sort(int a[],int b[],int c[],int d[],int n){
		for(int i=0;i<n;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			swap(a,i,min);
			swap(b, i, min);
			swap(c, i, min);
			swap(d, i, min);
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no.of Processes:");
		int n=sc.nextInt();
		int pid[]=new int[n];
		int at[]=new int [n];
		int bt[]=new int[n];
		int rt[]=new int[n];
		int ct[]=new int [n];
		int tat[]=new int[n];
		int wt[]=new int[n];
		System.out.print("Enter AT & BT: ");
		for(int i=0;i<n;i++){
			pid[i]=i+1;
			at[i]=sc.nextInt();
			bt[i]=sc.nextInt();
			rt[i]=bt[i];
		}
		sort(at, bt, pid, rt, n);
		System.out.print("Enter quantum :");
		int qu=sc.nextInt();
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int cpt=at[0];
        int p=0;
        q.add(p);
        int count=0;
        while(count<n){
            if(!q.isEmpty()){
                p=q.poll();
                if(rt[p]>qu){
                    cpt+=qu;
                    rt[p]-=qu;
                    for(int i=p+1;i<n;i++){
                        if(at[i]<=cpt  && rt[i]>0 && !q.contains(i)){
                            q.add(i);
                        }
                    }
                    q.add(p);
                }
                else{ 
                    cpt+=rt[p];
                    rt[p]-=rt[p];
                    ct[p]=cpt;
                    count++;
                }
            }
            else{
                for(int i=p+1;i<n;i++){
                    if(at[i]<=cpt && rt[i]>0){
                        q.add(i);
                    }
                }
            }    
        }
		for(int i=0;i<n;i++)
        {
        	tat[i]=ct[i]-at[i];
           	wt[i]=tat[i]-bt[i];
    	}
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
    }
}			

