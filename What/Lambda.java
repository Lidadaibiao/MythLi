package com.lidadaibiao.JUC.What;


interface Foo
{
    //void f();
    void f1(int x,int y);

    default void f2(){
        System.out.println("接口里在java8后容许有接口的实现，default方法默认实现2");
    }
    default void f3(){
        System.out.println("接口里在java8后容许有接口的实现，default方法默认实现3");
    }

    static void f4()
    {
        System.out.println("静态方法实现1");
    }
    static int f5(int x,int y){
        System.out.println("静态方法实现2 带参");
        return x*y;
    }


}
/**
 * @author Lidadaibiao
 * @date 2020/6/14 - 14:43
 * 拷贝小括号（），写死右箭头->，落地大括号{...}
 */
public class Lambda {

    public static void main(String[] args) {
     /*   Foo foo = new Foo() {
            @Override
            public void f() {
                System.out.println("lambda表达式，如果一个接口只有一个方法，我可以把方法名省略");
            }
        };*/
        //foo.f();
        /*Foo foo = ()->{
            System.out.println("lambda表达式，如果一个接口只有一个方法，我可以把方法名省略");
        };
        foo.f();*/
        Foo foo = (x,y)->
        {
            System.out.println("带参数的"+(x+y));
        };
        foo.f1(2,3);
        foo.f2();
        foo.f3();
        Foo.f4();
        System.out.println(Foo.f5(2, 4));
    }
}

/**
 * Lamda表达式
 * Lambda 是一个匿名函数，我们可以把 Lambda
     表达式理解为是一段可以传递的代码（将代码
     像数据一样进行传递）。可以写出更简洁、更
     灵活的代码。作为一种更紧凑的代码风格，使
     Java的语言表达能力得到了提升


    Lambda 表达式在Java 语言中引入了一个新的语法元
    素和操作符。这个操作符为 “->” ， 该操作符被称
    为 Lambda 操作符或剪头操作符。它将 Lambda 分为
    两个部分：
    左侧：指定了 Lambda 表达式需要的所有参数
    右侧：指定了 Lambda 体，即 Lambda 表达式要执行
    的功能
    lambda表达式，必须是函数式接口，必须只有一个方法
    如果接口只有一个方法java默认它为函数式接口。
    为了正确使用Lambda表达式，需要给接口加个注解：@FunctionalInterface
    如有两个方法，立刻报错
 
 Runnable接口为什么可以用lambda表达式?因为该接口上面有注解：@FunctionalInterface


 
 接口里在java8后容许有接口的实现，default方法默认实现
 default int div(int x,int y) {
  return x/y;
 }
 接口里default方法可以有几个？多个


 静态方法实现：接口新增
 public static int sub(int x,int y){
 return x-y;
 }
 可以有几个？
 注意静态的叫类方法，能用foo去调吗？要改成Foo
 */
