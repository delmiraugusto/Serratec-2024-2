import { useState } from "react"

export const Exercicio03 = () => {

    const [estadoInicial, setEstadoInicial] = useState(0);

    function contar() {
        setEstadoInicial(prevState => prevState + 1)
    }

    function zerar() {
        setEstadoInicial(prevState => 0)
    }

    return (
        <div>
            <p>{estadoInicial}</p>
            <button onClick={contar}>Contador</button>
            <button onClick={zerar}>Zerar</button>
        </div>

    )
}