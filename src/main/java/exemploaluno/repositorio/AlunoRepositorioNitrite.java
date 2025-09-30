package exemploaluno.repositorio;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import exemploaluno.dominio.Aluno;

import java.util.List;

public class AlunoRepositorioNitrite {
    private final Nitrite db;
    private final ObjectRepository<Aluno> repo;

    public AlunoRepositorioNitrite() {
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

    //update - dar insert com o mesmo id

    public void atualizarAluno(Aluno aluno) {
        // Atualiza pelo campo @Id (matricula)
        repo.update(aluno, true); 
    }

    public void atualizarNomePorMatricula(String matricula, String novoNome) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            repo.update(aluno, true);
        }
    }

    public void fechar() {
        db.close();
    }
}