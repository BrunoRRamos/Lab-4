import java.util.ArrayList;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private ArrayList gruposAlocados;

    public Aluno(String matricula, String nome, String curso) {
        this.gruposAlocados = new ArrayList();
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.format("Aluno: %s - %s - %s", matricula, nome, curso);
    }

    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + (matricula == null ? 0 : matricula.hashCode());
        return resultado;
    }

    public void alocaEmGrupo(String nomeGrupo) {
        this.gruposAlocados.add(nomeGrupo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Aluno) {
            Aluno aluno = (Aluno) obj;
            return this.matricula.equals(aluno.matricula);
        }
        return false;
    }

}
