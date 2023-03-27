package com.lidadaibiao.JUC.GOF23.principle.单一职责原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 17:59
 * @Description :
 */
public class 单一职责原则3 {

  public static void main(String[] args) {
    Vehicle2 vehicle2 = new Vehicle2();
    vehicle2.airVehicle("飞机");
    vehicle2.runVehicle("汽车");
    vehicle2.warterVehicle("轮船");
  }
}

class Vehicle2{
  public void runVehicle(String vehicleName){
    System.out.println(vehicleName+"在路上跑~~~~");
  }

  public void warterVehicle(String vehicleName){
    System.out.println(vehicleName+"在水里游~~~~");
  }

  public void airVehicle(String vehicleName){
    System.out.println(vehicleName+"在天上飞~~~~");
  }
}
