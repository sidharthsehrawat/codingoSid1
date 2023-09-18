package folder.Oops;

public class Math {
    public final double secret = 2;
}

class ComlexMath extends Math {
    public final double secret = 4;
}

class InfiniteMath extends ComlexMath {
    public final double secret = 4;

    public static void main(String[] args) {
        ComlexMath math = new InfiniteMath();
        System.out.println(math.secret);

    }
}
