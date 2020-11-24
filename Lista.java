public class Lista {
    Nodo inicio = null;
    Nodo fin = null;

    public void insertar(int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        if (inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
            nuevo.anterior = fin;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void recorrer(){
        Nodo aux = inicio;
        while (aux != null){
            System.out.println(aux.dato + " ");
            aux = aux.siguiente;
        }
    }

    public Nodo mitad(Nodo inicio, Nodo fin){
        int x;
        Nodo aux = inicio;
        Nodo ant = inicio.anterior;

        while(aux != fin){
            if(aux.dato <= fin.dato){
                if(ant == null){
                    ant = inicio;
                }else{
                    ant = ant.siguiente;
                }
                x = ant.dato;
                ant.dato = aux.dato;
                aux.dato = x;
            }
            aux = aux.siguiente;
        }

        if(ant == null){
            ant = inicio;
        }
        else{
            ant = ant.siguiente;
        }

        x = ant.dato;
        ant.dato = fin.dato;
        fin.dato = x;

        return ant;
    }

    public void sortRe(Nodo a, Nodo b){
        if((b != null) && (a != b) && (a != b.siguiente)){
            Nodo temp = mitad(a, b);
            sortRe(a, temp.anterior);
            sortRe(temp.siguiente, b);
        }
    }

    public void quickSort(){
        sortRe(inicio,fin);
    }


}
