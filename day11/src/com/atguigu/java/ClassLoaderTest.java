package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author shkstart
 * @create 2019 下午 2:16
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }

    /*
    Properties：用来读取配置文件。

     */
    @Test
    public void test2() throws Exception {

        /*Properties pros =  new Properties();
        //读取配置文件的方式一：
        //此时的文件默认在当前的module下。
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);


        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        InputStream is = cl.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);*/

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);

        String user = properties.getProperty("user");
        System.out.println(user);
    }

    public static void main(String[] args) {
            SingleTon.Test();
    }
}


class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1 = 2;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
    @Test
    public static void Test() {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);

    }

}

