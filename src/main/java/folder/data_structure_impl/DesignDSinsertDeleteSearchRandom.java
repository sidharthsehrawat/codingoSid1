package folder.data_structure_impl;

import java.util.Random;
import java.util.function.Predicate;

public class DesignDSinsertDeleteSearchRandom {
    public static void main(String[] args) {

        Predicate<Integer> predicate = a -> (a==2);
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(1));

        Random random = new Random();

        for(int i =0;i<10;i++){
            int index = random.nextInt(5);
            //System.out.println(index);
        }


        // Binary Tree ||  n-ary Tree
        // Matrix
        // Graph
    }
}
