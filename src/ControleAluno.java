import java.util.HashMap;

public class ControleAluno {
    private HashMap<String, Aluno> alunosMap = new HashMap<>();

    public String cadastraAluno (String matricula, String nome, String curso) {
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        if (!(existeAluno(novoAluno))) {
            alunosMap.put(matricula, novoAluno);
            return "CADASTRO REALIZADO!";
        } else {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
        }
    }

    public String exibeAluno(String matricula) {
        Aluno aluno = alunosMap.get(matricula);
        return aluno.toString();
    }

    private boolean existeAluno(Aluno aluno) {
        return this.alunosMap.containsKey(aluno.getMatricula());
    }

}
