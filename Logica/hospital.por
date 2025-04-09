programa
{
	/* Grupo 2
	 * Daniele dias
	 * Delmir
	 * Gabriela Couto
	 * Marcos Medeiros
	 * Mariana Monteiro
	 */

	
	inclua biblioteca Util --> u
	
	cadeia quartos[20], nomes[20][2], especialidade
	inteiro numeroQuarto, caixa = 0, consulta = 0, 
	internacaoFaturamento = 0, numeroInternados = 0, total = 0
	
	funcao inicio()
	{
		para(inteiro i=0; i < 20; i++){
			quartos[i] = "vazio"
		}
		
		inteiro numero
		faca{
			
		
		escreva("\nHOSPITAL - XPTO\n")
		escreva("----------------------------------\n")
		escreva("1- Consulta Ambulatorial\n")
		escreva("2- Internação\n")
		escreva("3- Listar Quartos\n")
		escreva("4- Faturamento\n")
		escreva("0- Sair do programa\n")
		escreva("----------------------------------\n")
		escreva("Escolha o tipo de serviço: ")
		leia(numero)
		limpa()
		
		escolha(numero){

			caso 1: consultaAmbolatorial()
			pare
			caso 2: internacao() 
				internacao2()
			pare		
			caso 3: listarQuartos()
			pare
			caso 4: faturamento()
			pare
			caso 0: escreva("Programa encerrado")
			pare
			caso contrario: escreva("Número Inválido! Tente Novamente\n")
			pare
		}
			}enquanto(numero != 0)

	}

	funcao consultaAmbolatorial(){
		cadeia nome, telefone
		escreva("Digite seu nome: ")
		leia(nome)
		escreva("Digite seu telefone: ")
		leia(telefone)
		escreva("Especialidade: ")
		leia(especialidade)
		escreva("\nConsulta marcada!!!")
		u.aguarde(2000)
		limpa()
		
		se(especialidade == "pediatria" ou especialidade == "Pediatria"){
			caixa += 150
			}
		senao{
			caixa += 120
			}
		consulta += 1
	}

	funcao logico internacao(){
		faca{
			
			escreva("Informe o quarto desejado: ")
			leia(numeroQuarto)

			se(numeroQuarto < 1 ou numeroQuarto > 20){
				escreva("Quarto inexistente. \n")
			}
			
		}enquanto(numeroQuarto < 1 ou numeroQuarto > 20)

		se(quartos[numeroQuarto - 1] != "vazio"){
			escreva("Quarto Ocupado.\n\n")
			escreva("Tente outro quarto: ")
			leia(numeroQuarto)
		}

		se(quartos[numeroQuarto - 1] == "vazio"){
			retorne verdadeiro
		}
		senao{
			retorne falso
		}
	}

	funcao internacao2(){
		
		cadeia nome, telefone
		escreva("Digite seu nome: ")
		leia(nome)
		escreva("Digite seu telefone: ")
		leia(telefone)
		escreva("\nQuarto reservado com sucesso!!!\n")
		quartos[numeroQuarto - 1] = nome
		nomes[numeroQuarto - 1][0] = nome
		nomes[numeroQuarto - 1][1] = telefone
		u.aguarde(2000)
		limpa()
		
		}


	funcao listarQuartos(){
		para(inteiro i=0; i < 20; i++){
			escreva((i+1) + "- " + quartos[i] + "\n")
		}
	}

	funcao calculo(){
		para(inteiro i=0; i < 20; i++){
			se(quartos[i] != "vazio"){
				internacaoFaturamento += 500
				numeroInternados += 1
			}
		}
		
		total = caixa + internacaoFaturamento
		
	}
		
	funcao faturamento(){
		calculo()
		
		escreva("Número de consultas: "+ consulta + "\n")
		escreva("Número de internações: "+ numeroInternados + "\n")
		escreva("Total faturado de consultas: "+ caixa + "\n")
		escreva("Total faturado de internações: "+ internacaoFaturamento + "\n")
		escreva("Total geral arrecadado: "+ total + "\n")
		u.aguarde(2500)
		
	}
	
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 110; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {quartos, 14, 8, 7}-{nomes, 14, 21, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */