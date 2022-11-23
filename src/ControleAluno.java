import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsável pela parte lógica do sistema.
 * Solicitando criação de alunos, grupos e seus respectivos comportamentos.
 */
public class ControleAluno {
    private HashMap<String, Aluno> alunosMap;
    private HashMap<String, Grupo> gruposMap;

    /**
     * Construtor, que instancia os HashMaps: alunosMap e gruposMap.
     */
    public ControleAluno() {
        this.alunosMap = new HashMap<>();
        this.gruposMap = new HashMap<>();
    }

    /**
     * Método responsável por criar um novo objeto do tipo Aluno.
     * @param matricula Matrícula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     * @return String de confirmação da criação do aluno.
     */
    public String cadastraAluno (String matricula, String nome, String curso) {
        if (alunosMap.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO JÁ CADASTRADO.");
        }
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        alunosMap.put(matricula, novoAluno);
        return "CADASTRO REALIZADO!";
    }

    /**
     * Método responsável por criar um novo objeto do tipo Grupo.
     * @param nome Nome do grupo.
     * @param numeroPessoas Número máximo de pessoas no grupo.
     * @return String de confirmação da criação do grupo.
     */
    public String cadastraGrupo (String nome, int numeroPessoas) {
        if (gruposMap.containsKey(nome.toUpperCase())) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO.");
        }
        Grupo newGrupo = new Grupo(nome, numeroPessoas);
        gruposMap.put(nome.toUpperCase(), newGrupo);
        return "CADASTRO REALIZADO!";
    }

    /**
     * Método responsável por alocar um aluno em um grupo.
     * @param matricula Matrícula do aluno a ser alocado no grupo.
     * @param nomeGrupo Nome do grupo que vai receber o aluno.
     * @return String de confirmação de alocação do aluno no grupo.
     */
    public String cadastraAlunoGrupo(String matricula, String nomeGrupo) {
        Aluno aluno = buscaAluno(matricula);
        Grupo grupo = buscaGrupo(nomeGrupo.toUpperCase());
        if (aluno.getGruposAlocados().contains(nomeGrupo.toUpperCase())) {
            throw new IllegalArgumentException("Aluno alocado com Sucesso, mas não inserido novamente.");
        }
        if (grupo.getNumeroMaxPessoas() == 0) {
            grupo.cadastraAlunoGrupo(matricula);
            aluno.alocaEmGrupo(nomeGrupo.toUpperCase());
            grupo.adicionaAluno();
            return "ALUNO ALOCADO!";
        }
        if (grupo.getNumeroCadastrosAlunos() < grupo.getNumeroMaxPessoas()) {
            grupo.cadastraAlunoGrupo(matricula);
            aluno.alocaEmGrupo(nomeGrupo.toUpperCase());
            grupo.adicionaAluno();
            return "ALUNO ALOCADO!";
        }
        throw new IndexOutOfBoundsException("GRUPO CHEIO!");
    }

    /**
     * Métoda responsável por exibir as informações do aluno; Matrícula, nome e curso.
     * @param matricula Número da matrícula do aluno a ser consultado.
     * @return String com as informações do aluno. (Matrícula, Nome e Curso)
     */
    public String exibeAluno(String matricula) {
        if (!(alunosMap.containsKey(matricula))){
            throw new NullPointerException("ALUNO NÃO CADASTRADO.");
        }
        Aluno aluno = alunosMap.get(matricula);
        return aluno.toString();
    }

    /**
     * Métoda responsável por verificar se um aluno pertence ou não a um grupo.
     * @param grupoNome Nome do grupo a ser consultado.
     * @param matricula Matrícula do aluno a ser consultado.
     * @return String de confirmação se o aluno pertence ou não ao grupo.
     */
    public String verificaAlunoGrupo(String grupoNome, String matricula) {
        existeAluno(matricula);
        if (alunosMap.containsKey(matricula)) {
            Grupo grupo = buscaGrupo(grupoNome.toUpperCase());
            if (grupo.verificaCadastroAluno(matricula)) {
                return "ALUNO PERTENCE AO GRUPO.";
            }
        }
        throw new IllegalArgumentException("ALUNO NÃO PERTENCE AO GRUPO.");
    }

    /**
     * Métoda responsável por listar todos os grupos que um aluno está participando.
     * @param matricula Matrícula do aluno a ser consultado.
     * @return String com a listagem dos grupos que o aluno participa.
     */
    public String checagemGrupoAlunos(String matricula) {
        String relacaoDeGrupos = "";
        Aluno aluno = buscaAluno(matricula);
        ArrayList<String> gruposAlocados = aluno.getGruposAlocados();
        for (int i = 0; i < gruposAlocados.size(); i++) {
            String infoGrupo = buscaGrupo(gruposAlocados.get(i)).toString();
            relacaoDeGrupos += infoGrupo + "\n";
        }
        if (relacaoDeGrupos.isBlank()) {
            throw new IllegalArgumentException("O aluno não participa de grupos.");
        }
        return relacaoDeGrupos;
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
}