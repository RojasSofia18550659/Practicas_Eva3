
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
       int[] datos = new int[20];
       llenar(datos);
       imprimirArreglo(datos);
       long ini,fin;
       ini = System.nanoTime();
       selectionSort(datos);
       fin = System.nanoTime();
       imprimirArreglo(datos);
        System.out.println("Tiempo = "+(fin-ini));
       
       llenar(datos);
       imprimirArreglo(datos);
       ini = System.nanoTime();
       insertionSort(datos);
       fin = System.nanoTime();
       imprimirArreglo(datos);
       System.out.println("Tiempo = "+(fin-ini));
       
       llenar(datos);
        imprimirArreglo(datos);
        ini = System.nanoTime();
        bubbleSort(datos);
        fin = System.nanoTime();
        imprimirArreglo(datos);
        System.out.println("Tiempo = "+(fin-ini));
        
        llenar(datos);
        imprimirArreglo(datos);
        ini = System.nanoTime();
        quickSort(datos);
        fin = System.nanoTime();
        imprimirArreglo(datos);
        System.out.println("Tiempo = "+(fin-ini));
        
        selectionSort(datos);
        imprimirArreglo(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int iVal = input.nextInt();
        System.out.println("Posicion: "+busquedaBin(datos, iVal));
        
       char a = 'A';
       char b = 'B';
       
    }
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random()*100);
        }
}
    public static void imprimirArreglo(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+ arreglo[i]+"]");
        }
        System.out.println("");
    }
    //O(N^2)
    //HACE MAS COMPARACIONES, MENOS INTERCAMBIOS
public static void selectionSort(int[] arreglo){
    for (int i = 0; i < arreglo.length-1; i++) {
        int iMin = i;
        for (int j = i+1; j < arreglo.length; j++) {
            if(arreglo[j]<arreglo[iMin]){
                iMin = j;
            }
        }
        //SWAP
        int iTemp = arreglo[iMin];
            arreglo[iMin] = arreglo[i];
            arreglo[i] = iTemp;
    }
}

//O(N^2)
//HACE MAS INTERCAMBIOS, MENOS COMPARACIONES
public static void insertionSort(int[] arreglo){
    for (int i = 1; i < arreglo.length; i++) {
        int iTemp = arreglo[i];
        int insP;
        for (insP = i; insP > 0; insP--) {
            int iPrevio = insP-1;
            if(arreglo[iPrevio]>iTemp){
                //SWAP
                arreglo[insP] = arreglo[iPrevio];
            }else{
                break;
            }
        }
        arreglo[insP]=iTemp;
    }
}

public static void bubbleSort(int[] arreglo){
    for (int i = 0; i < arreglo.length; i++) {
        for (int j = 0; j < arreglo.length-1; j++) {
            if(arreglo[j] > arreglo[j+1]){
                int iTemp = arreglo[j];
                arreglo[j]=arreglo[j+1];
                arreglo[j+1]= iTemp;
            }
        }
    }
}

public static void quickSort(int[]arreglo){
    quickSortRec(arreglo, 0, arreglo.length -1);
    
    
    
    
}

private static void quickSortRec(int[] arreglo, int ini, int fin){
    //DETENERNOS
    if((ini < fin) && (ini>=0) && (fin < arreglo.length)){
    int iTemp;
    int iPiv= ini;
    int too_big = ini+1;
    int too_small=fin;
    
    while(too_big<too_small){
        
        while((too_big < fin) && (arreglo[too_big]< arreglo[iPiv])){
            too_big++;
        }
    
        while((too_small > (ini+1)) && (arreglo[too_small] > arreglo[iPiv])){
            too_small--;
        }
    
       
        if(too_big<too_small){ //NO SE HAN CRUZADO
            iTemp = arreglo[too_big];
            arreglo[too_big] = arreglo[too_small];
            arreglo[too_small] = iTemp;
        }
    }
    //SWAP AL PIVOTE
    iTemp = arreglo[iPiv];
    arreglo[iPiv] = arreglo[too_small];
    arreglo[too_small] = iTemp;
    
    quickSortRec(arreglo, ini, too_small-1); //IZQ
    quickSortRec(arreglo, too_small+1 , fin); //DER
}
    
    
    
}
public static int busquedaBin(int[] arreglo, int val){
        return busquedaBinRec(arreglo,val, 0, arreglo.length-1);
}
    
public static int busquedaBinRec(int[] arreglo, int val, int ini, int fin){    
    if(ini <= fin){
        int mid = ini +((fin-ini) / 2);   
        if(val == arreglo[mid]){//IGUAL
            return mid;
        }else if(val>arreglo[mid]){//MAYOR
            return busquedaBinRec(arreglo, val, mid+1, fin);
        }else{//MENOR
            return busquedaBinRec(arreglo, val, ini, mid-1);
        }
    }else{
        return -1;
    }
}
}


