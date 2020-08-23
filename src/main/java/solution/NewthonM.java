
package solution;
import solution.ImplemPolynomial;

public class NewthonM extends ImplemPolynomial{
  public    double approx;
  private   double l_a,r_b;
  private   double res;
  private   double epsilon;
  private  double error;
  public double a,b;


  NewthonM(ImplemPolynomial obj,double epsilon){
    //super();
    this.epsilon=epsilon;
    l_a=obj.getLeft_a();
    r_b=obj.getRight_b();
  }

  public void setEpsilon(double epsilon) {
    this.epsilon = epsilon;
  }

  public double getEpsilon() {
    return epsilon;
  }

  public double getL_a() {
    return l_a;
  }

  public double getR_b() {
    return r_b;
  }
  /*
 *      ВЫБОР НАЧАЛЬНОГО ПРИБЛИЖЕНИЯ
  */

  double choiceApprox(){
    double a= getL_a();
    double b= getR_b();

    if((getPolynomial(a)*getTwoDiffPolynomial(a))>0){
      approx=a;
    }
   else if((getPolynomial(b)*getTwoDiffPolynomial(b))>0){
     approx=b;
    }
   return approx;
  }


  //     НЕ ВЫВОДИТ АППРОКСИМАЦИЮ,ПОЭТОМУ ВВЕДЕН МЕТОД СНИЗУ ДЛЯ ПРОВЕРКИ ВЫВОДА ЗНАЧЕНИЙ ФУНКЦИИ
  void checkUseFunction(){
    double c=getPolynomial(1);
    double b=getOneDiffPolynomial(1);
    double d=getTwoDiffPolynomial(1);
    System.out.println(c);
    System.out.println(b);
    System.out.println(d);
  }




 /*
 *      ПРОВЕРКА УСЛОВИЙ
  */
  boolean volidOne(){
    for(double i=1.8;i<=2.3;i+=epsilon){
      if(getOneDiffPolynomial(i)>0||getOneDiffPolynomial(i)<0 &&
              getTwoDiffPolynomial(i)>0 ||getTwoDiffPolynomial(i)<0){
        return true;
      }
    }
    return false;
  }
  boolean volidTwo(){
    if(getPolynomial(approx)*getPolynomial(approx)<0){
      return  true;
    }
    return  false;
  }

  void solve(){
    if(volidOne() && volidTwo()){
      do{
        res=approx- getPolynomial(approx)/getOneDiffPolynomial(approx);
        error=approx-res;
        System.out.println(+res);
        approx=res;
      }while (Math.abs(error)>epsilon);
    }
    else System.out.println("Нарушено одно из условий данной реализации.");
  }

}


