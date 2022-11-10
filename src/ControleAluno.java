import java.util.HashMap;

public class ControleAluno {
    private HashMap<String, Aluno> alunosMap = new HashMap<>();

    public String cadastraAluno (String matricula, String nome, String curso) {
        alunosMap.put(matricula, new Aluno(matricula, nome, curso));
        return "";
    }

    private boolean verificaAluno (String matricula) {
        return false;
    }
}
