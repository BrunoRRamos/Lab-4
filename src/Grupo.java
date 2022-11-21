import java.util.ArrayList;

/**
 * Classe responsável por representar um Grupo no sistema e seus comportamentos.
 * @author Bruno Rodrigues Ramos
 */
public class Grupo {
    private String nome;
    private int numeroCadastrosAlunos;
    private int numeroMaxPessoas;
    private ArrayList<String> grupoAlunosList;

    /**
     * Construtor responsável por instanciar os atributos (Nome, numeroCadastrosAlunos, numeroMaxPessoas, grupoAlunosList).
     * @param nome Nome do grupo.
     * @param numeroPessoas Número máximo de pessoas no grupo (se for 0 não tem limite de alunos).
     */
    public Grupo(String nome, int numeroPessoas) {
        this.nome = nome;
        this.numeroCadastrosAlunos = 0;
        this.numeroMaxPessoas = numeroPessoas;
        this.grupoAlunosList = new ArrayList<>();
    }

    public int getNumeroMaxPessoas() {
        return this.numeroMaxPessoas;
    }

    public int getNumeroCadastrosAlunos() {
        return numeroCadastrosAlunos;
    }

    /**
     * Soma um ao valor do atributo numeroCadastrosAlunos.
     */
    public void adicionaAluno() {
        this.numeroCadastrosAlunos += 1;
    }

    /**
     * Sobre escreve o método toString da classe Object.
     * @return String com nome de grupo e a relação de ocupação das vagas do grupo.
     */
    @Override
    public String toString() {
        if (this.numeroMaxPessoas == 0) {
            return String.format("- %s %s/∞", this.nome, this.numeroCadastrosAlunos);
        }
        return String.format("- %s %s/%s", this.nome, this.numeroCadastrosAlunos, this.numeroMaxPessoas);
    }

    /**
     * Adiciona uma matrícula de aluno ao array list de participantes.
     * @param matriculaAluno Matrícula do aluno.
     */
    public void cadastraAlunoGrupo(String matriculaAluno) {
        this.grupoAlunosList.add(matriculaAluno);
    }

    /**
     * Verifica atraves da matrícula se um aluno faz parte do grupo.
     * @param matricula Matrícula do aluno.
     * @return Boleano true ou false.
     */
    public boolean verificaCadastroAluno(String matricula) {
        return this.grupoAlunosList.contains(matricula);
    }
}