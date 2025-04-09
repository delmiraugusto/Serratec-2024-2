import { useState } from "react"


export const Exercicio04 = () => {

    const [inputText, setInputText] = useState("")
    const [display, setDisplay] = useState("")

    function pegarValor(event) {
        setInputText(event.target.value)
        console.log(event.target.value)
    }

    function enviar() {
        setDisplay(inputText)
    }

    return (
        <div>
            <input
                onChange={pegarValor}
                type="text"
                placeholder="Digite seu email"
            />
            <button onClick={enviar}>Enviar</button>
            <h1>Texto exibido: {display}</h1>
        </div>

    )
}