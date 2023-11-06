package folder.array;

public class DuplicateEleUsingXOR {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,7,8,9,10};
        int xor = 0;
        for(int i :arr){
            xor=xor^i;
        }

        for(int i=1;i<=arr.length+1;i++){
            xor =xor^i;
        }
        System.out.println(xor);
        }
    }
