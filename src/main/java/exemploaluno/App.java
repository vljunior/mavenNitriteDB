package exemploaluno;

import java.util.List;

import exemploaluno.dominio.Aluno;
import exemploaluno.repositorio.AlunoRepositorioNitrite;
import exemploaluno.servico.AlunoServico;

public class App {
    public static void main(String[] args) {
        
        AlunoRepositorioNitrite repositorio = new AlunoRepositorioNitrite();

        AlunoServico service = new AlunoServico(repositorio);

        service.cadastrarAluno(new Aluno("2025001", "Lorenzon", 20));
        service.cadastrarAluno(new Aluno("2025002", "Maria", 22));

        System.out.println("Alunos cadastrados:");
        
        // lista com for-each
        System.out.println("Todos os alunos:");
        List<Aluno> alunos = service.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        // busca por matrícula
        System.out.println("\nBuscar por matrícula 2025001:");
        System.out.println(service.buscarPorMatricula("2025001"));

        // deletar por matrícula
        service.removerPorMatricula("2025002");

        // lista novamente após remoção
        System.out.println("\nApós remover Maria:");
        alunos = service.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
        
        repositorio.fechar();
    }
}
