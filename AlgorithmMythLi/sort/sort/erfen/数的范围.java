package com.lidadaibiao.JUC.AlgorithmMythLi.sort.sort.erfen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/7/20 23:50
 * @Description :
 */
public class 数的范围 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("输入数组长度");
    //元素个数
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    System.out.println("输入询问个数");
    //询问的个数
    int q = Integer.parseInt(s[1]);
    System.out.println("输入元素数");
    //元素的数
    String[] res = br.readLine().split(" ");
    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(res[i]);
    }

    //循环询问次数
    while( q-- > 0){
      //需要判断的元素
      int k = Integer.parseInt(br.readLine());
      //定义边界点
      int l = 0;
      int r = n-1;
      while(l<r){
        //定义中间值 Mid
        int mid = l+r >>1;
        if(arr[mid] >= k) r = mid;
        else l = mid + 1;
      }
      //如果不存在
      if(arr[l] != k )System.out.print(-1 + " ");
      else{
        System.out.println(l);
        l = 0;
        r = n - 1;
        while(l<r){
          //定义中间值
          int mid = l+r+1 >> 1;
          if(arr[mid]<=k) l = mid+1;
          else r = mid;
        }
        System.out.println(l);
      }

    }
    //根据输入的查询次数 进行查询
    while (q-->0){
      //输入询问的元素
      System.out.println("请输入需要查询的元素");
      int k = Integer.parseInt(br.readLine());

      //定义左右边界下标值
      int l = 0; //最左边下标
      int r = n -1; //最右边下标
      while (l<r){
        int mid = r+l>>1;
        if (arr[mid]>=k) r=mid;
        else l = mid+1;
      }
      if (arr[l] != k) System.out.print(-1);
      else {
        System.out.println(l);
        l = 0;r = n-1;
        while (l<r){
          int mid = r+l+1>>1;
          if (arr[mid]<=k) l=mid;
          else r = mid-1;
        }
        System.out.println(l);
      }


    }


//    //二分查找
//    while (q-->0){
//      //询问的元素
//      System.out.println("输入查询的元素");
//      int k = Integer.parseInt(br.readLine());
//      int l = 0; //最左边下标
//      int r = n-1;//最右边下标
//      //二分模板  1
//      while (l<r){
//        int mid = r+l>>1;
//        if (arr[mid]>=k) r = mid; //mid 可能等于k
//        else l=mid+1;
//      }
//      //无解的情况
//      if (arr[l] != k) System.out.print(-1);
//      //二分模板 2
//      else {
//        System.out.print(l);
//         l = 0;r=n-1;
//        while (l<r){
//          int mid = l+r+1>>1;
//          if (arr[mid]<=k)l=mid;
//          else r=mid-1;
//        }
//        System.out.print(l);
//      }
//

//    }

  }

}
