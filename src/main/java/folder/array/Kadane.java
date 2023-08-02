package folder.array;

public class Kadane {
    public static void main(String[] args) {


        int arr[] = {-2, -3, -4, -1, -2, 0, -5};
        int max_so_far = -100;
        int current_max = 0;
        int start = 0;
        int end =0;

        for (int i=0;i<arr.length;i++) {
          if(arr[i]<0 && current_max<=0){
              current_max =0;
          }else {
              current_max =current_max + arr[i];
              if(current_max>max_so_far){
                  max_so_far = current_max;
              }

          }


        }
        System.out.println(max_so_far);
    }
}
