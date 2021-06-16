package day06;
import java.util.Arrays;
//数组的演示
public class ArrayDemo {
    public static void main(String[] args) {
        //8)数组的排序:
        int[] arr = {25,76,34,18,1};    //练习-------11:37继续
        Arrays.sort(arr); //对arr进行升序排列
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("倒着输出:");
        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
        }








        /*
        //7)数组的复制:
        int[] a = {10,20,30,40,50};
        //数组的扩容(创建了一个更大的新数组，并将数据复制进去)
        a = Arrays.copyOf(a,a.length+1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        */
        /*
        int[] a = {10,20,30,40,50};
        //a:源数组
        //b:目标数组
        //6:目标数组的长度
        //  ---若目标数组长度>源数组长度，则末尾补默认值
        //  ---若目标数组长度<源数组长度，则末尾截取
        int[] b = Arrays.copyOf(a,6); //灵活性差
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        */











        /*
        int[] a = {10,20,30,40,50};
        int[] b = new int[6]; //0,0,0,0,0,0
        //a:源数组
        //0:源数组的起始下标
        //b:目标数组
        //1:目标数组的起始下标
        //4:要复制的元素个数
        System.arraycopy(a,0,b,1,4); //灵活性好
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        */
    }
}



















