public class Aluno {
    private String matricula;
    private String nome;
    private String curso;

    public Aluno(String matricula, String nome, String curso) {
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
