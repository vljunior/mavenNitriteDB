package exemploaluno.repository;

import exemploaluno.domain.Aluno;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import java.util.List;

public class AlunoRepositoryNitrite {
    private final Nitrite db;
    private final ObjectRepository<Aluno> repo;

    public AlunoRepositoryNitrite() {
        this.db = Nitrite.builder()
                .filePath("alunos.db")
                .openOrCreate("user", "password");
        this.repo = db.getRepository(Aluno.class);
    }

    public void salvar(Aluno aluno) {
        repo.insert(aluno);
    }

    public List<Aluno> listarTodos() {
        return repo.find().toList();
    }

    // Buscar por matrícula (chave de negócio)
    public Aluno buscarPorMatricula(String matricula) {
        return repo.find(ObjectFilters.eq("matricula", matricula))
                   .firstOrDefault();
    }

    // Deletar por matrícula
    public void deletarPorMatricula(String matricula) {
        repo.remove(ObjectFilters.eq("matricula", matricula));
    }

    public void fechar() {
        db.close();
    }
}