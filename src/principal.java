

public class principal {
    public static void main(String[] args) {
        Aleatorios.setRseed(0.5f);
        Aleatorios.randomize();
        PSO pso = new PSO();
        pso.initParticulas(); //Se genera inicialmente un cúmulo de soluciones
        System.out.println("Particulas iniciales: ");
        pso.mostrarParticulas();
        pso.calcularMejor();
        double[] gb = pso.getGlobalBest();
        //Se localiza el global best
        System.out.println("El global best es (" + gb[0] + "," + gb[1]+") = " + gb[2]);
        int gen=1;
        int genMax=10;

        while(gen <= genMax)
        {
            int tam = pso.getListaParticulas().size();
            double w;
            double c1,c2;
            double r1,r2;
            double v1,v2;
            Particula particula;
            for (int i = 0; i <=tam-1; i++) {
                particula = pso.getListaParticulas().get(i);
                //Por cada particula, se obtienen los parametros para calcular el nuevo vector de vuelo
                v1 = particula.getVectorVuelo()[0];
                v2 = particula.getVectorVuelo()[1];
                w= Aleatorios.rnd(0.1,0.5); //Aleatorio entre 0.1 y 0.5
                c1= Aleatorios.rnd(1.5,2); //Aleatorio entre 1.5 y 2
                c2= Aleatorios.rnd(1.5,2);  //Aleatorio entre 1.5 y 2
                r1 = Math.random(); //Aleatorio entre 0 y 1
                r2 = Math.random(); //Aleatorio entre 0 y 1

                //Se calculan los nuevos valores del vector de vuelo con la formula de vuelo
                double newV1, newV2;
                newV1 = (w * v1) + (c1 * r1) * (particula.getpBest()[0] -
                        (particula.getX1())) + (c2 * r2) *
                        (pso.getGlobalBest()[0]-(particula.getX1()));

                newV2 = w * v2 + c1 * r1 * (particula.getpBest()[1]-
                        (particula.getX2())) + (c2 * r2) +
                        (pso.getGlobalBest()[1] - (particula.getX2()));

                System.out.println("Nuevas posiciones: | x1 : " + newV1 + " x2 : " + newV2);
                //Se asignan las posiciones al vector de vuelo
                particula.getVectorVuelo()[0] = newV1;
                particula.getVectorVuelo()[1] = newV2;

               

                /*
                        Aqui iría el método para acotamiento de parámetros
                 */

                //Se asignan las nuevas posiciones de vuelo a la particula, sumando el valor anterior con el actual
                particula.setX1(particula.getX1() + newV1);
                particula.setX2(particula.getX2()+ newV2);
                //se calcula y se asigna la nueva aptitud de la particula con la nueva posición
                double newAptitud = pso.evaluar(particula.getX1(),particula.x2);
                particula.setAptitud(newAptitud);
                double pbestactual = particula.getpBest()[2];

                //Se pregunta si la nueva posición de la particula es mejor que el actual pBest
                if(particula.getAptitud() < particula.getpBest()[2]){
                    //Si la nueva posición es mejor, se actualiza el vector pBest
                    particula.getpBest()[0] = particula.getX1();
                    particula.getpBest()[1] = particula.getX2();
                    particula.getpBest()[2] = particula.getAptitud();
                }
            }

            //Se actualiza el globalBest
            pso.calcularMejor();
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
            pso.mostrarParticulas();
            //Se muestra el nuevo global best con su aptitud
            System.out.println("El global best es : (" +
                    + pso.getGlobalBest()[0] +"," + pso.getGlobalBest()[1] + ") = " + pso.getGlobalBest()[2]);
            gen++;
        }


        System.out.println("Hola Mundo");


    }
}
