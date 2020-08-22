package solution;

public class Test {
    public static void main(String[] args) {
        double appr;
        /*
        ImplemPolynomial ip=new ImplemPolynomial(); //Задаем полином: границы функции,степень,коэфф.
        ip.checkBorder();//проверка граничных зная
        ip.checkPower(); //проверка степени
        ip.printBored(); //Печать
         */
        //System.out.println(ip.getPolynomial(0));
        //Начало решения методом Ньютона

        ImplemPolynomial ip1=new ImplemPolynomial(1.8,2.3);
        ip1.checkBorder();//проверка граничных зная
        ip1.checkPower(); //проверка степени
        ip1.printBored(); //Печать

        NewthonM nm= new NewthonM(ip1,0.01);
        appr=nm.choiceApprox();
        System.out.println("Начальное приближение: "+appr);
        nm.volidOne();
        System.out.println(nm.volidOne());
        nm.volidTwo();
        System.out.println(nm.volidTwo());
        nm.solve();


    }
}
