package com.lidadaibiao.JUC.GOF23.principle.开闭原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/29 23:26
 * @Description :1：改进思路  把创建的Shape做成抽象类，提供一个抽象的draw方法，让子类实现即可
 */
public class 开闭原则2 {

  public static void main(String[] args) {
    GraphicEditor1 graphicEditor1 = new GraphicEditor1();
    graphicEditor1.drawShap(new Crile1());
    graphicEditor1.drawShap(new Rectangle1());
    graphicEditor1.drawShap(new 新增图形1());

  }
}

/**
 * 画图功能
 */
//绘图类
class GraphicEditor1{

  //接收Shape对象，根据type绘制不同的图形
  public void drawShap(Shape1 s){
    s.draw();
  }
}
abstract class Shape1{
  int m_type;
  abstract void draw();//抽象方法
}


class Rectangle1 extends Shape1{
  @Override
  void draw() {
    System.out.println("绘制矩形");
  }
}

class Crile1 extends Shape1{

  @Override
  void draw() {
    System.out.println("绘制圆形");
  }
}

class 新增图形1 extends Shape1{

  @Override
  void draw() {
    System.out.println("绘制新增图形1");
  }
}