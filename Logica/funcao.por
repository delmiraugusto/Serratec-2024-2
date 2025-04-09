programa
{
    cadeia matriz[5][2] = {{"Mari","123"},{"Dani","456"},{"Marcos","senha"},{"Delmir","senha"},{"Gabi","senha"}}

    funcao inicio()
    {
        cadeia usu
        cadeia sen

        escreva("Digite seu usuario: ")
        leia(usu)

        escreva("Digite sua senha: ")
        leia(sen)
        
        se(procurar(usu, sen) == verdadeiro) {
            escreva("Bem vindo ao sistema!")
        } senao {
            escreva("Usuario ou senha incorretos")
        }
    }

    funcao logico procurar(cadeia usu, cadeia sen){
        para(inteiro l=0; l <= 5; l++){
            se(matriz[l][0] == usu e matriz[l][1] == sen){
                retorne verdadeiro
           }
        }
        retorne falso
    }
}

    
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 543; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matriz, 3, 11, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */