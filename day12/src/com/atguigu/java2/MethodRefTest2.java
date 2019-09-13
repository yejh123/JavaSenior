package com.atguigu.java2;/**
 * @author yejh
 * @create 2019-08_21 22:54
 */

import java.util.function.BiPredicate;

/**
 * @program: JavaSenior
 *
 * @description: TODO
 *
 * @author: yejh
 *
 * @create: 2019-08-21 22:54
 **/
public class MethodRefTest2 {
    public static void main(String[] args) {
        ITest iTest = Test::test;
        Test t1 = new Test(10);
        iTest.test(t1,20,30);

        ITest iTest1 = (t, i2, i3) -> System.out.println(t.i+i2+i3);
        iTest1.test(t1,20,30);

        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("abc","abd"));
    }

}

@FunctionalInterface
interface ITest {
    void test(Test t, int i2, int i3);
}
class Test{
     int i;
    public Test(int i) {
        this.i = i;
    }
    public void test(int i1, int i2){
        System.out.println( i + i1 + i2);
    }
}
