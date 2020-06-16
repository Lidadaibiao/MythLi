package com.lidadaibiao.JUC;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class User
{
    private int id ;
    private String userName;
    private int age;

    public User(int id, String userName, int age) {
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
 *
 * 流式计算
 *
 *
 * 题目：
 * 请按照给出数据，找出同时满足以下条件的用户，也即满足以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户用户名按字母倒叙排列的第一个用户。
 * 只输出一个用户名字
 * @author Lidadaibiao
 * @date 2020/6/14 - 0:29
 */
public class SteamDemon {
    public static void main(String[] args) {

        User user1 = new User(11,"a",23);
        User user2 = new User(12,"b",24);
        User user3 = new User(13,"c",22);
        User user4 = new User(14,"d",28);
        User user5 = new User(16,"e",26);
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5);

   /*     list.stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId()%2==0;
            }
        }).filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge()>24;
            }
        }).map(new Function<User, String>() {

            @Override
            public String apply(User user) {
                return user.getUserName().toUpperCase();
            }
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).limit(1).forEach(System.out::println);*/
        list.stream()
                .filter((u)->{return u.getId()%2==0;})
                .filter((u)->{return u.getAge()>24;})
                .map((u)->{return u.getUserName().toUpperCase();})
                .sorted((o1,o2)->{return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);
    }

}
