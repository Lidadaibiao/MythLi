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
public class 迪米特法则2 {

  public static void main(String[] args) {
    //创建一个学校管理对象
    SchoolManager2 schoolManager = new SchoolManager2();
    //输出学院的员工Id和学校总部的员工
    schoolManager.printAllEmployee(new CollegeManage2());
  }
}
/**
 * 案例： 有个学校，下属有各个学院和总部，现要求打印出学校总部员工ID和学院员工的ID
 */
//学校总部员工
class Employee2 {
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
//学院员工
class CollegeEmployee2{
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
//管理学院员工管理类
class CollegeManage2{

  /**
   *
   * @return  返回学院所有员工
   */
  public List<CollegeEmployee2> getAllEmployee(){
    List<CollegeEmployee2> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      CollegeEmployee2 emp = new CollegeEmployee2();
      emp.setId("学院员工Id="+i);
      list.add(emp);
    }
    return list;
  }


  void printAllEmployee(){
    System.out.println("学院员工--------------------");
    List<CollegeEmployee2> allEmployee = this.getAllEmployee();
    for (CollegeEmployee2 employee : allEmployee) {
      System.out.println(employee.getId());
    }
  }
}
//学校管理类
class SchoolManager2{

  /**
   * 返回学校总部员工
   * @return
   */
  public List<Employee2> getAllEmployee(){
    List<Employee2> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Employee2 emp = new Employee2();
      emp.setId("学校总部Id="+i);
      list.add(emp);
    }
    return list;
  }

  //输出学校总部和学院员工信息的方法
  void printAllEmployee(CollegeManage2 collegeManage){
    //将输出学院的员工方法，封装到 CollegeManage2 中去
    collegeManage.printAllEmployee();
    System.out.println("学校总部员工--------------------");
    List<Employee2> allEmployee1 = this.getAllEmployee();
    for (Employee2 employee : allEmployee1) {
      System.out.println(employee.getId());
    }
  }
}

/**
 * SchoolManager2:
 *              直接朋友:  Employee2（方法返回值）   CollegeManage2（方法参数）
 * CollegeManage2:
 *              直接朋友:  CollegeEmployee2（方法返回值）
 *
 */