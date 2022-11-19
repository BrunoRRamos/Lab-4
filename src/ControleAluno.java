import java.util.ArrayList;
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
        if (aluno.getGruposAlocados().contains(nomeGrupo)) {
            throw new IllegalArgumentException("Aluno alocado com Sucesso, mas não inserido novamente.");
        }
        if (grupo.getNumeroMaxPessoas() == 0) {
            grupo.cadastraAlunoGrupo(matricula);
            aluno.alocaEmGrupo(nomeGrupo);
            grupo.adicionaAluno();
            return "ALUNO ALOCADO!";
        }
        if (grupo.getNumeroCadastrosAlunos() < grupo.getNumeroMaxPessoas()) {
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
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO.");
        }
    }

    private void existeAluno(String matricula) {
        if (!alunosMap.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
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
        existeAluno(matricula);
        if (alunosMap.containsKey(matricula)) {
            Grupo grupo = buscaGrupo(grupoNome);
            if (grupo.verificaCadastroAluno(matricula)) {
                return "ALUNO PERTENCE AO GRUPO.";
            }
        }
        throw new IllegalArgumentException("ALUNO NÃO PERTENCE AO GRUPO.");
    }

    public String checagemGrupoAlunos(String matricula) {
        String relacaoDeGrupos = "";
        Aluno aluno = buscaAluno(matricula);
        ArrayList<String> gruposAlocados = aluno.getGruposAlocados();
        for (int i = 0; i < gruposAlocados.size(); i++) {
            String infoGrupo = buscaGrupo(gruposAlocados.get(i)).toString();
            relacaoDeGrupos += infoGrupo + "\n";
        }
        if (relacaoDeGrupos.isEmpty()) {
            throw new IllegalArgumentException("O aluno não participa de grupos.");
        }
        return relacaoDeGrupos;
    }
}