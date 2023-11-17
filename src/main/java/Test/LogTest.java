package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Log{
    String ipAddress;
    int time;

    public Log(String ipAddress, int time){
        this.ipAddress = ipAddress;
        this.time = time;

    }
}
 class Test {
    public static void main(String[] args) {
        Log l1= new Log("a1", 2);
        Log l2= new Log("a1", 3);
        Log l3= new Log("b1", 5);
        Log l4= new Log("p1", 1);

        List<Log> list = new ArrayList<>();
        list.add(l1);list.add(l2);list.add(l3);list.add(l4);
        Map<String, Long> map = list.stream().map(e -> e.ipAddress).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        // op = a1

    }
}
