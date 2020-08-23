package solution;

public class Test {
    public static void main(String[] args) {
        double appr;

        ImplemPolynomial ip1=new ImplemPolynomial(); //Задаем полином: границы функции,степень,коэфф
        try {

            ip1.getNumbers();// .
            ip1.checkBorder();//проверка граничных зная
            //ip1.checkPower(); //проверка степени
            ip1.printBored(); //Печать
           // double k=ip1.getPolynomial(0);
           // System.out.println(k);

            // ВЫВОД ЗНАЧ ФУНКЦИИ ЧЕРЕЗ РОД КЛАСС
            double k1=ip1.getPolynomial(1);
            System.out.println(k1);
            double k3= ip1.getOneDiffPolynomial(1);
            System.out.println(k3);
            double k2=ip1.getTwoDiffPolynomial(1);
            System.out.println(k2);



            //System.out.println(ip1.getLeft_a());

            NewthonM nm= new NewthonM(ip1,0.01);

            // ВЫВОД ЗНАЧ ФУНКЦИИ ЧЕРЕЗ ДОЧЕРНИЙ
            nm.checkUseFunction();


            //System.out.println(nm.getL_a());
           // appr=nm.choiceApprox();
            //System.out.println("Начальное приближение: "+nm.choiceApprox());
            /*
            nm.volidOne();
            System.out.println(nm.volidOne());
            nm.volidTwo();
            System.out.println(nm.volidTwo());
            nm.solve();



             */
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Мы же просили ввести степень <=10! :(");
        }


    }
}
