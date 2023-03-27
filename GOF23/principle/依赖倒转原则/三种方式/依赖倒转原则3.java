package com.lidadaibiao.JUC.GOF23.principle.依赖倒转原则.三种方式;

import com.lidadaibiao.JUC.GOF23.principle.依赖倒转原则.三种方式.TCL;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 16:40
 * @Description :1:依赖倒转原则 有三种实现方式--》
 *              （1）接口方式传递
 *              （2）通过构造方法传递
 *              （3）通过setter方法传递
 */
public class 依赖倒转原则3 {

  public static void main(String[] args) {
    //通过接口传递
//    OpenAndClose openAndClose = new OpenAndClose();
    TCL tcl = new TCL();
//    tcl.play();
    //通过构造方法传递
//    OpenAndClose openAndClose =new OpenAndClose(tcl);
//    openAndClose.open();
    //通过setter方法传递
    OpenAndClose openAndClose = new OpenAndClose();
    openAndClose.setTv(tcl);
    openAndClose.open();
  }
}
/**
 *   通过TV 开关进行举例
 */
// 1 通过接口传递
//interface IOpenAndClose{
//  public void open(ITV itv);
//}
//interface ITV{
//  public void play();
//}
//class OpenAndClose implements IOpenAndClose{
//
//  @Override
//  public void open(ITV itv) {
//      itv.play();
//  }
//}

//通过构造方法
//interface IOpenAndClose{
//  public void open();
//}
//interface ITV {
//  public void play();
//}
//
//class OpenAndClose implements IOpenAndClose{
//  public ITV itv;
//  public OpenAndClose(ITV itv){
//    this.itv=itv;
//  }
//
//  @Override
//  public void open() {
//    this.itv.play();
//  }
//}
//通过setter方法
interface IOpenAndClose{
  public void open();
  public void setTv(ITV itv);
}
interface ITV {
  public void play();
}
class OpenAndClose implements IOpenAndClose{
  public ITV itv;
  @Override
  public void setTv(ITV itv) {
    this.itv=itv;
  }
  @Override
  public void open() {
    this.itv.play();
  }
}
class TCL implements ITV{
  @Override
  public void play() {
    System.out.println("打开TCL");
  }
}