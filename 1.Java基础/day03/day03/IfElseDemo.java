package day03;
//if...else结构的演示
public class IfElseDemo {
    public static void main(String[] args) {
        //1)偶数、奇数的判断:
        int num = 6; //带数(6,5)
        if(num%2==0){      //if...else练完，再把if那2个各写一次，再去吃饭
            System.out.println(num+"是偶数");
        }else{
            System.out.println(num+"是奇数");
        }
        System.out.println("继续执行...");

        //2)满500打8折，不满500打9折
        double price = 600.0; //带数(600.0，300.0)
        if(price>=500){ //满500
            price*=0.8; //打8折
        }else{ //不满500
            price*=0.9; //打9折
        }
        System.out.println("最终消费金额为:"+price);












        /*
          2.if...else结构：2条路
            1)语法：
                if(boolean){
                  语句块1
                }else{
                  语句块2
                }
            2)执行过程：
                判断boolean的值:
                  若为true，则执行语句块1(整个结束)
                  若为false，则执行语句块2(整个结束)
            3)说明：
                语句块1和语句块2，必走其中之一
         */
    }
}














