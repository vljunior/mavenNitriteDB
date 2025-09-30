package exemplo.domain;

import exemplo.domain.Aluno;
import exemplo.repository.AlunoRepositoryNitrite;
import java.util.List;

public class AlunoService {
    private final AlunoRepositoryNitrite repo;

    public AlunoService(AlunoRepositoryNitrite repo) {
        this.repo = repo;
    }

    public void cadastrarAluno(Aluno aluno) { repo.salvar(aluno); }
    public List<Aluno> listarAlunos() { return repo.listarTodos(); }
    public Aluno buscarPorMatricula(String matricula) { return repo.buscarPorMatricula(matricula); }
    public void removerAluno(String matricula) { repo.deletar(matricula); }
}
