package com.lidadaibiao.JUC.AlgorithmMythLi.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/7/19 11:47
 * @Description : 第K个数
 * 给定一个长度为 n的整数数列，以及一个整数 k 请用快速选择算法求出数列从小到大排序后的第 k个数。
 * 输入格式
 * 第一行包含两个整数 n 和 k。第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。
 * 输出格式
 * 输出一个整数，表示数列的第 k 小数。
 *数据范围
 * 1≤n≤100000 ,1≤k≤n 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 */
public class dikgeshu {

  public static void main(String[] args) throws IOException {
    //输入
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] res1 = br.readLine().split(" ");
    int n = Integer.parseInt(res1[0]);
    int k = Integer.parseInt(res1[1]);

    String[] res2 = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(res2[i]);
    }
    quickSort(arr,0,arr.length-1);

    System.out.println(arr[k-1]);
  }

  private static void quickSort(int[] arr, int l, int r) {
    //临界值 抛出
    if (l>=r) return;

    //取随机值  l+r /2 下标的值
    int x = arr[l+r>>1];

    int i = l-1;
    int j = r+1;

    while (i<j){
      //如果arr[i] 《x  则 i 继续向前移动
      do i++; while (arr[i]<x);
      //如果arr[j] >x   则 j 继续向后移动
      do j--; while (arr[j]>x);

      //如果满足i < j 则进行 交换 即可
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
