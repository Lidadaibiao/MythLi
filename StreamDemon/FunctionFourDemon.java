package com.lidadaibiao.JUC.StreamDemon;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Lidadaibiao
 * @date 2020/6/15 - 17:55
 */
public class FunctionFourDemon {
    public static void main(String[] args) {
        //Consumer<T>消费型接口 T为参数类型，返回类型VOID
       /* Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.length());
            }
        };*/
        Consumer<String> consumer = (s)->
        {
            System.out.println(s.length());
        };
        consumer.accept("sssss");
        //Supplier<T>共给型接口，参数类型没有，返回类型为T
     /*   Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "ssss";
            }
        };*/
        Supplier<String> supplier = ()->{
            return "sssss";
        };
        System.out.println(supplier.get());

        //Function(T,R)函数型接口，参数类型T,返回类型T
      /*  Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };*/
        Function<String,Integer> function = (s)->
        {
            return s.length();
        };
        System.out.println(function.apply("sssss"));


        //Predicate<T>断定型接口 参数类型T,返回类型Boolean
     /*   Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
        Predicate<String> predicate = (s)->
        {
            return s.isEmpty();
        };
        System.out.println(predicate.test("sss"));

    }
}
