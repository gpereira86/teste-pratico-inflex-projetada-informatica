import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("-----------------------------------------------------");
        System.out.println("Funcionários:" + funcionarios.toString());

        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            if (f.getNome().equals("João")) {
                funcionarios.remove(i);
                break;
            }
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("Funcionários sem o João:" + funcionarios.toString());
        System.out.println("-----------------------------------------------------");


        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat formatoSalario = new DecimalFormat("#,##0.00");

        System.out.println("\n=============");
        System.out.println("Funcionários: ");
        System.out.println("=============");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                    "Nome: " + funcionario.getNome() +
                    "\nData de Nascimento: " + funcionario.getDataNascimento().format(formatoData) +
                    "\nSalário: " + formatoSalario.format(funcionario.getSalario()) +
                    "\nFunção: " + funcionario.getFuncao());
            System.out.println("--------------------------------------------------");
        }


        System.out.println("\n====================================================");
        System.out.println("Aumento de salário de %10 para todos os funcioários:");
        System.out.println("====================================================");

        System.out.printf("%-15s %-20s %-20s\n", "Nome", "Salário Antes", "Salário Depois");
        System.out.println("---------------------------------------------------");

        for (Funcionario funcionario : funcionarios) {
            String salarioAntes = formatoSalario.format(funcionario.getSalario());

            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            BigDecimal novoSalario = funcionario.getSalario().add(aumento);

            funcionario.setSalario(novoSalario);

            System.out.printf("%-15s %-20s %-20s\n", funcionario.getNome(), salarioAntes, formatoSalario.format(funcionario.getSalario()));
        }
        System.out.println("----------------------------------------------------");


        System.out.println("\n==================================================");
        System.out.println("       Funcionários agrupados por função:");
        System.out.println("==================================================");

        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();

            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }

            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Função " + funcao + ":");
            int i = 0;
            for (Funcionario funcionario : funcionariosPorFuncao.get(funcao)) {
                System.out.print(i > 0 ? "  ---------------------------------------------  \n":"");

                System.out.println("  Nome: " + funcionario.getNome());
                System.out.println("  Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData));
                System.out.println("  Salário: " + formatoSalario.format(funcionario.getSalario()));
                i++;
            }
            System.out.println("**************************************************");
        }


        System.out.println("\n=========================================================");
        System.out.println("Funcionários que fazem aniversário em outubro e dezembro:");
        System.out.println("=========================================================");

        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                System.out.println("  Nome: " + funcionario.getNome() +
                        " -> Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData));
            }
        }

        System.out.println("\n==============================");
        System.out.println("Funcionário com a maior idade:");
        System.out.println("==============================");

        Funcionario funcionarioMaiorIdade = null;
        LocalDate dataMaisAntiga = LocalDate.now();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(dataMaisAntiga)) {
                dataMaisAntiga = funcionario.getDataNascimento();
                funcionarioMaiorIdade = funcionario;
            }
        }

        if (funcionarioMaiorIdade != null) {
            LocalDate hoje = LocalDate.now();
            Period periodo = Period.between(funcionarioMaiorIdade.getDataNascimento(), hoje);
            int idade = periodo.getYears();

            System.out.println("Nome: " + funcionarioMaiorIdade.getNome());
            System.out.println("Idade: " + idade);

        } else {
            System.out.println("Nenhum funcionário encontrado.");
        }


        System.out.println("\n=================================");
        System.out.println("Funcionários em ordem alfabética:");
        System.out.println("=================================");

        Collections.sort(funcionarios, new Comparator<Funcionario>() {
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getNome().compareTo(f2.getNome());
            }
        });

        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                    "Nome: " + funcionario.getNome() +
                            "\nData de Nascimento: " + funcionario.getDataNascimento().format(formatoData) +
                            "\nSalário: " + formatoSalario.format(funcionario.getSalario()) +
                            "\nFunção: " + funcionario.getFuncao());
            System.out.println("--------------------------------------------------");
        }


        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        System.out.println("\n==================================================");
        System.out.println("Total dos salários dos funcionários: " + formatoSalario.format(totalSalarios));
        System.out.println("==================================================");



        System.out.println("\n===============================================");
        System.out.println("Quantidade de salários mínimos por funcionário:");
        System.out.println("===============================================");

        double salarioMinimo = 1212.00;

        System.out.printf("%-20s %-25s\n", "Nome", "Qtde. Salários Mínimos");
        System.out.println("-----------------------------------------------");

        for (Funcionario funcionario : funcionarios) {
            double quantSalariosMinimos = funcionario.getSalario().doubleValue() / salarioMinimo;
            System.out.printf("%-20s %-25s\n", funcionario.getNome(), String.format("       %.2f", quantSalariosMinimos));
        }

        System.out.println("-----------------------------------------------");

    }
}