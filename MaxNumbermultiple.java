package com.leetcode;

import java.util.Scanner;

public class MaxNumbermultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("第一个数字");
        String num1 = scanner.nextLine();
        System.out.println("第二个数字");
        String num2 = scanner.nextLine();
       /* String num1 = "123";
        String num2 = "456";*/
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            arr1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
        }
        for (int i = 0; i < num2.length(); i++) {
            arr2[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
        }
        unable(arr1,arr2);
        coverData(arr1);
        coverData(arr2);
        int[] result = multiple(arr1,arr2);
        print(result);
    }
    //将数组的高低位调换
    public static void coverData(int[] arr) {
        int temp = 0;
        for (int i = 0,j = arr.length;i<arr.length/2;i++,j--) {
            temp = arr[i];
            arr[i] = arr[j-1];
            arr[j-1] = temp;
        }
    }
    //乘法运算
    public static int[] multiple(int[] arr1,int[] arr2) {
        int[] result = new int[100];
        for (int i = 0;i<arr1.length;i++) {
            for (int j = 0;j<arr2.length;j++) {
                if(arr1[i]*arr2[j]>=10) {
                    result[j+i+1]+=arr1[i]*arr2[j]/10;
                    result[j+i]+= arr1[i]*arr2[j]%10;
                }else {
                    result[j+i]+= arr1[i]*arr2[j];
                }
                int temp = result[j+i];
                if(temp>=10) {
                    result[i+j] = temp%10;
                    result[i+j+1]+= temp/10;
                }
            }
        }
        return result;
    }
    //异常处理
    public static void unable(int[] arr1,int[] arr2) {
        if((arr1[0]==0&&arr1.length!=1)||(arr2[0]==0&&arr2.length!=1)) {
            System.out.println("输入的数字有错误");
            System.exit(0);
        }
    }
    //结果处理
    public static void print(int[] result) {
        int size = 0,flag=0;
        for (int i = result.length-1;i>=0;i--) {
            if(result[i]!=0) {
                flag = i;
                break;
            }
        }
        for (int i = flag;i>=0;i--) {
            System.out.print(result[i]);
        }
    }
}
