import { useReducer } from "react";

export const ExercicioReducer = () => {
    const estadoInicial = { count: 0 }

    function usandoReducer(state, action) {
        switch (action.type) {
            case "aumentar":
                return { count: state.count + 1 }
            case "diminuir":
                return { count: state.count - 1 }
            case "resetar":
                return estadoInicial
            case "multiplicar":
                return { count: state.count * 2 }
            default:
                return new Error()
        }
    }

    const [state, dispatch] = useReducer(usandoReducer, estadoInicial)
    return (
        <div>
            <h1>Contador: {state.count}</h1>
            <button onClick={() => dispatch({ type: "aumentar" })}>Aumentar </button>
            <button onClick={() => dispatch({ type: "diminuir" })}>Diminuir </button>
            <button onClick={() => dispatch({ type: "resetar" })}>Resetar </button>
            <button onClick={() => dispatch({ type: "multiplicar" })}>Multiplicar</button>
        </div>
    )
}