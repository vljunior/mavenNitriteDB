package exemplo.domain;

import exemplo.domain.Aluno;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import java.util.List;

public class AlunoRepositoryNitrite {
    private final Nitrite db;
    private final ObjectRepository<Aluno> repo;

    public AlunoRepositoryNitrite() {
        this.db = Nitrite.builder()
                .filePath("alunos.db")   // cria/abre o arquivo do banco
                .openOrCreate("user", "password");

        this.repo = db.getRepository(Aluno.class);
    }

    public void salvar(Aluno aluno) {
        repo.insert(aluno);
    }

    public List<Aluno> listarTodos() {
        return repo.find().toList();
    }

    public Aluno buscarPorMatricula(String matricula) {
        return repo.getById(matricula);
    }

    public void deletar(String matricula) {
        Aluno a = repo.getById(matricula);
        if (a != null) repo.remove(a);
    }

    public void fechar() {
        db.close();
    }
}

