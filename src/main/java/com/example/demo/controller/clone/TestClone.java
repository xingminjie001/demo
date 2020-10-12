package com.example.demo.controller.clone;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-08-27 17:39
 */
public class TestClone {
    public static void main(String[] args) throws Throwable,Exception {
        // 赋值
        Student codeSheep = new Student();
        Student codePig = codeSheep;
        System.out.println(codePig == codeSheep);
        // 浅拷贝·············
        Major m = new Major("计算机科学与技术",666666);
        Student student1 = new Student( "CodeSheep", 18, m );
        // 由 student1 拷贝得到 student2
        Student student2 = (Student) student1.clone();
        student1.finalize();

        System.out.println( student1 == student2 );
        System.out.println( student1 );
        System.out.println( student2 );
        System.out.println( "\n" );

        // 修改student1的值类型字段
        student1.setAge( 35 );

        // 修改student1的引用类型字段
        m.setMajorName( "电子信息工程" );
        m.setMajorId( 888888 );

        System.out.println( student1 );
        System.out.println( student2 );

    }
}
