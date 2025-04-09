programa
{
	/* Grupo 2
	 *  Daniele Dias
	 *  Delmir
	 *  Gabriela Couto
	 *  Marcos Medeiros
	 *  Mariana Monteiro
	 */
	 
	cadeia vaga[30], placa
	inteiro num	
	
	funcao inicio()
	{
		para (inteiro i = 0; i < 30; i++){
			vaga[i] = "vazio"
		}
		
		inteiro numero
		
		faca{
			
		escreva("---------------------------------- \n")
		escreva("1-Entrada de Veículo\n")
		escreva("2-Saída de Veículo\n")
		escreva("3-Listar vagas\n")
		escreva("4-Sair do programa\n")
		escreva("---------------------------------- \n")
		escreva("Digite um número: ")
		leia(numero)
		limpa()
		
		escolha(numero){

			caso 1: entradaVeiculo()
			pare
			caso 2: saidaVeiculo()
			pare
			caso 3: listarVagas()
			pare
			caso 4: escreva("Programa Encerrado")
			pare
			caso contrario: escreva("Número Inválido! Tente Novamente\n")
			pare
		}
	
			}enquanto(numero != 4)


	}

	funcao entradaVeiculo(){
		faca{
		escreva("Informe o número da vaga desejada: ")
		leia(num)
		se(num <= 0 ou num > 30){
			escreva("Vaga inexistente. ")
			}
		}enquanto(num <= 0 ou num > 30)

		enquanto(vaga[num] != "vazio"){
			escreva("Vaga ocupada! Tente outra vaga: ")
			leia(num)			
		}

		escreva("Digite a placa do veículo: ")
		leia(placa)
		vaga[num-1] = placa			
		}

	funcao saidaVeiculo(){
		faca{
		escreva("Informe a vaga para a retirada: ")
		leia(num)
		se(num <= 0 ou num > 30){
			escreva("Vaga inexistente.\n")
			}
		}enquanto(num <= 0 ou num > 30)

		enquanto(vaga[num-1] == "vazio"){
			escreva("Está vaga já está vazia. Informe outra vaga: ")
			leia(num)
		}

		vaga[num-1] = "vazio"
		escreva("Carro retirado com sucesso!!!\n")
	}

	funcao listarVagas(){
		para (inteiro i = 0; i < 30; i++){
			escreva((i+1), "- ", vaga[i], "\n")
			}
		}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 699; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vaga, 11, 8, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */