import java.util.ArrayList;

public class jugar {
    public static String posicion(Tablero t , int x , int y ,char barco){
        String pos="";
        if(y+1<11 && pos.isEmpty()){
            if (t.disparo(x, y+1) == barco) {
                pos="Hd";
            }
        }
        if(x+1<11 && pos.isEmpty()){
            if (t.disparo(x+1, y) == barco) {
                pos="Vab";
            }
        }
        if(y-1>0 && pos.isEmpty()){
            if (t.disparo(x, y-1) == barco) {
                pos="Hi";
            }
        }
        if(x-1>0 && pos.isEmpty()){
            if (t.disparo(x-1, y) == barco) {
                pos="Var";
            }
        }
        return pos;
    }

    public static int largobarco(char barco){
        if (barco == 'A') {
            return 5;
        }
        if (barco == 'B') {
            return 4;
        }
        if (barco == 'C') {
            return 3;
        }
        if (barco == 'S') {
            return 3;
        }
        if (barco == 'D') {
            return 2;
        }
        return 0;
    }

    public static void Matar(Tablero t , int x , int y,char barco, int largo){
        String pos = posicion(t, x, y, barco);
        char disparo;
        if(largo==3) {
            if (pos.equalsIgnoreCase("Hd")) {
                disparo=t.disparo(x, y + 2);
                if (y + 2 <= 10 && disparo == barco) {

                } else {
                    t.disparo(x, y - 1);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y+2,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo = t.disparo(x, y - 2);
                if (y - 2 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x, y + 1);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y-2,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo = t.disparo(x - 2, y);
                if (x - 2 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x + 1, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x-2, y,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo = t.disparo(x + 2, y);
                if (x + 2 <= 10 && disparo == barco) {
                } else {
                    t.disparo(x - 1, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x+2, y,disparo,largobarco(disparo));
                }
            }
        }
        if(largo==4) {
            if (pos.equalsIgnoreCase("Hd")) {
                disparo = t.disparo(x,y+3);
                if (y + 3 <= 10 && disparo == barco) {
                } else {
                    t.disparo(x, y - 1);
                    t.disparo(x, y - 2);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y+3,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo = t.disparo(x, y-3);
                if (y - 3 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x, y + 1);
                    t.disparo(x, y + 2);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y-3,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo = t.disparo(x - 3, y);
                if (x - 3 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x + 1, y);
                    t.disparo(x + 2, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x-3, y,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo = t.disparo(x + 3, y);
                if (x + 3 <= 10 && disparo == barco) {
                } else {
                    t.disparo(x - 1, y);
                    t.disparo(x - 2, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x + 3, y,disparo,largobarco(disparo));
                }
            }
        }
        if(largo==5) {
            if (pos.equalsIgnoreCase("Hd")) {
                disparo = t.disparo(x, y+4);
                if (y + 4 <= 10 && disparo == barco) {
                } else {
                    t.disparo(x, y - 1);
                    t.disparo(x, y - 2);
                    t.disparo(x, y - 3);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y+4,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Hi")) {
                disparo = t.disparo(x, y-4);
                if (y - 4 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x, y + 1);
                    t.disparo(x, y + 2);
                    t.disparo(x, y + 3);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x, y-4,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Var")) {
                disparo = t.disparo(x - 4, y);
                if (x - 4 >= 1 && disparo == barco) {
                } else {
                    t.disparo(x + 1, y);
                    t.disparo(x + 2, y);
                    t.disparo(x + 3, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x-4, y,disparo,largobarco(disparo));
                }
            }
            if (pos.equalsIgnoreCase("Vab")) {
                disparo = t.disparo(x + 4, y);
                if (x + 4 <= 10 && disparo == barco) {
                } else {
                    t.disparo(x - 1, y);
                    t.disparo(x - 2, y);
                    t.disparo(x - 3, y);
                    if(disparo != '0' && disparo != 'X')
                        Matar(t, x + 4 , y,disparo,largobarco(disparo));
                }
            }
        }
    }

    public static void main(String[] args) {
        int sum=0;
        int repeticiones=1;
        ArrayList<String> pos = new ArrayList();

        int j;

        for (int i = 1; i <= 10; i++) {
            j=1;
            if(i%2 == 0){
                j=2;
            }
            for (j = j; j <= 10; j=j+2) {
                pos.add(i+" "+j);
                //System.out.println(i+" "+j);
            }
        }
        int contador=0;
        for (int veces = 0; veces < repeticiones; veces++) {
            Tablero t = new Tablero(10);
            ArrayList<Integer> NumeG = new ArrayList();
            //String ta=t.Imprimir2();

            for (int i = 0; i < 50; i++) {
                boolean yaestoy=false;
                int disparorandom = (int) (Math.random()*50 +0);
                for (Integer num : NumeG) {
                    if (num == disparorandom) {
                        yaestoy=true;
                    }
                }
                if(yaestoy==true && NumeG.size()!= 50){
                    i=i-1;
                    continue;
                }else{
                    NumeG.add(disparorandom);
                }
            }

            for (int i = 0; i < 50; i++) {
                String[] tiropos = pos.get(NumeG.get(i)).split(" ");
                int x = Integer.parseInt(tiropos[0]);
                int y = Integer.parseInt(tiropos[1]);
                if (t.ganar() == 0) {
                    char disparo = t.disparo(x, y);
                    Matar(t, x, y,disparo,largobarco(disparo));
                }
            }

            if(t.ganar()!=0) {
                System.out.println(veces);
                //System.out.println(ta);

                contador++;
            }else{
                t.Imprimir();
            }

            sum+=t.ganar();
        }
        System.out.println(contador);
        System.out.println(sum/contador);
    }
}