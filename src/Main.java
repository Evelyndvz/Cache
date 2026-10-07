import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> banco = new ArrayList<>();
        List<Pessoa> cache = new ArrayList<>();

        banco.add(new Pessoa(1, "Ana Silva", 25));
        banco.add(new Pessoa(2, "Carlos Oliveira", 30));
        banco.add(new Pessoa(3, "Mariana Costa", 22));
        banco.add(new Pessoa(4, "João Pedro", 40));
        banco.add(new Pessoa(5, "Fernanda Lima", 28));

        Scanner scanner = new Scanner(System.in);
        IO.println("Digite o ID da pessoa: ");
        int idBuscado = scanner.nextInt();

        Pessoa pessoaEncontrada = null;

        for (Pessoa p : cache) {
            if (p.getId() == idBuscado) {
                pessoaEncontrada = p;
                break;
            }
        }

        if (pessoaEncontrada != null) {
           IO.println("Pessoa encontrada no cache: " + pessoaEncontrada.getNome());
        } else {

            for (Pessoa p : banco) {
                if (p.getId() == idBuscado) {
                    pessoaEncontrada = p;
                    break;
                }
            }

            if (pessoaEncontrada != null) {
                if (cache.size() >= 10) {
                    cache.remove(0);
                }

                cache.add(pessoaEncontrada);
                IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada.getNome());
            } else {
                IO.println("Pessoa não encontrada.");
            }
        }

        scanner.close();
    }
}