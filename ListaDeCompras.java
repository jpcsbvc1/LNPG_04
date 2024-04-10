import java.util.ArrayList;

public class ListaDeCompras {

    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        lista.adicionarItem("Maçã");
        lista.adicionarItem("Banana");
        lista.adicionarItem("Pêra");
        lista.removerItem("Banana");
        lista.removerItem("Laranja");
        lista.exibirLista();
    }

    private ArrayList<String> itens;

    public ListaDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        try {
            if (item != null && !item.isEmpty()) {
                itens.add(item);
                System.out.println("Item adicionado: " + item);
            } else {
                throw new Exception("O item não pode ser nulo ou vazio.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    public void removerItem(String item) {
        try {
            if (item != null && !item.isEmpty()) {
                if (itens.contains(item)) {
                    itens.remove(item);
                    System.out.println("Item removido: " + item);
                } else {
                    System.out.println("Não existe esse produto na lista: " + item);
                }
            } else {
                throw new Exception("O item não pode ser nulo ou vazio.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover item: " + e.getMessage());
        }
    }

    public void exibirLista() {
        try {
            if (!itens.isEmpty()) {
                System.out.println("Lista de Compras:");
                for (String item : itens) {
                    System.out.println("- " + item);
                }
            } else {
                System.out.println("Lista de Compras está vazia.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir lista: " + e.getMessage());
        }
    }
}
