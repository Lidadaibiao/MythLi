package com.lidadaibiao.JUC.AlgorithmMythLi.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/7/20 8:59
 * @Description : 归并排序：
 * 输入一个数组数量N     输入N个数量的数组
 *
 * 例如： 5    4 1 2 3 5   ----》输出 12345
 *
 *
 *
 */
public class guibingsoft {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("输入一个数组长度");
    int n = Integer.parseInt(br.readLine());
    System.out.println("输入 一个 数组");
    String[] res = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(res[i]);
    }
    //归并
    marge_sort(arr,0,n-1);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }

  }

  /**
   *
   * @param arr
   * @param l
   * @param r
   */
  private static void marge_sort(int[] arr, int l, int r) {
    //临界值抛出
    if (l>=r) return;

    //定义中间下标
    int mid = l+r>>1;

    marge_sort(arr,l,mid);
    marge_sort(arr,mid+1,r);

    //定义一个临时数组
    int[] temp = new int[r-l+1];
    //临时数组下标
    int k = 0;
    int i = l;
    int j = mid+1;
    //i在mid前面，j在r前面
    while (i<=mid&&j<=r){
      if (arr[i]<=arr[j])temp[k++] = arr[i++];
      else temp[k++] = arr[j++];
    }
    //剩下的直接拼在后面
    while (i<=mid)temp[k++] = arr[i++];
    while (j<=r) temp[k++] = arr[j++];

    //将tmep的数据 放到 arr中
    for ( i = l,j = 0;i<=r;i++,j++)arr[i] = temp[j];
  }
}
