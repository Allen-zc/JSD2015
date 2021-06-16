package day06;
//方法的演示
public class MethodDemo {
    public static void main(String[] args) {
        //say();

        /*
        //sayHi(); //编译错误，有参则必须传参
        //sayHi(250); //编译错误，参数类型必须匹配
        sayHi("zhangsan"); //String name="zhangsan"
        sayHi("lisi"); //String name="lisi"
         */

        /*
        sayHello("zhangsan",25); //String name="zhangsan",int age=25
        sayHello("lisi",24); //String name="lisi",int age=24
        */

        /*
        double a = getNum(); //getNum()的值就是return后的那个数
        System.out.println(a); //模拟对返回值的后续操作
        */

        /*
        int b = plus(5,6); //-------------------------实参
        System.out.println(b); //模拟对返回值的后续操作

        int m=5,n=6;
        int c = plus(m,n); //传递的是m和n里面的数--------实参
        System.out.println(c); //模拟对返回值的后续操作
        */

        /*
        int[] d = testArray();
        for(int i=0;i<d.length;i++){ //模拟对返回值的后续操作
            System.out.println(d[i]);
        }
        */

        /*
        sayHello("zhangsan",25);
        sayHello("lisi",66);
        */

        a(); //方法的嵌套调用
    }

    public static void a(){
        System.out.println(111);
        b();
        System.out.println(222);
    }
    public static void b(){
        System.out.println(333);
    }

















    //有参无返回值
    public static void sayHello(String name,int age){
        if(age>=50){ //在某种特定的条件下，提前结束方法
            return;
        }
        System.out.println("大家好，我叫"+name+"，今年"+age+"岁了");
    }









    //无参有返回值
    public static int[] testArray(){
        int[] arr = {23,56,2,8};
        return arr;
    }

    //有参有返回值
    public static int plus(int num1,int num2){ //-------形参
        int num = num1+num2;
        return num; //返回的是num里面的数
        //return num1+num2; //返回num1与num2的和
    }

    //无参有返回值
    public static double getNum(){
        //return "abc"; //编译错误，返回值类型不匹配
        return 8.88; //1)结束方法的执行  2)返回结果给调用方
    }




    //无参无返回值
    public static void say(){
        System.out.println("大家好，我叫WKJ，今年38岁了");
    }
    //有参无返回值
    public static void sayHi(String name){
        System.out.println("大家好，我叫"+name+"，今年38岁了");
    }



}






























