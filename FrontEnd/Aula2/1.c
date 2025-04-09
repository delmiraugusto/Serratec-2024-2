#include <stdio.h>

int main() {
    int n;
    printf("Digite o tamanho dos vetores:\n");
    scanf("%d", &n);
    int vet[n];
    int vet2[n];

    for (int i = 0; i < n ;i++) {
            printf("Digita um numero para a posicao%d:\n", i);
            scanf("%d", &vet[i]);           
    }

    for (int i = 0; i < n ;i++) {
            printf("Digita um numero para a posicao%d:\n", i);
            scanf("%d", &vet2[i]);           
    }

    return 0;
}