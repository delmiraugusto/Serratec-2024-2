export const Alice = () => {

    const msg = (message) => {
        alert(message)
    }
    return (
        <div>
            <h1>Alice é suja?</h1>
            <button onClick={() => msg("Todo mundo sabe")}>Sim</button>
            <button onClick={() => msg("É Sim cara")}>Não</button>
        </div>








    )
}