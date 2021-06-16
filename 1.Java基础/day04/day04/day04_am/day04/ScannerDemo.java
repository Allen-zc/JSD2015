package day04;
import java.util.Scanner; //1.
//Scanner的演示
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //2.
        System.out.println("请输入年龄:");
        int age = scan.nextInt(); //3.
        System.out.println("请输入商品价格:");
        double price = scan.nextDouble(); //3.
        System.out.println("年龄为:"+age+"，价格为:"+price);
        //创建类ScoreLevel，要求接收用户输入的成绩score(double)，并输出
        //创建类CommandBySwitch，要求接收用户输入的命令command(int)，并输出

    }
}















