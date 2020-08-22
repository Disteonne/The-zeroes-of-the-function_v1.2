package solution;

public interface function {
    default double getPolynomial(double x) {
        System.out.println("Полиномиальная функция не определенна.");
        return 0.0;
    }
}
    /*
    default double getTrigonometrical(double x){
        System.out.println("Тригонометрическая функция не определенна.");
        return 0.0;
    }
    //и тд.
}

     */
