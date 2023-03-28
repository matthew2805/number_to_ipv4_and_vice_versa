
public class Main2 {
    private static void toNumber(String ip) {
    String [] arr = ip.split("\\.");
        for (String el:
             arr) {
            System.out.println(el);
        }
        int ip1 = Integer.parseInt(arr[0]),
                ip2 = Integer.parseInt(arr[1]),
                ip3 = Integer.parseInt(arr[2]),
                ip4 =Integer.parseInt(arr[3]);
        ip3 <<= 8;
        ip2 <<= 16;
        ip1 <<= 24;
        int number = ip1 | ip2 | ip3 | ip4;
        System.out.println(number);

    }
    public static String toIPv4(int ip){
        int[] IPs = new int[4];
        for (int i = 3; i >= 0; i--)
        {
            IPs[i] = ip & 255;
            ip >>= 8;
        }
        return new String(IPs[0] + "." + IPs[1] + "." + IPs[2] + "." + IPs[3]);

    }
    public static void main(String[] argv) throws Exception {
        int ip = (int)2149583360L;
        System.out.println(toIPv4(ip));
        toNumber(toIPv4(ip));
    }


}