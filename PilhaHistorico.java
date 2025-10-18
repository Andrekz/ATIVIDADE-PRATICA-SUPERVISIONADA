
class Elemento {
    String id;
    String descricao;
    String dataHora;

    public Elemento(String id, String descricao, String dataHora) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }
}


class No {
    Elemento elemento;
    No proximo;

    public No(Elemento elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}


class Pilha {
    private No topo;

    public Pilha() {
        topo = null;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void empilhar(Elemento elemento) {
        No novo = new No(elemento);
        novo.proximo = topo;
        topo = novo;
    }

    public Elemento desempilhar() {
        if (vazia()) {
            System.out.println("O histórico está vazio!");
            return null;
        }
        Elemento e = topo.elemento;
        topo = topo.proximo;
        return e;
    }

    public void exibirPilha() {
        if (vazia()) {
            System.out.println("Histórico vazio!");
            return;
        }
        No atual = topo;
        System.out.println("\n--- Histórico de Solicitações ---");
        while (atual != null) {
            System.out.println(atual.elemento.id + " - " + atual.elemento.descricao + " (" + atual.elemento.dataHora + ")");
            atual = atual.proximo;
        }
    }
}


public class PilhaHistorico {
    public static void main(String[] args) {

        Pilha historico = new Pilha();

        historico.empilhar(new Elemento("REQ001", "Instalação de software", "2024-08-20 10:30"));
        historico.empilhar(new Elemento("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
        historico.empilhar(new Elemento("REQ003", "Atualização de sistema", "2024-08-20 11:30"));
        historico.empilhar(new Elemento("REQ004", "Suporte técnico", "2024-08-20 12:00"));

        historico.exibirPilha();

        System.out.println("\nRemovendo última solicitação...");
        Elemento removido = historico.desempilhar();
        if (removido != null) {
            System.out.println("Removido: " + removido.descricao);
        }

        historico.exibirPilha();
    }
}
