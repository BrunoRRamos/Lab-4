public class Aluno {
    private String matricula;
    private String nome;
    private String curso;

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s\nNome: %s\nCurso: %s", matricula, nome, curso);
    }

}
