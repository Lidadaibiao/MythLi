package com.lidadaibiao.JUC.GOF23.principle.单一职责原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 17:32
 * @Description :1：一个类只负责一项职责，如A类负责两个不同的职责，职责1和职责2时
 *               2：当我们对职责1进行变化A类时，可能会进而影响职责2的功能变化。
 *               比如userDao 仅仅只是负责user的增删改查
 */
public class 单一职责原则 {

  public static void main(String[] args) {
    Vehicle vehicle = new Vehicle();
    vehicle.run("摩托车");
    vehicle.run("汽车");
    vehicle.run("游艇");
  }
}

/**
 * 针对交通工具进行举例：
 *                  1：交通工具run方法违反单一职责原则 （它即管理地上跑的，也管理水里，天上的）
 *                  解决方案：可以针对多种交通工具运行方法不同，进行分解成不同的类
 */
class Vehicle{
  public void run(String vehicleName){
    System.out.println(vehicleName+"在路上跑~~~~~~~~");
  }
}
