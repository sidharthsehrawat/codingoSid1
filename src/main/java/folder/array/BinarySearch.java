package folder.array;

public class BinarySearch {
    public static void main(String[] args) {
        int x= (int)Math.ceil((double)11/3);
        char ch = '1' ;
        int num = ch - '0';
        StringBuilder sb = new StringBuilder();
        sb.append("asv");
        sb.append(sb);
        int  a= 22%12;
       String s =  String.valueOf(sb.charAt(1));
        int[] arr = {1,2,3,4,5,6,7,8};
        int target  = 10;
        int res=  getFun(arr,target,0,arr.length-1);
        System.out.println(res);
    }

    private static int getFun(int[] arr, int target, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return getFun(arr, target, start, mid - 1);
            }

            return getFun(arr, target, mid + 1, end);
        }
        return -1;
    }
}
