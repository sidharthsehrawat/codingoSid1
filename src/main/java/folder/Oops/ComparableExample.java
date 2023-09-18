package folder.Oops;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Data
class Movie implements Comparable<Movie> {
    int year;
    String name;
    public Movie(int year , String name){
        this.name = name;
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }
}

class NameCompare implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
public class ComparableExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.reverse();
        List<Movie> list = Arrays.asList(new Movie(2, "Sid"), new Movie(1, "Dom"));
        Collections.sort(list,new NameCompare());
    }
}
