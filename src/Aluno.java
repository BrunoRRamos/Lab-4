import java.util.ArrayList;

/**
 * Classe responsável por representar um aluno no sistema.
 * @author Bruno Rodrigues Ramos
 */
public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private ArrayList gruposAlocados;

    /**
     * Construtor que inicializa as variáveis mtricula, nome do aluno, curso e
     * a lista de grupos que o aluno participa.
     * @param matricula Número da matricula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {
        this.gruposAlocados = new ArrayList();
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Override do método toString da classe Object;
     * @return String (matrícula, nome e curso do aluno)
     */
    @Override
    public String toString() {
        return String.format("Aluno: %s - %s - %s", this.matricula, this.nome, this.curso);
    }

    /**
     * Override do método hashCode. Verificando se os endereços de memória são igauis.
     * @return Boleano true ou false.
     */
    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + (matricula == null ? 0 : matricula.hashCode());
        return resultado;
    }

    /**
     * Adiciona o nome de um grupo ao ArrayList dos grupos que o aluno participa.
     * @param nomeGrupo Nome do grupo que o aluno participa.
     */
    public void alocaEmGrupo(String nomeGrupo) {
        this.gruposAlocados.add(nomeGrupo);
    }

    /**
     * Override do método equals. Verifica se a matrícula é igual a outra pré-cadastrada.
     * @param obj Um aluno a ser verificado.
     * @return Boleano true ou false.
     */
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

    /**
     * Retorna um ArrayLista contendo os nomes de todos os grupos que o aluno participa
     * @return
     */
    public ArrayList<String> getGruposAlocados() {
        return this.gruposAlocados;
    }
}