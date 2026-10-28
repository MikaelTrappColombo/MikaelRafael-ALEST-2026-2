// A pagina atual e a frente do deque voltar
public class Browser {
    private final Deque voltar = new Deque();
    private final Deque avancar = new Deque();
    private final Lista historico = new Lista();
    private final Lista favoritos = new Lista();

    public void visitar(String url) {
        historico.insere(url, 0);
        if (voltar.estaCheio()) {
            voltar.removerFim(); // descarta a pagina mais antiga
        }
        voltar.inserirFrente(url);
        avancar.clear(); // nova visita apaga as paginas a frente
        System.out.println("Visitando: " + url);
    }

    public void voltar() {
        if (voltar.tamanho() <= 1) {
            System.out.println("Erro: nao ha pagina anterior");
            return;
        }
        String saiu = voltar.removerFrente();
        if (avancar.estaCheio()) {
            avancar.removerFim();
        }
        avancar.inserirFrente(saiu);
        System.out.println("Voltando para: " + voltar.getFrente());
    }

    public void avancar() {
        if (avancar.estaVazio()) {
            System.out.println("Erro: nao ha pagina para avancar");
            return;
        }
        String url = avancar.removerFrente();
        if (voltar.estaCheio()) {
            voltar.removerFim();
        }
        voltar.inserirFrente(url);
        System.out.println("Avancando para: " + url);
    }

    public void atual() {
        if (voltar.estaVazio()) {
            System.out.println("Erro: nenhuma pagina visitada");
        } else {
            System.out.println("Atual: " + voltar.getFrente());
        }
    }

    public void historico() {
        if (historico.estaVazia()) {
            System.out.println("Historico vazio");
        } else {
            System.out.println("Historico: " + historico.toText(" -> "));
        }
    }

    public void favoritar(String url) {
        if (favoritos.contem(url)) {
            System.out.println("Erro: ja favoritado: " + url);
            return;
        }
        favoritos.insere(url, favoritos.tamanho());
        System.out.println("Favoritado: " + url);
    }

    public void favoritos() {
        if (favoritos.estaVazia()) {
            System.out.println("Nenhum favorito");
        } else {
            System.out.println("Favoritos: " + favoritos.toText(", "));
        }
    }
}