"use strict";
const aluno = {
    nome: 'Augusto',
    idade: 25,
    endereco: 'Rua 123, 1234',
    time: 'Time de Futebol'
};
function imprimir(aluno) {
    console.log(`Nome: ${aluno.nome}`);
    console.log(`Idade: ${aluno.idade}`);
    console.log(`Endereço: ${aluno.endereco}`);
    if (aluno.time) {
        console.log(`Time: ${aluno.time}`);
    }
}
imprimir(aluno);
