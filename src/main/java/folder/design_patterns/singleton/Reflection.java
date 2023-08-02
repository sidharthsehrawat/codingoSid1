package folder.design_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Class.forName("folder/design_patterns/Reflection.java");
        Constructor<?>[] list = c.getConstructors();
        Method[] methods = c.getMethods();
        Field[] fileds = c.getDeclaredFields();
        Method[] decMethods = c.getDeclaredMethods();
        Method methods1 = c.getDeclaredMethod("m", String.class);
        methods1.setAccessible(true);
        methods1.invoke(new Parent() , "name");
    }


}


class Product extends Parent implements  IA{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void method() {
        System.out.println("a");
    }
}

class Parent {
    String parent;

    private void m(String name){
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}

interface IA {
    public void method();
}
