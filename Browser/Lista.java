// Lista duplamente encadeada com nodos sentinela (header e trailer)
public class Lista {
    private Node header = new Node(null);
    private Node trailer = new Node(null);
    private int tamanho;

    public Lista() {
        header.next = trailer;
        trailer.prev = header;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    // posicao 0 = inicio, posicao tamanho = fim
    public void insere(String url, int posicao) {
        if (url == null) {
            throw new IllegalArgumentException("URL nula");
        }
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + posicao);
        }

        // nodo que ficara antes do novo (na posicao 0 e o header)
        Node anterior = header;
        for (int i = 0; i < posicao; i++) {
            anterior = anterior.next;
        }
        Node posterior = anterior.next;

        Node novo = new Node(url);
        novo.prev = anterior;
        novo.next = posterior;
        anterior.next = novo;
        posterior.prev = novo;

        tamanho++;
    }

    public boolean contem(String url) {
        Node atual = header.next;
        while (atual != trailer) {
            if (atual.url.equals(url)) {
                return true;
            }
            atual = atual.next;
        }
        return false;
    }

    public String toText(String separador) {
        String texto = "";
        Node atual = header.next;
        for (int i = 0; i < tamanho; i++) {
            texto += atual.url;
            if (i < tamanho - 1) {
                texto += separador;
            }
            atual = atual.next;
        }
        return texto;
    }
}
