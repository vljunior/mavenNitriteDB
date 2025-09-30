package exemploaluno.dominio;
import java.util.UUID;

import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;


//A entidade que se quer guardar no repositório
public class Aluno {
    
    /* Podemos ter então um identificador único para a entidade, neste caso ele deve ser do tipo 
     * NitriteId e deve ser construído no construtor padrão exigido pelo Nitrite.
     * Para casos onde a "chave primaria" seria um String, deve-se também mudar o tipo ára 
     * UUID e no construtor usar UUID.randomUUID().toString(); para atribuir valor
    */

    /*Atributo chave, único em valor para todos os objetos da entidade*/
    @Id
    private NitriteId id;
    /*Demais atributos*/
    private String matricula;
    private String nome;
    private int idade;

    /* O Nitrite exige um construtor sem argumentos. */

    public Aluno() {
       
    }    

    public Aluno(String matricula, String nome, int idade) {
        //this.id = NitriteId.newId();
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    public NitriteId getId()        { return id; }
    public String getMatricula()    { return matricula; }
    public String getNome()         { return nome; }
    public int getIdade()           { return idade; }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", matricula='" + matricula + "', nome='" + nome + "', idade=" + idade + "}";
    }
}

