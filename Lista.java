import java.util.Scanner;

public class Lista {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n[ 1 ] Criar Lista de Tarefa.");
            System.out.println("[ 2 ] Sair.\n");
            System.out.println("Digite a opção desejada: ");
            String escolha = scanner.next();
            System.out.println("********************");

            switch (escolha) {
                case "1":
                    System.out.println("\n--- CRIAÇÃO DA LISTA DE TAREFA ---\n");
                    System.out.println("-> QUAL AÇÃO GOSTAIRA DE FAZER PRIMEIRO ?\n");
                    System.out.println("[ 1 ] Criar Tarefa.\n");
                    System.out.println("[ 2 ] Editar Tarefa.\n");
                    System.out.println("[ 3 ] Excluir Tarefa.\n");
                    String escolha2 = scanner.next();
                    
                        switch (escolha2){
                            case "1":{
                                criaTarefa();
                                break;
                            }
                            case "2":{
                                //editaTarefa();
                                break;
                            }
                            case "3":{
                               // excluiTarefa();
                                break;
                            }
                        }

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
    }

    private static void criaTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome da tarefa: ");
        String nome = scanner.nextLine();
        System.out.println("Informe a descricao da tarefa: ");
        String descricao = scanner.next();
        System.out.println("Informe a data da tarefa: ");
        int data = scanner.nextInt();

        System.out.println("O nome da tarefa criada é: " + nome + "\nA descrição da terefa criada é: " + descricao + "\nA data da terefa criada é: " + data + "\n" );
    }
}
