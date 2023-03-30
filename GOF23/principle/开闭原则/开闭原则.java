package com.lidadaibiao.JUC.GOF23.principle.开闭原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/29 23:03
 * @Description :1：最基础，最重要的原则
 *               2：软件开发实体如类，模块和函数应该对外扩展开放（对提供方），对修改关闭（对使用方）。
 *               用抽象构建框架，用实现扩展细节。
 *               3：当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码实现变化
 *               4：编程中遵循其他原则，以及使用涉及模式都是为了遵循开闭原则
 */
public class 开闭原则 {

  public static void main(String[] args) {
    GraphicEditor graphicEditor = new GraphicEditor();
    graphicEditor.drawShap(new Rectangle());
    graphicEditor.drawShap(new Crile());
    graphicEditor.drawShap(new 新增图形());
  }
}

/**
 * 画图功能
 */
//绘图类
class GraphicEditor{

  //接收Shape对象，根据type绘制不同的图形
  public void drawShap(Shape s){
    if(s.m_type==1){
      drawRectangle(s);
    }else if (s.m_type==2){
      drawCrile(s);
    }else if (s.m_type==3){
      draw新图像(s);
    }
  }

  public void drawCrile(Shape s) {
    System.out.println("绘制圆形");
  }

  public void drawRectangle(Shape s) {
    System.out.println("绘制矩形");
  }

  public void draw新图像(Shape s) {
    System.out.println("绘制新图像");
  }
}
class Shape{
  int m_type;
}
class Rectangle extends Shape{

  public Rectangle() {
    super.m_type=1;
  }
}
class Crile extends Shape{
  public Crile() {
    super.m_type=2;
  }
}

class 新增图形 extends Shape{
  public 新增图形(){
    super.m_type=3;
  }
}

/**
 * 分析优缺点：
 *         1：好理解，简单易操作
 *         2：违反开闭原则，即对外扩展开放，对修改关闭。当我们新增功能的时候，尽量不修改代码
 *         3：如果我们需要增加一个图形，修改地方较多(新增图形)
 */