package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:17
 * @Description :
 * 具体需求：
 *        看一个披萨的项目：要便于披萨种类的扩展，便于维护
 *        1：披萨种类很多（比如：GreekPizz,CheesePizz）
 *        2:披萨的制作有prepare,bake,cut,box
 *        3:完成披萨店订购功能
 */
public class 简单工厂模式 {

}
/**
 * 优缺点：
 *  1：是比较好理解，简单容易操作
 *  2：违反涉及模式OCP原则，即对外扩展开放，对修改关闭。即当我们给类增加新功能的时候，尽量不要修改代码
 *  或者尽可能的少修改代码
 *  3：比如我们要增加一个PIZZA种类，我们会涉及到很多的修改，比如Orderpizze的修改等
 * 改进思路：
 *   分析：修改代码可以接受，但是如果我们在其他地方也有创建Pizze的代码，就意味着也要修改，而创建pizze的代码，
 *   往往有多处。
 *   思路：把创建pizze对象封装到一个类中，这样我们有新的pizze种类时，只需要修改该类就可，其他有创建pizze的代码
 *   就不会影响---》简单工厂模式
 */