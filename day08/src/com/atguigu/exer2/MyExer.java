package com.atguigu.exer2;

import java.io.File;

/**
 * @author yejh
 * @create 2019-07_17 15:40
 */
public class MyExer {
    public static void main(String[] args) {
        delete(new File("C:\\学习\\java\\网课资源\\尚硅谷_康师傅2019新版—30天搞定Java核心技术\\5_代码\\第2部分：Java高级编程\\JavaSenior\\JavaSenior\\day08\\src\\com\\atguigu\\exer2\\a1 - 副本"));
    }

    /*
    删除指定文件目录及其下的文件
     */
    public static void delete(File file){
        if(!file.exists()){
            System.out.println(file + "文件不存在");
            return;
        }
        if(file.isDirectory()){
            File[] child = file.listFiles();
            for(File f:child){
                delete(f);

            }
        }
        System.out.println(file + "删除成功");
        file.delete();
    }

}
