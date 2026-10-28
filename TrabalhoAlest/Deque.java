// Deque duplamente encadeado com nodos sentinela (header e trailer)
public class Deque {
    private static int LIMITE = 5;

    private Node header = new Node(null);
    private Node trailer = new Node(null);
    private int tamanho;

    public Deque() {
        header.next = trailer;
        trailer.prev = header;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public boolean estaCheio() {
        return tamanho == LIMITE;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirFrente(String url) {
        if (url == null) {
            throw new IllegalArgumentException("URL nula");
        }
        if (estaCheio()) {
            throw new IllegalArgumentException("Deque cheio");
        }

        Node novo = new Node(url);
        novo.prev = header;
        novo.next = header.next;
        header.next.prev = novo;
        header.next = novo;

        tamanho++;
    }

    public void inserirFim(String url) {
        if (url == null) {
            throw new IllegalArgumentException("URL nula");
        }
        if (estaCheio()) {
            throw new IllegalStateException("Deque cheio");
        }

        Node novo = new Node(url);
        novo.next = trailer;
        novo.prev = trailer.prev;
        trailer.prev.next = novo;
        trailer.prev = novo;

        tamanho++;
    }

    private String remover(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        tamanho--;
        return node.url;
    }

    public String removerFrente() {
        if (estaVazio()) {
            return null;
        }
        return remover(header.next);
    }

    public String removerFim() {
        if (estaVazio()) {
            return null;
        }
        return remover(trailer.prev);
    }

    public String getFrente() {
        if (estaVazio()) {
            return null;
        }
        return header.next.url;
    }

    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        tamanho = 0;
    }
}
