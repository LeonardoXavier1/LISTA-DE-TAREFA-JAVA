import java.util.Scanner;


public class Lista {
    private static Scanner scanner;
    static GerenciadorDeTarefa GerenciadorDeTarefa = new GerenciadorDeTarefa();

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n[ 1 ] Criar Lista de Tarefa.");
            System.out.println("[ 2 ] Sair.\n");
            System.out.println("Digite a opção desejada: ");
            String escolha = scanner.next();
            scanner.nextLine();
            System.out.println("********************");

            switch (escolha) {
                case "1x'x":
                    System.out.println("\n--- CRIAÇÃO DA LISTA DE TAREFA ---\n");
                    System.out.println("-> QUAL AÇÃO GOSTAIRA DE FAZER PRIMEIRO ?\n");
                    System.out.println("[ 1 ] Criar Tarefa.\n");
                    System.out.println("[ 2 ] Editar Tarefa.\n");
                    System.out.println("[ 3 ] Excluir Tarefa.\n");
                    String escolha2 = scanner.nextLine();
                    Case1(escolha2);

                    break;
                case "2":
                    rodando = false;
                    System.out.println("\nEncerrada a sessão...\n");
                    Thread.sleep(2000);
                    System.out.println(".");
                    Thread.sleep(2000);
                    System.out.println(".");
                    Thread.sleep(2000);
                    System.out.println(".");
                    Thread.sleep(2000);
                    System.out.println("Sessão encerrada.");
                    break;
                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void Case1(String escolha2) throws InterruptedException {
        switch (escolha2) {
            case "1":
            GerenciadorDeTarefa.criaTarefa();
                break;
            case "2":
            GerenciadorDeTarefa.editaTarefa();
                break;
            case "3":
            GerenciadorDeTarefa.excluirTarefa();
                break;  
            default:
                System.out.println("Opção inválida, por favor tente novamente.");
                break;
        }
    }

}