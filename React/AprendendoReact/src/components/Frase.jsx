import Styles from './Frase.module.css'


export const Frase = () => {

    return (
        <div className= {Styles.fraseContainer}>
            <p className= {Styles.fraseContent}>Este é um componente com uma frase!</p>
        </div>
    )

}