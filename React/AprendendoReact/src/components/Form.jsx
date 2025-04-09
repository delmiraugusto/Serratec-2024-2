import { useState } from "react"

export const Form = () => {

    function cadastrarUsuario(e) {
        e.preventDefault()
        console.log(`Usuario ${name} foi cadastrado com a senha: ${password}`)
    }

    const [name, setName] = useState("Delmir")
    const [password, setPassword] = useState("")

    return (
        <div>
            <form onSubmit={cadastrarUsuario}>
                <div>
                    <label htmlFor="name">Nome:</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        placeholder="Digite o seu nome" onChange={(e) => setName(e.target.value)}
                        value={name} />
                </div>
                <div>
                    <label htmlFor="passaword">Senha:</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Digite sua senha"
                        onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div>
                    <input type="submit" value="Cadastrar" />
                </div>
            </form>
        </div>
    )
}