public class jugar {

public static void main(String[] args){
    int[][] posiciones=new int[3400000][3];
    int cont=0;
    for(int i=0; i<200000;i++) {
        TableroTest t = new TableroTest(10);
        for(int j=0;j<17;j++){
            posiciones[cont][0]=t.posicion[j][0];
            posiciones[cont][1]=t.posicion[j][1];
            posiciones[cont][2]=t.posicion[j][2];
            cont++;
        }
    }
    System.out.println(posiciones[3399999][0])//x;
    System.out.println(posiciones[3399999][1])//y;
    System.out.println(posiciones[3399999][2])//largo;
    //for tablero x
    //for tablero y
    //for posicion
    //if posicion = tablero
    //contar repeticiones en esta posicion
    //sacar la probabilidad
}
}