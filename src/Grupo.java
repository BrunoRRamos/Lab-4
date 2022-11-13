import java.util.ArrayList;

public class Grupo {
    private String nome;
    private int numeroCadastrosAlunos;
    private int numeroMaxPessoas;
    private ArrayList<String> grupoAlunosList;

    public Grupo(String nome, int numeroPessoas) {
        this.nome = nome;
        this.numeroCadastrosAlunos = 0;
        this.numeroMaxPessoas = numeroPessoas;
        this.grupoAlunosList = new ArrayList();
    }

    public int getNumeroMaxPessoas() {
        return this.numeroMaxPessoas;
    }

    public int getNumeroCadastrosAlunos() {
        return numeroCadastrosAlunos;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionaAluno() {
        this.numeroCadastrosAlunos += 1;
    }

    public void cadastraAlunoGrupo(String matriculaAluno) {
        this.grupoAlunosList.add(matriculaAluno);
    }
}
