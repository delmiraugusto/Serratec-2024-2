import { useState } from "react"

export const Exercicio02 = () => {

    const [color, setColor] = useState("red")

    function alterar() {
        setColor(prevState => prevState === "red" ? "blue" : "red")
    }

    return (
        <div style={{ backgroundColor: color }}>
            <button onClick={alterar}>Alterar</button>
        </div>
    )

}