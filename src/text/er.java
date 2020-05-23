package text;

import java.util.Scanner;

public class Main {
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
                    x-=2*x;
                    temp[text]=x;
                    text++;
                }
                arr[n]=x;
            }
            radix(arr);
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
    public static void radix(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (x < arr[i]) {
                x = arr[i];
            }
        }
        int lengmax = (x + "").length();//!!!!!!!!!!!!!!!!
        for (int i = 0, n = 1; i < lengmax; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int dig = arr[j] / n % 10;
                bucket[dig][bucketElementCounts[dig]] = arr[j];
                bucketElementCounts[dig]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int m = 0; m < bucketElementCounts[k]; m++) {
                        arr[index++] = bucket[k][m];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}