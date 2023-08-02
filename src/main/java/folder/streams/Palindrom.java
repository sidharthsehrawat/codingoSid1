package folder.streams;

import java.util.*;

class Address {
    String entry1;
    String entry2;
    String entry3;

    public Address(String entry1,String entry2,String entry3){
        this.entry1=entry1;
        this.entry2 = entry2;
        this.entry3= entry3;
    }

    public Address(){

    }

    public String getEntry1() {
        return entry1;
    }

    public void setEntry1(String entry1) {
        this.entry1 = entry1;
    }

    public String getEntry2() {
        return entry2;
    }

    public void setEntry2(String entry2) {
        this.entry2 = entry2;
    }

    public String getEntry3() {
        return entry3;
    }

    public void setEntry3(String entry3) {
        this.entry3 = entry3;
    }

}

class HelloWorld {
    public static void main(String[] args) {
  //[0,3] , [2,3] , [5,6], [7,8]


        Address address1 = new Address();
        address1.setEntry1("Mumbai");
        address1.setEntry2("Maharashtra");
        address1.setEntry3("9191");

        Address address2 = new Address();
        address2.setEntry1("Delhi");
        address2.setEntry2("Delhi");
        address2.setEntry3("123");

        Address address3 = new Address();
        address3.setEntry1("Punjab");
        address3.setEntry2("678");
        address3.setEntry3("Chandigarh");

        Address address4 = new Address();
        address4.setEntry1("Maharashtra");
        address4.setEntry2("678");
        address4.setEntry3("Pune");

        Address address5 = new Address();
        address5.setEntry1("Rajasthan");
        address5.setEntry2("9981");
        address5.setEntry3("Jaipur");

        Address address6 = new Address();
        address6.setEntry1("Haryana");
        address6.setEntry2("9981");
        address6.setEntry3("Chandigarh");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        addressList.add(address4);
        addressList.add(address5);
        addressList.add(address6);



        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<addressList.size();i++){
            Address add =   addressList.get(i);
            for(int j=i+1;j< addressList.size();j++){
                Address add2 =  addressList.get(j);
                // comparison
                if(add.getEntry1().equals(add2.getEntry1()) || add.getEntry1().equals(add2.getEntry2()) || add.getEntry1().equals(add2.getEntry3()) || add.getEntry2().equals(add2.getEntry1()) || add.getEntry2().equals(add2.getEntry2()) || add.getEntry2().equals(add2.getEntry3())|| add.getEntry3().equals(add2.getEntry1())
                        || add.getEntry3().equals(add2.getEntry2()) || add.getEntry3().equals(add2.getEntry3())){

                    map.put(i,j);
                }
            }
        }


        // [0,3] , [2,3] , [4,6], [5,6]
        // [3,2] , [6,2]
        // [3,6]

        List<List<Integer>> finalList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
           if(!map2.containsKey(entry.getValue())){
               map2.put(entry.getValue(), 1);
           }else {
               map2.put(entry.getValue(), entry.getValue()+1);
           }


        }

        ///System.out.println("\n");
        for(int i=0;i<addressList.size();i++){
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
    }
}