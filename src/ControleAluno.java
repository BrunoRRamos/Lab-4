import java.util.ArrayList;
import java.util.HashMap;

public class ControleAluno {
    private HashMap<String, Aluno> alunosMap = new HashMap<>();
    private ArrayList<Grupo> gruposList = new ArrayList<>();

    public String cadastraAluno (String matricula, String nome, String curso) {
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        if (!(existeAluno(novoAluno))) {
            alunosMap.put(matricula, novoAluno);
            return "CADASTRO REALIZADO!";
        }
        throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
    }

    public String cadastraGrupo (String nome, int numeroPessoas) {
        existeGrupo(nome);
        Grupo newGrupo = new Grupo(nome, numeroPessoas);
        gruposList.add(newGrupo);
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
        if (aluno == null) {
            throw new NullPointerException("ALUNO NÃO CADASTRADO.");
        }
        return aluno.toString();
    }

    private void existeGrupo (String nome) {
        for (int i = 0; i < gruposList.size(); i++) {
            Grupo grupoAtual = gruposList.get(i);
            if (grupoAtual.getNome().equalsIgnoreCase(nome)) {
                throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
            }
        }
    }

    private boolean existeAluno(Aluno aluno) {
        return this.alunosMap.containsKey(aluno.getMatricula());
    }

    private Grupo buscaGrupo(String nomeGrupo) {
        for (int i = 0; i < gruposList.size(); i++) {
            Grupo grupoAtual = gruposList.get(i);
            if (grupoAtual.getNome().equalsIgnoreCase(nomeGrupo)){
                return grupoAtual;
            }
        }
        throw new IllegalArgumentException("GRUPO NÃO CADASTRADO!");
    }

    private Aluno buscaAluno(String matricula) {
        try {
            return alunosMap.get(matricula);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO!");
        }
    }

}
