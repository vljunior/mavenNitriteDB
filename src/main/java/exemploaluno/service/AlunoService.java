package exemploaluno.service;

import exemploaluno.domain.Aluno;
import exemploaluno.repository.AlunoRepositoryNitrite;
import org.dizitart.no2.NitriteId;
import java.util.List;

public class AlunoService {
    private final AlunoRepositoryNitrite repo;

    public AlunoService(AlunoRepositoryNitrite repo) {
        this.repo = repo;
    }

    public void cadastrarAluno(Aluno aluno) { repo.salvar(aluno); }

    public List<Aluno> listarAlunos() { return repo.listarTodos(); }

    // Métodos com ID técnico
    public Aluno buscarAluno(NitriteId id) { return repo.buscarPorId(id); }
    public void removerAluno(NitriteId id) { repo.deletarPorId(id); }

    // Métodos com chave de negócio
    public Aluno buscarPorMatricula(String matricula) { return repo.buscarPorMatricula(matricula); }
    public void removerPorMatricula(String matricula) { repo.deletarPorMatricula(matricula); }
}