package exemploaluno.servico;

import exemploaluno.dominio.Aluno;
import exemploaluno.repositorio.AlunoRepositorioNitrite;

import org.dizitart.no2.NitriteId;
import java.util.List;

public class AlunoServico {

    private final AlunoRepositorioNitrite repositorio;

    public AlunoServico(AlunoRepositorioNitrite repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrarAluno(Aluno aluno) { 
        repositorio.salvar(aluno); 
    }

    public List<Aluno> listarAlunos() { 
        return repositorio.listarTodos(); 
    }

    // Métodos com ID técnico
    public Aluno buscarAluno(NitriteId id) { 
        return repositorio.buscarPorId(id); 
    }
    
    public void removerAluno(NitriteId id) { 
        repositorio.deletarPorId(id); 
    }

    // Métodos com chave de negócio
    public Aluno buscarPorMatricula(String matricula) { 
        return repositorio.buscarPorMatricula(matricula);     
    }

    public void removerPorMatricula(String matricula) { 
        repositorio.deletarPorMatricula(matricula); 
    }

}