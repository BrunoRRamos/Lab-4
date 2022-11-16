import java.util.HashMap;

public class ControleAluno {
    private HashMap<String, Aluno> alunosMap = new HashMap<>();
    private HashMap<String, Grupo> gruposMap = new HashMap<>();

    public String cadastraAluno (String matricula, String nome, String curso) {
        if (alunosMap.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO JÁ CADASTRADO.");
        }
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        alunosMap.put(matricula, novoAluno);
        return "CADASTRO REALIZADO!";
    }

    public String cadastraGrupo (String nome, int numeroPessoas) {
        if (gruposMap.containsKey(nome)) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO.");
        }
        Grupo newGrupo = new Grupo(nome, numeroPessoas);
        gruposMap.put(nome, newGrupo);
        return "CADASTRO REALIZADO!";
    }

    public String cadastraAlunoGrupo(String matricula, String nomeGrupo) {
        Aluno aluno = buscaAluno(matricula);
        Grupo grupo = buscaGrupo(nomeGrupo);
        if (grupo.getNumeroMaxPessoas() == 0) {
            grupo.cadastraAlunoGrupo(matricula);
            aluno.alocaEmGrupo(nomeGrupo);
            return "ALUNO ALOCADO!";
        }
        if (grupo.getNumeroCadastrosAlunos() <= grupo.getNumeroMaxPessoas()) {
            grupo.cadastraAlunoGrupo(matricula);
            aluno.alocaEmGrupo(nomeGrupo);
            grupo.adicionaAluno();
            return "ALUNO ALOCADO!";
        }
        throw new IndexOutOfBoundsException("GRUPO CHEIO!");
    }

    public String exibeAluno(String matricula) {
        Aluno aluno = alunosMap.get(matricula);
        if (!(alunosMap.containsKey(matricula))){
            throw new NullPointerException("ALUNO NÃO CADASTRADO.");
        }
        return aluno.toString();
    }

    private void existeGrupo (String nome) {
        if (!gruposMap.containsKey(nome)) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO.");
        }
    }

    private void existeAluno(String matricula) {
        if (!alunosMap.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO JÁ CADASTRADO.");
        }
    }

    private Grupo buscaGrupo(String nomeGrupo) {
        existeGrupo(nomeGrupo);
        return gruposMap.get(nomeGrupo);
    }

    private Aluno buscaAluno(String matricula) {
        existeAluno(matricula);
        return alunosMap.get(matricula);
    }

    public String verificaAlunoGrupo(String grupoNome, String matricula) {
        Grupo grupo = buscaGrupo(grupoNome);
        Aluno aluno = buscaAluno(matricula);
        if (grupo.verificaCadastroAluno(aluno)) {
            return "ALUNO PERTENCE AO GRUPO.";
        }
        throw new IllegalArgumentException("ALUNO NÃO PERTENCE AO GRUPO.");
    }

}
