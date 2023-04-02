package com.lidadaibiao.JUC.GOF23.principle.迪米特法则;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/2 22:50
 * @Description : 1：一个对象应该对其他对象保持最少的了解
 *                2：类与类关系越密切，耦合度越大
 *                3：迪米特法则又叫最少知道原则，即一个类对自己的依赖的类知道越少越好
 *                也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。
 *                对外除了提供的public方法。不对外泄露任何信息
 *                4:更简单的定义：只与直接的朋友通信
 *              直接朋友：每个对象都会与其他对象通信，只要两个对象之间有耦合关系，我们
 *              就说这两个对象之间是朋友关系。耦合的方法很多，依赖，关联，组合，聚合等。
 *              其中，我们称出现成员变量，方法参数，方法返回值中的类为直接朋友。而
 *              出现在局部变量中的类不是直接的朋友。也就是说，陌生的类最好不要以局部变量
 *              的形式出现在类的内部。
 */
public class 迪米特法则 {

  public static void main(String[] args) {
    //创建一个学校管理对象
    SchoolManager schoolManager = new SchoolManager();
    //输出学院的员工Id和学校总部的员工
    schoolManager.printAllEmployee(new CollegeManage());
  }
}
/**
 * 案例： 有个学校，下属有各个学院和总部，现要求打印出学校总部员工ID和学院员工的ID
 */
//学校总部员工
class Employee {
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
//学院员工
class CollegeEmployee{
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
//管理学院员工管理类
class CollegeManage{

  /**
   *
   * @return  返回学院所有员工
   */
  public List<CollegeEmployee> getAllEmployee(){
    List<CollegeEmployee> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      CollegeEmployee emp = new CollegeEmployee();
      emp.setId("学院员工Id="+i);
      list.add(emp);
    }
    return list;
  }
}
//学校管理类
class SchoolManager{

  /**
   * 返回学校总部员工
   * @return
   */
  public List<Employee> getAllEmployee(){
    List<Employee> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Employee emp = new Employee();
      emp.setId("学校总部Id="+i);
      list.add(emp);
    }
    return list;
  }

  //输出学校总部和学院员工信息的方法
  void printAllEmployee(CollegeManage collegeManage){
    List<CollegeEmployee> allEmployee = collegeManage.getAllEmployee();
    System.out.println("学院员工-----------------------");
    for (CollegeEmployee collegeEmployee : allEmployee) {
      System.out.println(collegeEmployee.getId());
    }
    System.out.println("学校总部员工--------------------");
    List<Employee> allEmployee1 = this.getAllEmployee();
    for (Employee employee : allEmployee1) {
      System.out.println(employee.getId());
    }
  }
}

/**
 * SchoolManager:
 *              直接朋友:  Employee（方法返回值）   CollegeManage（方法参数）
 *              间接朋友：  CollegeEmployee 是一个陌生类
 *
 */