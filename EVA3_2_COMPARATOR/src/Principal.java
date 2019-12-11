import java.util.Comparator;
import java.util.LinkedList;

public class Principal {

    public static void main(String[] args) {
        LinkedList<Integer> iLista = new LinkedList<Integer>();
        for (int i = 0; i < 15; i++) {
            iLista.add(i,(int)(Math.random()*100));
            
        }
        System.out.println(iLista);
        
        Comparator c = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int resu;
                
                //CERO     --> IGUAL
                //POSITIVO --> MAYOR
                //NEGATIVO --> MENOR
                
                Integer val1,val2;
                val1= (Integer)o1;
                val2= (Integer)o2;
                resu = val1-val2;
                
                return resu;
            }
        };
        
        iLista.sort(c);
        System.out.println(iLista);
    
    LinkedList<String> listaStr = new LinkedList<String>();
    listaStr.add("HOLA");
    listaStr.add(" ");
    listaStr.add("MUNDO");
    listaStr.add(" ");
    listaStr.add("CRUEL");
    listaStr.add("!!");
    
    Comparator cmpStr = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String)o1;
                String cade2 = (String)o2;
                char c1=cade1.charAt(0);
                char c2=cade2.charAt(0);
                return c1-c2;
            }
        
    };
       System.out.println(listaStr);
       listaStr.sort(cmpStr);
       System.out.println(listaStr);
    }
    
}
