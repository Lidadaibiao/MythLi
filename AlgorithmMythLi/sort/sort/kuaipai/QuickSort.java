package com.lidadaibiao.JUC.AlgorithmMythLi.sort.sort.kuaipai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/7/19 9:24
 * @Description : 快排模板，分治法。  输入一个数字数量，输入一个数组  例如：5  数组：3 4 1 2 0 进行排序
 */
public class QuickSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //拿到输入的数组数量
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    //获取输入的数组
    String[] strs = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strs[i]);
    }

    quickSort(arr, 0, arr.length - 1);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void quickSort(int[] arr, int l, int r) {
   if (l>=r) return;

   //定义一个中间值
   int x =arr[l+r>>1];

   //定义双指针
    int i = l-1;
    int j = r+1;

    while (i<j){
      //如果 i 这边的都小于x 则i 向前移动
      do i++; while (arr[i]<=x);
      //如果 j 这边的都大于x 则j 向后移动
      do j --; while (arr[j]>x);

      if (i<j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
      }

    }
    quickSort(arr,l,j);
    quickSort(arr,j+1,r);


  }
}
