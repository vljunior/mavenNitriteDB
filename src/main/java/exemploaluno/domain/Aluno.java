package exemplo.domain;

import org.dizitart.no2.objects.Id;

public class Aluno {
    @Id
    private String matricula;
    private String nome;
    private int idade;

    public Aluno() {} // construtor vazio exigido pelo Nitrite

    public Aluno(String matricula, String nome, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }

    @Override
    public String toString() {
        return "Aluno{matricula='" + matricula + "', nome='" + nome + "', idade=" + idade + "}";
    }
}

