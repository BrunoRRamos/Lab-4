import java.util.Scanner;

public class MainControleAlunos {
    public static void main(String[] args) {
        ControleAluno controleAluno = new ControleAluno();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controleAluno, scanner);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                        "(O)lhaí quais Grupos o Aluno Tá.\n" +
                        "(S)im, quero Fechar o Programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String opcao, ControleAluno controleAluno, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraAluno(scanner, controleAluno);
                break;
            case "E":
                exibeAluno(scanner, controleAluno);
                break;
            case "N":
                cadastraGrupo(scanner, controleAluno);
                break;
            case "A":
                alocarVerificar(scanner, controleAluno);
                break;
            case "O":

                break;
            case "S":

                break;

            default:
                System.out.println("Opção inválida!");
        }
    }
    private static void cadastraAluno(Scanner scanner, ControleAluno controleAluno) {
        System.out.println("Matrícula: ");
        String matricula = scanner.next();
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Curso: ");
        scanner.nextLine();
        String curso = scanner.nextLine();
        System.out.println(controleAluno.cadastraAluno(matricula, nome, curso));
    }

    private static void exibeAluno(Scanner scanner, ControleAluno controleAluno) {
        try {
            System.out.print("Matrícula: ");
            String matricula = scanner.next();
            System.out.println(controleAluno.exibeAluno(matricula));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastraGrupo(Scanner scanner, ControleAluno controleAluno) {
        System.out.print("\nGrupo: ");
        String nome = scanner.next();
        scanner.nextLine();
        System.out.print("\nTamanho: ");
        int numeroPessoas = scanner.nextInt();
        try {
            System.out.println(controleAluno.cadastraGrupo(nome, numeroPessoas));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void alocarVerificar(Scanner scanner, ControleAluno controleAluno) {
        String comandoEscolha = menuCadastraVerifica(scanner);
        try {
            escolhaCadastraVerifica(scanner, comandoEscolha, controleAluno);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("OPAÇÃO INVALIDA!");
        }
    }

    private static void escolhaCadastraVerifica(Scanner scanner, String opcao, ControleAluno controleAluno) {
        switch (opcao) {
            case "A":
                alocaAluno(scanner, controleAluno);
                return;
            case "P":
               return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static String menuCadastraVerifica(Scanner scanner) {
        System.out.print("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
        return scanner.next().toUpperCase();
    }

    private static void alocaAluno(Scanner scanner, ControleAluno controleAluno) {
        scanner.nextLine();
        System.out.print("\nMatricula: ");
        String matricula = scanner.nextLine();
        System.out.print("\nGrupo: ");
        String nomeGrupo = scanner.nextLine();
        try {
            System.out.println(controleAluno.cadastraAlunoGrupo(matricula, nomeGrupo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
