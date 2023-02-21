import java.util.ArrayList;
import java.util.Scanner;

public class bankers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nenter num of process :");
        int n=sc.nextInt();
        System.out.print("\nenter num of resources :");
        int r=sc.nextInt();
        int al[][]=new int[n][r];
        int max[][]=new int[n][r];
        int nd[][]=new int[n][r];
        int av[]=new int[r];
        System.out.println("enter the max resourses :");
        for(int i=0;i<n;i++){
            for(int j=0;j<r;j++){
                max[i][j]=sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("enter the allocated resourses :");
        for(int i=0;i<n;i++){
            for(int j=0;j<r;j++){
                al[i][j]=sc.nextInt();
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<r;j++){
                nd[i][j]=max[i][j]-al[i][j];
            }
        }
        System.out.print("enter available :");
        for(int j=0;j<r;j++){
            av[j]=sc.nextInt();
        }
        int i,j;
        ArrayList<Integer> vis=new ArrayList<>();
        for(int p=0;p<n;p++){
            int in=-1;
            for(i=0;i<n;i++){
                if(in==-1){
                    for(j=0;j<r && !vis.contains(i);j++){
                        if(nd[i][j]>av[j]){
                            break;
                        }
                    }
                    if(j==r){
                        in=i;
                    }
                }
                else{
                   break;
                }
            }
            if(in==-1){
                System.out.println("safe sequence is not possible");
                break;
            }
            for(int k=0;k<r;k++){
                av[k]=av[k]+al[in][k];
            }
            vis.add(in);
        }
        System.out.print("safe sequence :");
        for(Integer x:vis){
            System.out.print("P"+x+"-->");
        }
    }
}
