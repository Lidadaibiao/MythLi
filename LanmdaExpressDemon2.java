package com.lidadaibiao.JUC;

/**
 * lanmda表达式
 * 函数化编程
 *1 套路口诀 拷贝小括号，写死右箭头，落地大括号
 *2. 需要添加FunctionalInterface注解，但jdk1.8隐式注解了已经
 *3. default
 *4. static
 *
 * @author Lidadaibiao
 * @date 2020/6/10 - 12:24
 *
 *
 *
 */
@FunctionalInterface  //定义为函数化接口 jdk1.8新特性
interface Cooo
{
    /*public int fx(int x,int y);*/
    public void fx();
     default int add(int x,int y)
    {
        return x+y;
    }
    default int add1(int x,int y)
    {
        return x+y;
    }
    public static int mult(int x,int y){
        return x*y;
    }
    public static int mult1(int x,int y){
        return x*y;
    }
}


public class LanmdaExpressDemon2 {


    public static void main(String[] args) {
        //System.out.println("lamda表达式-------------------");
        /*Cooo cooo = (int x,int y) -> {
            System.out.println("comein"); return x+y;
        };
        System.out.println(cooo.fx(2, 3));
        */
        Cooo cooo = ()->{
            System.out.println("拷贝小括号，写死右箭头，落地大括号");
        };
        cooo.fx();

        System.out.println(cooo.add(1, 2));
        System.out.println(Cooo.mult(2, 2));
    }
}
