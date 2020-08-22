package solution;

public interface polynomial extends function {
   void checkBorder();//Границы интервала
    boolean checkPower();//Проверка степени
    void printBored(); //Печать границ
    double getOneDiffPolynomial(double xApprox);
    double getTwoDiffPolynomial(double approx);
}
