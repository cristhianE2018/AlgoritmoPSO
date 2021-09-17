

public class Particula {
    public double x1;
    public double x2;
    public double pBest[];  //Almacenará los valores de pbest , el primer y segunda posición son los valores de x, y
                            //el tercer valor será el valor de aptitud
    public double aptitud;
    public double vectorVuelo[]; //Se iniciará con 1,1 para todas las particulas

    public Particula(double x1, double x2){
        this.x1 = x1;
        this.x2 = x2;
        pBest = new double[3];
        pBest[0] = this.x1;
        pBest[1] = this.x2;
        pBest[2] = evaluar(pBest);
        vectorVuelo = new double[2];
        vectorVuelo[0]=1;
        vectorVuelo[1]=1;
        this.aptitud = (this.x1 * this.x1) + (this.x2 * this.x2);
    }

    public double getAptitud() {
        return aptitud;
    }

    public void setAptitud(double aptitud) {
        this.aptitud = aptitud;
    }

    public double[] getVectorVuelo() {
        return vectorVuelo;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double[] getpBest() {
        return pBest;
    }

    public double evaluar(double[] valores){
        return (valores[0] * valores[0]) + (valores[1] * valores[1]);
    }

    public double getAptitud(double x1, double x2){
        return aptitud;
    }

    @Override
    public String toString(){

        return "x1: " + x1 + " | " + "x2: " + x2 + " f(x) = " + aptitud +" | pBest: (" +
                pBest[0] + " , " + pBest[1] + ") = " + pBest[2]
                + " | v(t) = ("+vectorVuelo[0]+","+vectorVuelo[1]+")";
    }

}
