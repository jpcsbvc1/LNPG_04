#include <stdio.h>

int verificar_primo(int num) {
    if (num <= 1)
        return 0; 
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return 0; 
    }
    return 1; 
}

int proximo_primo(int num) {
    num++;
    while (!verificar_primo(num))
        num++;
    return num;
}

int main() {
    int n;
    printf("Digite um numero inteiro: ");
    scanf("%d", &n);

    int primo = proximo_primo(n);
    printf("O menor numero primo maior que %d eh: %d\n", n, primo);

    return 0;
  }