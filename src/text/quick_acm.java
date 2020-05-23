package text;


import java.util.Scanner;

public class quick_acm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if (n==0){
                System.out.println();
                break;
            }
            int text = 0;
            int[] arr =new int[n];
            int[] temp = new int[n];
            while(n-->0){
                int x=sc.nextInt();
                if (x<0){
                    x=Math.abs(x);
                    temp[text]=x;
                    text++;
                }
                arr[n]=x;
            }
            Qiuck_sort(arr,0,arr.length-1);
            while(text-->0){
                int y=arr[text];
                for (int i=0;i<arr.length;i++){
                    if (arr[i]==y){
                        arr[i]-=arr[i]*2;
                    }
                }
            }
            for (int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    public static void Qiuck_sort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int x = arr[left];
        while (i < j) {
            while (arr[j] < x && i < j) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];//注意i++!!!!!
            }
            while (arr[i] > x && i < j) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = x;
        i--;
        j++;
        if (left < i) {
            Qiuck_sort(arr, left, i);
        }
        if (right > j) {
            Qiuck_sort(arr, j, right);
        }
    }
}
