package br.com.ana.fifo.entity;

public class FilaFifo {
    Integer[] fila = new Integer[0];
    int countAux = 0;
    int countRodada = 0;

    // a cada inserção eu crio um novo array para aumentar o tamanho é constante então creio que seja o(1) mesmo que tenha um laço para copiar a fila para uma nova
    // para espaço que seja o(n) a depender do tamanho da fila que tenha que ser copiada para outra
    public void enqueue(Integer integer) {
        countAux++;
        if (this.fila.length < countAux) {
            aumentarTamanhoFila(this.fila);
        }
        this.fila[countRodada] = integer;
        countRodada += 1;
    }

    // esse método é o(1) para tempo e o(n) para espaço igual as outras já que preciso modificar o tamanho dinâmicamente a cada inserção ou remoção
    public void dequeue() {
        countRodada --;
        countAux --;
        if (this.fila.length > 0) {
            Integer[] filaReduzida = new Integer[this.fila.length - 1];
            for (int i = 0; i < this.fila.length - 1; i++) {
                filaReduzida[i] = this.fila[i + 1];
            }
            this.fila = filaReduzida;
        }
    }

    //o(1) para esse método pois ele sempre aponta para o ultimo para espaço acho que seja o(1) também
    public Integer rear() {
        return this.fila[this.fila.length - 1];
    }
   //o(1) para tempo pois sempre busca o primeiro elemento da fila e de tempo também seja o(1)
    public Integer front() {
        return this.fila[0];
    }

    public Integer size() {
        return this.fila.length;
    }

    public boolean isEmpty() {
        if (this.fila.length > 0) {
            return false;
        }else{
            return true;
        }
    }

    public void aumentarTamanhoFila(Integer[] fila) {
        int tamanho = (this.fila.length + 1);
        Integer[] novaFila = new Integer[Integer.valueOf(tamanho)];
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] != null) {
                novaFila[i] = fila[i];
            }
        }
        this.fila = novaFila;
    }

    public void imprimir() {
        for (Integer integer : this.fila) {
            System.out.println(integer);
        }
    }
}
