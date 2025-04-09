programa
{
	/*Criar dois vetores com 5 posições um para ler o nome  e outro para ler a altura de pessoas a partir do teclado, 
	criticar para não ter alturas inferiores a zero. No final deverá ser impresso o vetor com as informações das pessoas.*/

	/* Grupo 2
	 *  Daniele Dias
	 *  Delmir
	 *  Gabriela Couto
	 *  Marcos Medeiros
	 *  Mariana Monteiro
	 */
	 
	funcao inicio()
	{
		cadeia nomes[5]
		real alturas[5] 
		
		para(inteiro i=0; i < 5; i++){
			escreva("Digite seu nome: \n")
			leia(nomes[i])

			escreva("Digite sua altura: \n")
			leia(alturas[i])

			limpa()
			se(alturas[i] <= 0){

				escreva("Essa altura é inválida \n")
				escreva("Digite sua altura:")
				leia(alturas[i])
			}
		}
			limpa()
			para(inteiro i=0; i < 5; i++){
				escreva(nomes[i], " sua altura é: ", alturas[i], "\n")
			
				
			}

			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 421; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */