import java.util.ArrayList;

public class PSO {

    ArrayList<Particula> cumuloParticulas;

    public double[] globalBest; //El global best será un vector de 3 posiciones,
                                //las primeras 2 posiciones serán los valores de x1 y x2 y el tecer valor su aptitud

    public PSO(){
        cumuloParticulas= new ArrayList<>();
        globalBest = new double[3];
    }
    public double evaluar(double x1, double x2){
        return (x1 * x1) + (x2 * x2);
    }
    public ArrayList<Particula> getListaParticulas() {
        return cumuloParticulas;
    }

    public void initParticulas(){
        Aleatorios.setRseed(0.5f);
        Aleatorios.randomize();
        for (int i = 1; i <=10; i++) {
            double x1 = Aleatorios.rnd(-3,3);
            double x2 = Aleatorios.rnd(-3,3);
            cumuloParticulas.add(new Particula(x1,x2));
        }
    }

    public void mostrarParticulas(){
        for (int i = 0; i <=cumuloParticulas.size()-1; i++) {
            System.out.println(cumuloParticulas.get(i).toString());
        }
    }

    public double[] getGlobalBest() {
        return globalBest;
    }

    public void setGlobalBest(double[] globalBest) {
        this.globalBest = globalBest;
    }

    public void calcularMejor(){
        double mejor = 9999;
        int indice =0;
        for (int i = 0; i <= cumuloParticulas.size()-1; i++) {
            if(cumuloParticulas.get(i).getpBest()[2] < mejor){
                mejor = cumuloParticulas.get(i).getpBest()[2];
                indice = i;
            }
        }
        setGlobalBest(cumuloParticulas.get(indice).getpBest());
    }


}
