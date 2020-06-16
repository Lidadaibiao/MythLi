package com.lidadaibiao.JUC.StreamDemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UserD
{
    private int id ;
    private String userName;
    private int age;

    public UserD(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
/**
 * 流式计算
 *
 *
 * 题目：
 * 请按照给出数据，找出同时满足以下条件的用户，也即满足以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户用户名按字母倒叙排列的第一个用户。
 * 只输出一个用户名字
 * @author Lidadaibiao
 * @date 2020/6/15 - 17:56
 */
public class StreamDemon1 {

    public static void main(String[] args) {
        UserD u1 = new UserD(11,"a",23);
        UserD u2 = new UserD(12,"b",24);
        UserD u3 = new UserD(13,"c",22);
        UserD u4 = new UserD(14,"d",26);
        UserD u5 = new UserD(16,"e",28);
        List<UserD> list = new ArrayList<>();
        list.add(u1);list.add(u2);list.add(u3);list.add(u4);list.add(u5);

        list.stream().
                filter((u)->{return u.getId()%2==0;}).
                filter((u)->{return u.getAge()>24;}).
                map((u)->{return u.getUserName().toUpperCase();}).
                sorted((o1,o2)->{return o2.compareTo(o1);}).limit(1).forEach(System.out::println);
    }
}
/**
 * 流(Stream) 到底是什么呢？
 * 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
 * “集合讲的是数据，流讲的是计算！
 *
 * 流特点：
 * Stream 自己不会存储元素
 * Stream 不会改变源对象。相反，
 * 他们会返回一个持有结果的新Stream。
 * Stream 操作是延迟执行的。这意味着
 * 他们会等到需要结果的时候才执行。
 **/