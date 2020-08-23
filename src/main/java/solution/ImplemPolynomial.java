package solution;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class ImplemPolynomial implements polynomial {

    private double left_a, right_b;
    private int n;
    private int[] c = new int[11]; //max-10 степень, следовательно,11 коэфф.+1 на запас
   // double res1,res;

    /*
     *           КОНСТРУКТОР
     */

    void getNumbers () throws ArrayIndexOutOfBoundsException{
        System.out.println("Инициализация полинома...");
        System.out.println("Введите интервал рассмотрения функции.");
        Scanner scanner = new Scanner(System.in);
        this.left_a = scanner.nextDouble();
        this.right_b = scanner.nextDouble();
        System.out.println("Введите наибольшую степень многочлена из max-возможной величины." +
                "Максимальная степень многочлена равна 10.");
        this.n = scanner.nextInt();

        System.out.println("Замечательно! Правда сказать,мы еще не проверили введенные Вами данные,но " +
                "нам необходимо,чтобы вы заполнили следующие коээфициэнты...");
        System.out.println("Введите коэффициенты многочлена." +
                "К примеру, c[0]-коэффициент,стоящий перед x в степени 0.");

            for (int i = 0; i <= n; i++) {
                System.out.print("c[" + i + "] = ");
                c[i] = scanner.nextInt();
                System.out.println();
            }


    }
    /*
    ImplemPolynomial() {
        System.out.println("Инициализация полинома...");
        System.out.println("Введите интервал рассмотрения функции.");
        Scanner scanner = new Scanner(System.in);
        this.left_a = scanner.nextDouble();
        this.right_b = scanner.nextDouble();
        System.out.println("Введите наибольшую степень многочлена из max-возможной величины." +
                "Максимальная степень многочлена равна 10.");
        this.n = scanner.nextInt();

        System.out.println("Замечательно! Правда сказать,мы еще не проверили введенные Вами данные,но " +
                "нам необходимо,чтобы вы заполнили следующие коээфициэнты...");
        System.out.println("Введите коэффициенты многочлена." +
                "К примеру, c[0]-коэффициент,стоящий перед x в степени 0.");
        try {
            for (int i = 0; i <= n; i++) {
                System.out.print("c[" + i + "] = ");
                c[i] = scanner.nextInt();
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Проггер этой проги-даунич! :(");
        }


    }

     */

    /*
    ImplemPolynomial(double left_a,double right_b){
        this.left_a=left_a;
        this.right_b=right_b;
        this.n=5;
        c[0]=4;
        c[1]=2;
        c[2]=-4;
        c[3]=-3;
        c[4]=0;
        c[5]=1;
    }
    /*
     *
     *           ГЕТТЕРЫ/СЕТТЕРЫ
     *
     */

    public void setLeft_a(double left_a) {
        this.left_a = left_a;
    }

    public double getLeft_a() {
        return left_a;
    }

    public double getRight_b() {
        return right_b;
    }

    public void setRight_b(double right_b) {
        this.right_b = right_b;
    }

    public void setC(int[] c) {
        this.c = c;
    }

    public int[] getC() {
        return c;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    /*
    *           Проверка гранчных значений интерв. и введенной степени
     */
    public void checkBorder() {
        try {
            double tmp = 0;
            if (left_a > right_b) {
                tmp = left_a;
                left_a = right_b;
                right_b = tmp;
            } else if (left_a == right_b) {
                throw new ExEqualityBorders();
            }
        } catch (ExEqualityBorders ex) {
            System.out.println("- - -");
        }
    }

    public boolean checkPower() {
        if(n<0 && n>10){
            System.out.println("Упс! Но максимально значение меньше 10...и больше 0!");
            return false;
        }
        return true;
    }



    public void printBored() {
        System.out.println("Проверка пройдена." +
                "Введенный Вами интервал:" +
                "[" + left_a + " : " + right_b + "]");
    }



    public double getPolynomial(double approx) {
        double res = 0;
        for (int i = 0; i <= n; i++) {
            res += c[i] * Math.pow(approx, i);
        }
        return res;
    }

    public double getOneDiffPolynomial(double approx) {
        double res1=0;
        for (int i = 1; i <= n; i++) {
            res1 += c[i] *i* Math.pow(approx, i-1);
        }
        return res1;
    }

    public double getTwoDiffPolynomial(double approx) {
        double res2=0;
        for (int i = 2; i <= n; i++) {
            res2 += c[i] *i*(i-1)*Math.pow(approx, i-2);
        }
        return res2;

    }
}

