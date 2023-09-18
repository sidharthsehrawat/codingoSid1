package folder.data_structure_impl;


import java.util.ArrayList;

class Stack<T> {
    ArrayList<T> A;
    int size;
    int top = -1;

    Stack() {
        this.size = size;
        this.A = new ArrayList<T>(size);
    }

    public void push(T element) {
        if (top + 1 == size) {
            System.out.println("Overflow");
        } else {
            top = top+1;
            A.add(element);
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("Underflow");
        }
        else {
            top--;
        }
    }

    public T peek(){
        if(top ==-1){
            System.out.println("Underflow");
            return null;
        }else {
            return A.get(top);
        }
    }

    public boolean isEmpty(){
        return top ==-1;
    }

    public String display(){
        String Ans = "";
        for(int i =0;i<top;i++){
            Ans += String.valueOf(A.get(i)+ "-->");
        }
        Ans+= String.valueOf(A.get(top));
        return Ans;
    }



}


public class StackImplementation {
    public static void main(String[] args) {

    }
}
