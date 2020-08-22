
package solution;
import solution.ImplemPolynomial;

public class NewthonM extends ImplemPolynomial{
  private   double approx;
  private   double left_a,right_b;
  private   double res=0;
  private   double epsilon;
  private  double error;


  NewthonM(ImplemPolynomial obj,double epsilon){
    super(obj.getLeft_a(),obj.getRight_b());
    this.epsilon=epsilon;
    left_a=obj.getLeft_a();
    right_b=obj.getRight_b();
  }

  public void setEpsilon(double epsilon) {
    this.epsilon = epsilon;
  }

  public double getEpsilon() {
    return epsilon;
  }
 /*
 *      ВЫБОР НАЧАЛЬНОГО ПРИБЛИЖЕНИЯ
  */
  double choiceApprox(){
    if(getPolynomial(left_a)*getTwoDiffPolynomial(left_a)>0){
      approx=left_a;

    }
    else if(getPolynomial(right_b)*getTwoDiffPolynomial(right_b)>0){
      approx=right_b;
    }
    return approx;
  }

 /*
 *      ПРОВЕРКА УСЛОВИЙ
  */
  boolean volidOne(){
    for(double i=left_a;i<=right_b;i+=epsilon){
      if(getOneDiffPolynomial(i)>0||getOneDiffPolynomial(i)<0 &&
              getTwoDiffPolynomial(i)>0 ||getTwoDiffPolynomial(i)<0){
        return true;
      }
    }
    return false;
  }
  boolean volidTwo(){
    if(getPolynomial(left_a)*getPolynomial(right_b)<0){
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


