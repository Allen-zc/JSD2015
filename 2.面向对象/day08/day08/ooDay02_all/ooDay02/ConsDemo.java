package oo.day02;
//构造方法的演示
public class ConsDemo {
    public static void main(String[] args) {
        //Student zs = new Student(); //编译错误，有参必须传参
        Student zs = new Student("zhangsan",25,"LF");
        Student ls = new Student("lisi",24,"JMS");
        zs.sayHi();
        ls.sayHi();
    }
}



















