import { Item } from './Item'

export const List = () => {
    return (
        <>
            <h1>Minha LIst</h1>
            <ul>
                <Item marca="Ferrari" anoLancamento= {1968}/>
                <Item marca="Fiat" anoLancamento={2004} />
                <Item/>
            </ul>
        </>
    )
}