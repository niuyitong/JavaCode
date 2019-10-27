public class Calculator {
    private int num1;
    private int num2;
    private double num3;
    private double num4;

    public int add(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1+this.num2;
    }
    public double add(double num1,double num2) {
        this.num3 = num1;
        this.num4 = num2;
        return this.num3 + this.num4;
    }

    public double sub(double num1,double num2){
        this.num3 = num1;
        this.num4 = num2;
        return this.num3-this.num4;
    }
    public int sub(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1-this.num2;
    }
    public int mul(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1*this.num2;
    }
    public double mul(double num1,double num2) {
        this.num3 = num1;
        this.num4 = num2;
        return this.num3 * this.num4;
    }
    public int div(int num1,int num2){
            this.num1 = num1;
            this.num2 = num2;
            return this.num1/this.num2;
        }
    public double div(double num1,double num2){
            this.num3 = num1;
            this.num4 = num2;
            return this.num3/this.num4;
        }

}
