package folder.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
class Customer {

    String name;
    String email;
    List<CustomerAddresss> address;


}
@Data
@AllArgsConstructor
class CustomerAddresss{
    State state;
}

@Data
@AllArgsConstructor
class State{
    String city;
}

public class StreamMapFlatMapReduce {
    static List<Customer> customerList = new ArrayList<>();
    public static void main(String[] args) {
        List<CustomerAddresss> list1 = new ArrayList<>();

        Customer c1= new Customer("Sid", "sid@email", list1);

        customerList.add(new Customer("Sid", "sid@email.com", list1));
    }


}
