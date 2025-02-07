# TESTE PRÁTICO PROGRAMAÇÃO - PROJETADA INFORMÁTICA
Este projeto é uma solução de gestão de funcionários, desenvolvida em `Java`, como parte do processo seletivo para a vaga de estágio na `Projetada Informática`.

O sistema permite gerenciar informações dos funcionários, como dados pessoais, salários, funções e aniversários, com funcionalidades para ordenar, agrupar e calcular salários, utilizando `Collections` para manipulação eficiente dos dados.

O projeto foi desenvolvido com `boas práticas de programação`, utilizando `orientação a objetos` para garantir organização e clareza no código.

## Requisitos:

### 1 – Classe `Pessoa`
- **Atributos**:
    - `nome` (String)
    - `dataNascimento` (LocalDate)
---

### 2 – Classe `Funcionario`
- Deve estender a classe `Pessoa`.
- **Atributos**:
    - `salario` (BigDecimal)
    - `funcao` (String)
---

### 3 – Classe `Principal`
Deve executar as seguintes ações:

#### 3.1 – Inserir todos os funcionários:
- Inserir os funcionários na mesma ordem e informações da tabela abaixo:

| Nome     | Data Nascimento | Salário   | Função        |
|----------|-----------------|-----------|---------------|
| Maria    | 18/10/2000      | 2009.44   | Operador      |
| João     | 12/05/1990      | 2284.38   | Operador      |
| Caio     | 02/05/1961      | 9836.14   | Coordenador   |
| Miguel   | 14/10/1988      | 19119.88  | Diretor       |
| Alice    | 05/01/1995      | 2234.68   | Recepcionista |
| Heitor   | 19/11/1999      | 1582.72   | Operador      |
| Arthur   | 31/03/1993      | 4071.84   | Contador      |
| Laura    | 08/07/1994      | 3017.45   | Gerente       |
| Heloísa  | 24/05/2003      | 1606.85   | Eletricista   |
| Helena   | 02/09/1996      | 2799.93   | Gerente       |

#### 3.2 – Remover o funcionário “João” da lista.

#### 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
- Informações de data devem ser exibidas no formato `dd/MM/yyyy`.
- Informações numéricas devem ser formatadas com separador de milhar como ponto e decimal como vírgula.

#### 3.4 – Atualizar salários com 10% de aumento:
- Atualizar a lista de funcionários com o novo valor do salário.

#### 3.5 – Agrupar os funcionários por função:
- Agrupar em um `Map` onde:
    - **Chave:** função do funcionário.
    - **Valor:** lista de funcionários.

#### 3.6 – Imprimir os funcionários agrupados por função.

#### 3.7 (3.8) – Imprimir os funcionários que fazem aniversário nos meses 10 e 12.

#### 3.8 (3.9) – Imprimir o funcionário com a maior idade:
- Exibir os atributos: `nome` e `idade`.

#### 3.9 (3.10) – Imprimir a lista de funcionários em ordem alfabética.

#### 3.10 (3.11) – Imprimir o total dos salários dos funcionários.

#### 3.11 (3.12) – Imprimir quantos salários mínimos cada funcionário ganha:
- Considere que o salário mínimo é `R$1212.00`.

> **Orientações gerais:** <br> • Pode ser utilizada a ferramenta com maior domínio (exemplos: eclipse, netbeans etc); 
<br>• Após finalizado o desenvolvimento, exportar o projeto e disponibilizar o link do seu teste no campo disponível na `etapa Mão na Massa 🖐`. Basta Colar o link ainda nessa etapa.
<br>• Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.
