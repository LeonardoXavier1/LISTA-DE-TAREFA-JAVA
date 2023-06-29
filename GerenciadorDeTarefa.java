import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefa{
    private  List<Tarefa> listaTarefas = new ArrayList<>();
    private  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    }

    void criaTarefa() throws InterruptedException {
        System.out.println("\nInforme o nome da tarefa: \n");
        String nome = scanner.nextLine();
        System.out.println("\nInforme a descricao da tarefa: \n");
        String descricao = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Não permite datas inválidas

        String data = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.println("\nInforme a data da tarefa (dd/mm/yyyy): \n");
            data = scanner.nextLine();

            try {
                dateFormat.parse(data);
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("\nData inválida. Tente novamente.");
            }
        }

        String dataFormatada = data;

        Tarefa tarefa = new Tarefa(nome, descricao, dataFormatada);
        listaTarefas.add(tarefa);

        System.out.println("\n*** TAREFA CRIADA ***\n");
        Thread.sleep(3000);
        System.out.println("\nO nome da tarefa criada é: " + nome + "\nA descrição da tarefa criada é: " + descricao + "\nA data da tarefa criada é: " + dataFormatada + "\n");

            
        boolean continuar = true;
        while (continuar == true) {
            System.out.println("\n-> QUAL AÇÃO DESEJA REALIZAR AGORA ?\n");
            System.out.println("[ 1 ] Criar Tarefa.\n");
            System.out.println("[ 2 ] Editar Tarefa.\n");
            System.out.println("[ 3 ] Excluir Tarefa.\n");
            System.out.println("[ 4 ] Visualizar Tarefas.\n");
            System.out.println("[ 5 ] Voltar ao menu principal.\n");
            System.out.println("[ 6 ] Alterar status da tarefa.");

            String escolha3 = scanner.nextLine();

            switch (escolha3) {
                case "1":
                    criaTarefa();
                    break;
                case "2":
                    editaTarefa();
                    break;
                case "3":
                    excluirTarefa();
                    break;
                case "4":
                    exibirTarefas();
                    break;
                case "5":
                    continuar = false;
                    break;
                case "6":
                    statusTarefa();
                    break;
                default:
                    System.out.println("\nOpção inválida, por favor tente novamente.\n");
                    break;
            }
        }
    }



        void editaTarefa() throws InterruptedException {
            if (listaTarefas.isEmpty()) {
                System.out.println("\nNão há tarefas disponíveis para editar.\n");
                Thread.sleep(2000);
                System.out.println("*** POR FAVOR CRIE A TAREFA PARA EDITAR *** ");
                Thread.sleep(1000);
                criaTarefa();
                return;
            }
    
            System.out.println("\nSelecione a tarefa que deseja editar:\n");
            for (int i = 0; i < listaTarefas.size(); i++) {
                Tarefa tarefa = listaTarefas.get(i);
                System.out.println("[" + (i + 1) + "] " + tarefa.getNome());
            }
    
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
    
            if (escolha < 1 || escolha > listaTarefas.size()) {
                System.out.println("\nOpção inválida. Tente novamente.\n");
                return;
            }
    
            Tarefa tarefaSelecionada = listaTarefas.get(escolha - 1);
    
            System.out.println("\nTarefa selecionada:\n");
            System.out.println("\nNome: " + tarefaSelecionada.getNome() + "\n");
            System.out.println("\nDescrição: " + tarefaSelecionada.getDescricao() + "\n");
            System.out.println("\nData: " + tarefaSelecionada.getData() + "\n");
    
            System.out.println("\nDigite o novo nome da tarefa:");
            String novoNome = scanner.nextLine();
            tarefaSelecionada.setNome(novoNome);
    
            System.out.println("\nDigite a nova descrição da tarefa:");
            String novaDescricao = scanner.nextLine();
            tarefaSelecionada.setDescricao(novaDescricao);
    
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); // Não permite datas inválidas
    
            String novaData = null;
            boolean dataValida = false;
            while (!dataValida) {
                System.out.println("\nDigite a nova data da tarefa (dd/mm/yyyy):");
                novaData = scanner.nextLine();
    
                try {
                    dateFormat.parse(novaData);
                    dataValida = true;
                } catch (ParseException e) {
                    System.out.println("\nData inválida. Tente novamente.");
                }
            }
    
            tarefaSelecionada.setData(novaData);
    
            System.out.println("\nTarefa editada com sucesso!");
        }
    
        void excluirTarefa() throws InterruptedException {
            if (listaTarefas.isEmpty()) {
                System.out.println("\nNão há tarefas disponíveis para excluir.\n");
                Thread.sleep(2000);
                System.out.println("*** POR FAVOR CRIE A TAREFA PARA EDITAR *** ");
                Thread.sleep(1000);
                criaTarefa();
                return;
            }
    
            System.out.println("\nSelecione a tarefa que deseja excluir:\n");
            for (int i = 0; i < listaTarefas.size(); i++) {
                Tarefa tarefa = listaTarefas.get(i);
                System.out.println("[" + (i + 1) + "] " + tarefa.getNome());
            }
    
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
    
            if (escolha < 1 || escolha > listaTarefas.size()) {
                System.out.println("\nOpção inválida. Tente novamente.\n");
                return;
            }
    
            Tarefa tarefaSelecionada = listaTarefas.get(escolha - 1);
    
            System.out.println("\nTarefa selecionada:\n");
            System.out.println("\nNome: " + tarefaSelecionada.getNome() + "\n");
            System.out.println("\nDescrição: " + tarefaSelecionada.getDescricao() + "\n");
            System.out.println("\nData: " + tarefaSelecionada.getData() + "\n");
    
            System.out.println("\nTem certeza de que deseja excluir esta tarefa? (S/N)");
            String confirmacao = scanner.nextLine();
    
            if (confirmacao.equalsIgnoreCase("S")) {
                listaTarefas.remove(tarefaSelecionada);
                System.out.println("\nTarefa excluída com sucesso!");
            } else {
                System.out.println("\nA exclusão da tarefa foi cancelada.");
            }
        }
    
        private  void exibirTarefas() throws InterruptedException {
            if (listaTarefas.isEmpty()) {
                System.out.println("\nNão há tarefas disponíveis para visualizar.\n");
                Thread.sleep(2000);
                System.out.println("*** POR FAVOR CRIE A TAREFA PARA VISUALIZAR *** ");
                Thread.sleep(1000);
                criaTarefa();
                return;
            }else {
                System.out.println("\n--- LISTA DE TAREFAS ---\n");
                for (int i = 0; i < listaTarefas.size(); i++) {
                    Tarefa tarefa = listaTarefas.get(i);
                    System.out.println("Tarefa " + (i + 1) + ":");
                    System.out.println("Nome: " + tarefa.getNome());
                    System.out.println("Descrição: " + tarefa.getDescricao());
                    System.out.println("Data: " + tarefa.getData());
                    System.out.println("------------------------");
            }
        
            System.out.println("\n--- STATUS DAS TAREFAS ---\n");
            for (int i = 0; i < listaTarefas.size(); i++) {
                Tarefa tarefa = listaTarefas.get(i);
                String status = tarefa.isConcluida() ? "[ X ]" : "[  ]";
                System.out.println("[" + (i + 1) + "] " + status + " " + tarefa.getNome());
            }
        
            System.out.println();
            Thread.sleep(2000);
        }
        }
        
        private  void statusTarefa() throws InterruptedException {
            if (listaTarefas.isEmpty()) {
                System.out.println("\nNão há tarefas disponíveis para alterar o status.\n");
                Thread.sleep(2000);
                System.out.println("*** POR FAVOR CRIE A TAREFA PARA ALTERAR O STATUS *** ");
                Thread.sleep(1000);
                criaTarefa();
                return;
            }
    
            System.out.println("\nSelecione a tarefa cujo status você deseja alterar:\n");
            for (int i = 0; i < listaTarefas.size(); i++) {
                Tarefa tarefa = listaTarefas.get(i);
                String status = tarefa.isConcluida() ? "[X]" : "[ ]";
                System.out.println("[" + (i + 1) + "] " + status + " " + tarefa.getNome());
            }
    
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
    
            if (escolha < 1 || escolha > listaTarefas.size()) {
                System.out.println("\nOpção inválida. Tente novamente.\n");
                return;
            }
    
            Tarefa tarefaSelecionada = listaTarefas.get(escolha - 1);
            tarefaSelecionada.setConcluida(!tarefaSelecionada.isConcluida());
    
            System.out.println("\n*** STATUS DA TAREFA ALTERADO COM SUCESSO ***\n");
            Thread.sleep(2000);
        }
    }