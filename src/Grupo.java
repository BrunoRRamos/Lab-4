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

    @Override
    public String toString() {
        if (this.numeroMaxPessoas == 0) {
            return String.format("- %s %s", this.nome, this.numeroCadastrosAlunos);
        }
        return String.format("- %s %s/%s", this.nome, this.numeroCadastrosAlunos, this.numeroMaxPessoas);
    }

    public void cadastraAlunoGrupo(String matriculaAluno) {
        this.grupoAlunosList.add(matriculaAluno);
    }
}
