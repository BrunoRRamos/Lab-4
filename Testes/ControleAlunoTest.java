import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControleAlunoTest {

    private ControleAluno controleAluno = new ControleAluno();
    private Throwable exception;

    @BeforeEach
    void preparaAlunosGrupos() {
        controleAluno.cadastraAluno("250","Gabriel Reyes", "curso Computação");
        controleAluno.cadastraAluno("200", "Lili Camposh", "curso Computação");
        controleAluno.cadastraAluno("202", "Angela Ziegler", "curso Medicina");
        controleAluno.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    @Test
    void Caso_1() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 0));
    }

    @Test
    void Caso_2() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Listas", 10));
    }

    @Test
    void Caso_3() {
        controleAluno.cadastraGrupo("Listas", 10);

        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.cadastraGrupo("Listas", 10);
        });
        assertEquals("GRUPO JÁ CADASTRADO.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.cadastraGrupo("Listas", 0);
        });
        assertEquals("GRUPO JÁ CADASTRADO.", exception.getMessage());
    }

    @Test
    void Caso_4() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 0));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("202", "Programação OO"));
    }

    @Test
    void Caso_5() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 0));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("202", "Programação OO"));

        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.cadastraAlunoGrupo("200", "Programação OO");
        });
        assertEquals("Aluno alocado com Sucesso, mas não inserido novamente.", exception.getMessage());
    }

    @Test
    void Caso_6() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 0));

        exception = assertThrows(IllegalArgumentException.class, () -> {
           controleAluno.cadastraAlunoGrupo("100", "Programação OO");
        });
        assertEquals("ALUNO NÃO CADASTRADO.", exception.getMessage());
    }

    @Test
    void Caso_7() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.cadastraAlunoGrupo("200", "Anatomia");
        });
        assertEquals("GRUPO NÃO CADASTRADO.", exception.getMessage());
    }

    @Test
    void Caso_8() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Listas", 1));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("250", "Listas"));

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            controleAluno.cadastraAlunoGrupo("202", "Listas");
        });
        assertEquals("GRUPO CHEIO!", exception.getMessage());
    }

    @Test
    void Caso_9() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Listas", 0));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("250", "Listas"));
        assertEquals("ALUNO PERTENCE AO GRUPO.", controleAluno.verificaAlunoGrupo( "Listas", "250"));

        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.verificaAlunoGrupo("Listas", "202");
        });
        assertEquals("ALUNO NÃO PERTENCE AO GRUPO.", exception.getMessage());
    }

    @Test
    void Caso_10() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.verificaAlunoGrupo("Anatomia", "200");
        });
        assertEquals("GRUPO NÃO CADASTRADO.", exception.getMessage());
    }

    @Test
    void Caso_11() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 0));
        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.verificaAlunoGrupo("Programação OO", "100");
        });
        assertEquals("ALUNO NÃO CADASTRADO.", exception.getMessage());
    }

    @Test
    void Caso_12() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAluno.checagemGrupoAlunos("202");
        });
        assertEquals("O aluno não participa de grupos.", exception.getMessage());
    }

    @Test
    void Caso_13() {
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Programação OO", 10));
        assertEquals("CADASTRO REALIZADO!", controleAluno.cadastraGrupo("Listas", 10));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("250", "Listas"));
        assertEquals("ALUNO ALOCADO!", controleAluno.cadastraAlunoGrupo("250", "Programação OO"));
        assertEquals("- Listas 1/10\n- Programação OO 1/10\n", controleAluno.checagemGrupoAlunos("250"));

    }

}

