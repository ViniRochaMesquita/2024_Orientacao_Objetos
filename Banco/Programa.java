import java.util.*;
public class Programa {
    public static void main(String [] args) {
       
        HashMap<String, Cliente> mapaCliente = new HashMap<String, Cliente>(); //um mapa para guardar os clientes do banco
        HashMap<String, Conta>   mapaConta   = new HashMap<String, Conta>();   //um mapa para guardar as contas do banco

        Scanner scanner = new Scanner(System.in);
        byte opcao;

        mainloop:do{
            //mostra o menu
            System.out.println(getMenu()); 
            opcao = Byte.parseByte(scanner.nextLine());
          
            //decisão de qual ação fazer           
            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de cliente ------------------------");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf_1 = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String fone = scanner.nextLine();
                    mapaCliente.put(cpf_1, new Cliente(nome, cpf_1, fone)); //insere no mapa um novo cliente, tendo como chave o CPF e como valor a instância de cliente. Logo, cada valor é uma referência
                    break;
                case 2:
                    System.out.println("Cadastro de conta -----------------------------------------------");
                    System.out.print("Número da agência: ");
                    String agencia = scanner.nextLine();
                    System.out.print("Número da conta: ");
                    String nConta = scanner.nextLine();
                    System.out.println("Clientes cadastrados \nCPF - Nome completo");
                    System.out.println(listarClientes(mapaCliente)); //lista todos os clientes já cadastrado, para o atendente saber quem é o dono da conta
                    System.out.print("CPF: ");
                    String cpf_2 = scanner.nextLine();
                    System.out.print("Limite: ");
                    double limite = Double.parseDouble(scanner.nextLine());
                    mapaConta.put(nConta, new Conta(agencia, nConta, mapaCliente.get(cpf_2), limite)); 
                    break;
                case 3:
                    System.out.println("Relatório de uma conta");
                    System.out.print("Número da conta: ");
                    System.out.println((mapaConta.get(scanner.nextLine())).get_Relatorio());
                    break;
                case 4:
                    System.out.println(listarClientes(mapaCliente)); 
                    break;
                case 5: 
                    System.out.println("Você escolheu encerrar o sistema");
                    break mainloop; //encerra o do/while
                default:
                    System.err.println("Você escolheu uma opção inválida");
                    break;
            }
        }while(opcao != 5);
    }

    public static String getMenu(){
        String menu = ""+
        "|> Menu Principal ============="+
        "\n1. Cadastrar cliente"+
        "\n2. Cadastrar conta"+
        "\n3. Relatorio de conta"+
        "\n4. Listar clientes"+
        "\n5. Transferencia"+
        "\n6. Depósito"+
        "\n7. Saque"+
        "\n5. Sair\n"+
        "\n============================";
        return menu;
    }
    /**
     * Lista todos os clientes contidos em um mapa de clientes
     * @param m é um Mapa de clientes
     */
    public static String listarClientes(HashMap<String, Cliente> m){ //retorna a lista (em string) de todos os dados de nome e CPF dos clientes cadastrados
        String s = "";
        for (String k : m.keySet()) {
            s += k + " - " + m.get(k).getNome() + "\n";
        }
        return s;
    }


}

