package com.lidadaibiao.JUC.GOF23.principle.单一职责原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 17:36
 * @Description :一个类应该只负责一项职责。如：类A负责两个不同的职责，职责1职责2时。
 *                 当我们对职责1需求变更而改动类A的时候，可能会导致职责2错误。比如userDao 只负责user的增删改查。
 */
public class 单一职责原则2 {

  public static void main(String[] args) {
    RoadVehicle roadVehicle = new RoadVehicle();
    roadVehicle.run("汽车");
    WarterVehicle warterVehicle = new WarterVehicle();
    warterVehicle.run("轮船");
    AirVehicle airVehicle = new AirVehicle();
    airVehicle.run("飞机");
  }
}
/**
 * 方案2分析：
 * 1：遵守单一职责原则
 * 2：但是改动大，类分解，也需要改动客户端
 * 3：直接改动vehicle类，改动代码会比较少---》方案3
 */
class RoadVehicle{
  public void run(String vehicleName){
    System.out.println(vehicleName+"在路上跑~~~~~~~~");
  }
}
class WarterVehicle{
  public void run(String vehicleName){
    System.out.println(vehicleName+"在水里游~~~~~~~~");
  }
}
class AirVehicle{
  public void run(String vehicleName){
    System.out.println(vehicleName+"在天上飞~~~~~~~~");
  }
}