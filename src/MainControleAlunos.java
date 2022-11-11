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

                break;
            case "A":

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
            System.out.println("Aluno não existe");
        }
    }
}
