
import java.net.UnknownHostException;


public class Main {
    public static String toBinary(int num ){
        if(num<0){
            num = Math.abs(num);
        }

        StringBuilder buff = new StringBuilder();
        int remain= num%2;
        buff.append(remain);
        while ((num/=2)!=0){
            remain = num%2;
            buff.append(remain);
        }

        buff.reverse();

        int zerosCount = 32 - buff.length();
        StringBuilder fullbin =new StringBuilder( String.format("%0" + zerosCount + "d%s", 0,buff));

       /* На данном этапе нужно выполнить сдвиг на +1 но я пока что не нашел способ как это можно сделать
       и пока что эта программа считает только положительные числа((
       Поэтому выбрал второе решение через битовые сдвиги
        */


        return fullbin.toString();
    }
    public static int octetToNumber(String octet){
        char[] arr = octet.toCharArray();
        int sum =0;
        for (int i =7;i >=0; i--){
            if(arr[i]=='1'){
                sum += (int)Math.round(Math.pow(2,i));
            }
        }
        return sum;
    }

    public static String toIPv4(int num){
        String bin = toBinary(num);

        String ip = String.format("%d.%d.%d.%d",octetToNumber(bin.substring(0,8)),
                octetToNumber(bin.substring(8,16)),
                octetToNumber(bin.substring(16,24)),
                octetToNumber(bin.substring(24,32)));
        return ip;
    }
    public static void main(String[] args) throws UnknownHostException {
        int b =(int)3121;

        System.out.println(b);

        /* System.out.println("my  2149583360");
        System.out.println("max " + Integer.MAX_VALUE);*/

        System.out.println(toBinary(b));



        /*System.out.println(toIPv4(b));
        String binary = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
        System.out.println(binary);*/



    }
}