public class jugar {
    public static int[][] probabilidades(){
        int [][] probabilidad = new int[11][11];
        String heatmap = "00 03 02 02 02 02 02 03 03 00 " +
                         "03 20 23 25 26 26 25 23 20 03 " +
                         "03 23 23 24 25 25 24 23 23 03 " +
                         "02 25 24 25 26 26 25 24 25 02 " +
                         "02 26 25 26 26 26 26 25 26 02 " +
                         "02 26 25 26 26 26 26 25 26 02 " +
                         "02 25 24 25 26 26 25 24 25 02 " +
                         "03 23 23 24 25 25 24 23 23 02 " +
                         "03 20 23 25 26 26 25 23 20 03 " +
                         "00 03 03 02 02 02 02 03 03 00 ";
        String[] s = heatmap.split(" ");
        int cont=0;
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                probabilidad[i][j]=Integer.parseInt(s[cont]);
                cont++;
            }
        }
        return probabilidad;

    }

    public static int MayorProb(int[][] prob){
        int mayor=0;
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                if(prob[i][j]>mayor){
                    mayor = prob[i][j];
                }
            }
        }
        return mayor;
    }

    public static int CantMayorProb(int[][] prob,int mayor){
        int cantmayor=0;
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                if(prob[i][j]==mayor){
                    cantmayor++;
                }
            }
        }
        return cantmayor;
    }

    public static int[][] DisparoUnico(int[][] prob, int mayor, Tablero t){
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                if(prob[i][j]==mayor){
                    char disparo = t.disparo(i,j);
                    prob[i][j]=0;
                    System.out.println("dispare en "+i+" "+j);
                    if(disparo !='0' && disparo != 'X'){
                        if(i-1>1){
                            if(prob[i-1][j]!=0)
                                prob[i-1][j]+=10;
                            if(j-1>1)
                                if(prob[i-1][j-1]>5)
                                    prob[i-1][j-1]-=5;
                            if(j+1<10)
                                if(prob[i-1][j+1]>5)
                                    prob[i-1][j+1]-=5;
                            if(j-2>1)
                                if(prob[i-1][j-2]>3)
                                    prob[i-1][j-2]-=3;
                            if(j+2<10)
                                if(prob[i-1][j+2]>3)
                                    prob[i-1][j+2]-=3;
                        }
                        if(j+1<10)
                            if(prob[i][j+1]!=0)
                                prob[i][j+1]+=5;
                        if(i+1<10){
                            if(prob[i+1][j]!=0)
                                prob[i+1][j]+=10;
                            if(j-1>1)
                                if(prob[i+1][j-1]>5)
                                    prob[i+1][j-1]-=5;
                            if(j+1<10)
                                if(prob[i+1][j+1]>5)
                                    prob[i+1][j+1]-=5;
                            if(j-2>1)
                                if(prob[i+1][j-2]>3)
                                    prob[i+1][j-2]-=3;
                            if(j+2<10)
                                if(prob[i+1][j+2]>3)
                                    prob[i+1][j+2]-=3;
                        }
                        if(j-1>1)
                            if(prob[i][j-1]!=0)
                                prob[i][j-1]+=5;
                        if(i-2>1){
                            if(prob[i-2][j]!=0)
                                prob[i-2][j]+=3;
                            if(j-1>1)
                                if(prob[i-2][j-1]>5)
                                    prob[i-2][j-1]-=5;
                            if(j+1<10)
                                if(prob[i-2][j+1]>5)
                                    prob[i-2][j+1]-=5;
                            if(j-2>1)
                                if(prob[i-2][j-2]>3)
                                    prob[i-2][j-2]-=3;
                            if(j+2<10)
                                if(prob[i-2][j+2]>3)
                                    prob[i-2][j+2]-=3;
                        }
                        if(j+2<10)
                            if(prob[i][j+2]!=0)
                                prob[i][j+2]+=1;
                        if(i+2<10){
                            if(prob[i+2][j]!=0)
                                prob[i+2][j]+=3;
                            if(j-1>1)
                                if(prob[i+2][j-1]>5)
                                    prob[i+2][j-1]-=5;
                            if(j+1<10)
                                if(prob[i+2][j+1]>5)
                                    prob[i+2][j+1]-=5;
                            if(j-2>1)
                                if(prob[i+2][j-2]>3)
                                    prob[i+2][j-2]-=3;
                            if(j+2<10)
                                if(prob[i+2][j+2]>3)
                                    prob[i+2][j+2]-=3;
                        }
                        if(j-2>1)
                            if(prob[i][j-2]!=0)
                                prob[i][j-2]+=1;

                        Disparo(prob,MayorProb(prob),t);
                    }else{
                        System.out.println("falle");
                        if(t.ganar()==0){
                            Disparo(prob,MayorProb(prob),t);
                        }
                    }


                    i=12;
                    j=12;

                }
            }
        }
        return prob;
    }

    public static void Disparo(int[][] prob, int mayor, Tablero t){
        int cantmayor=CantMayorProb(prob,mayor);
        int cont=0;
        int[][] coordenada = new int[cantmayor][2];
        for(int i=1; i<11;i++){
            for(int j=1; j<11;j++){
                if(prob[i][j]==mayor){
                    coordenada[cont][0]=i;
                    coordenada[cont][1]=j;
                    cont++;
                }
            }
        }
        int disparorandom=0;
        int max = cantmayor-1;
        int min = 1;
        int range = max - min + 1;
        disparorandom = (int) (Math.random() * range) ;

        int x=coordenada[disparorandom][0];
        int y=coordenada[disparorandom][1];
        prob[x][y]=100;
        DisparoUnico(prob,100,t);
    }

    public static void main(String[] args){
        int rep=1;
        int sum=0;
        for(int x=0;x<rep;x++){
            Tablero t = new Tablero(10);
            int[][] prob = probabilidades();
            int mayor=MayorProb(prob);
            int cantmayor=CantMayorProb(prob,mayor);
            if(cantmayor==1){
                DisparoUnico(prob,mayor,t);
            }else{
                Disparo(prob,mayor,t);
            }
            sum+=t.ganar();
        }
        System.out.println(sum/rep);
    }
}
