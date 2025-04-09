programa
{
	/* Escreva um programa que apresente um menu com as seguintes opções:
	Deverá ser criado um vetor com até cinquenta convidados. Para inserir um novo convidado 
	deverá ser verificado no vetor se a posição está vazia.Quando remover um convidado deverá ser 
	atribuído vazio a posição do vetor. Pagamento:Para cada convidado deverá ser cobrado o valor
	de 120,00. Exibir o total que deverá ser pago e quantidade de convidados presentes.
	Obs: Criar funções para cada opção.
	
	/* Grupo 2
	 *  Daniele Dias
	 *  Delmir
	 *  Gabriela Couto
	 *  Marcos Medeiros
	 *  Mariana Monteiro
	 */


	
	cadeia convidado[50], nome, resposta
	inteiro numero, numero2 = 0, quantidade = 0, pago
	
	funcao inicio()
	{
		para(inteiro i= 0; i < 50; i++){
			convidado[i] = "vazio"
		}
		
		faca{
			
		escreva("MENU DE OPÇÕES:\n")
		escreva("1- Inserir nomes:\n")
		escreva("2- Listar convidados\n")
		escreva("3- Remover convidado\n")
		escreva("4- Pagamento\n")
		escreva("0- sair\n")
		escreva("Digite a opção: ")
		leia(numero2)
		limpa()
		
		escolha(numero2){

			caso 1: inserirNome()
			pare
			caso 2: listarConvidados()
			pare
			caso 3: removerNome()
			pare
			caso 4: pagamento()
			pare
			caso 0: escreva("\nPrograma encerrado!!!")
			pare
			caso contrario: escreva("Número inválido! Tente novamente\n")
			pare
		
		}
			
		escreva("\n")
		}enquanto(numero2 != 0)

	}
	
	funcao inserirNome(){
		faca{
		escreva("Qual o número do convidado? ")
		leia(numero)
		se(numero < 0 ou numero > 50){
			escreva("Número inválido, tente novamente\n")
		}
			}enquanto(numero < 0 ou numero > 50)
		enquanto(convidado[numero] != "vazio"){
			escreva("Número ocupado. Por favor digite outro número para o convidado: \n")
			leia(numero)
		}
		escreva("Número vago, qual o nome do convidado? ")
		leia(nome)
		convidado[numero] = nome
		escreva("Convidado adicionado a lista!!! \n")
		}
	


	funcao listarConvidados(){
		para(inteiro i=0; i < 50; i++){
			escreva(i , "- "+ convidado[i] + "\n")
		}
		
	}

	funcao removerNome(){
		faca{
		escreva("Quer remover o convidado pelo numero ou pelo nome? ")
		leia(resposta)
			se(resposta == "numero"){
				escreva("Qual o número do convidado? ")
				leia(numero)
				convidado[numero] = "vazio"
			}	
			senao se(resposta == "nome"){
				escreva("Qual o nome do convidado? ")
				leia(nome)
				para(inteiro i=0; i < 50; i++){
					se(convidado[i] == nome){
						convidado[i] = "vazio"
					}
				}
			} 
			senao{
				escreva("Resposta inválida!\n")
			}
			}enquanto(resposta != "numero" e resposta != "nome")
		
		escreva("Convidado removido com sucesso!\n")
	}

	funcao pagamento(){
		para(inteiro i=0; i < 50; i++){
			se(convidado[i] != "vazio"){
				quantidade++
			}
		}
		pago = quantidade * 120
		escreva("\nTotal a ser pago é de: R$" + pago + "\n")
		escreva("Número de convidados é de: " + quantidade + "\n")	
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */