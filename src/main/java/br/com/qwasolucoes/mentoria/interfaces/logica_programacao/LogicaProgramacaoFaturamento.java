package br.com.qwasolucoes.mentoria.interfaces.logica_programacao;

/**
 * Exercícios de faturamento
 * 
 * O usuário irá informar o faturamento semanal sequencialmente, desprezando os centavos
 *
 * Integer arrayTemp = [16];
 * Após informar todos os faturamentos de um quadrimestre, ele irá solicitar uma série de relatórios.
 * 
 * - RESTRIÇÕES
 * Deve utilizar apenas arrays (modelo <a href="https://docs.google.com/drawings/d/1WBfdH9jK1cA2xpi5stlrss3dI2KwySEyvfl6QHFgbRY/edit?usp=sharing">nesta imagem</a>.)
 * Truncar valores ao invés de arredondar
 * Não utilizar nenhuma biblioteca de cálculo (Math) ou de manipulação de arrays, listas e/ou coleções (Lists, Arrays, etc.)
 * 
 * @author Fernando Nissizaki
 *
 */
public interface LogicaProgramacaoFaturamento {
	
	/**
	 * Deve adicionar os dados de um faturamento na sequencia
	 * @param mes
	 * @param faturamento
	 */
	public void adicionarFaturamentoSemanal(int faturamento);
	
	/**
	 * Retorna os faturamentos semanais na sequencia em que foram incluídos
	 * @return
	 */
	public int[] obterFaturamentosSemanais();
	
	/**
	 * Calcula o faturamento total no quadrimestre
	 * @return
	 */
	public int calcularFaturamentoTotal();
	
	/**
	 * Calcula o faturamento mensal
	 * @return
	 */
	public int[] calcularFaturamentoMensal();
	
	/**
	 * Calcula o faturamento bimestral
	 * @return
	 */
	public int[] calcularFaturamentoBimestral();
	
	/**
	 * Calcula o faturamento médio
	 * @return
	 */
	public int calcularFaturamentoMedio();
	
	/**
	 * Calcula o faturamento médio de cada mês
	 * @return
	 */
	public int[] calcularFaturamentoMedioDoMes();
	
	/**
	 * Calcula o faturamento médio por semana do mês.
	 * EX: Faturamento mmédio da primeira semana = soma das primeiras semanas / quantidade de meses
	 * @return
	 */
	public int[] calcularFaturamentoMedioPorSemanaDoMes();
	
	/**
	 * Obter o mês de maior faturamento
	 * @return
	 */
	public int obterMesMaiorFaturamento();
	
	/**
	 * Obter o mês de menor faturamento
	 * @return
	 */
	public int obterMesMenorFaturamento();
	

}
