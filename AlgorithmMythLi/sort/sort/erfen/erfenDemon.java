package com.lidadaibiao.JUC.AlgorithmMythLi.sort.sort.erfen;


/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/7/20 23:14
 * @Description : 二分模板
 *
 */
public class erfenDemon {

  public static void main(String[] args) {

  }
  //区间[l,r]被划分成[l,mid]和[mid+1,r]时使用
  public int bsearch_1(int l ,int r){
    while (l<r){
      int mid = l+r >>1;
      if (doCheck(mid)) r= mid; //doCheck()判断mid是否满足某种性质
      else l=mid+1;
    }
    return l;
  }
  //区间[l,r]被划分成[l,mid-1]和[mid,r]时使用
  public int bsearch_2(int l ,int r){
    while (l<r){
      int mid = l+r+1>>1; //+1 的原因是因为 假如l=r      mid = l+r-->r+r/2--->r
      if (doCheck(mid))l=mid;
      else r=mid-1;
    }
    return l;
  }
  //检查满足某种条件
  private boolean doCheck(int mid) {
    return true;
  }
}
