import styled from 'styled-components';

// Container para centralizar o conteúdo
export const Container = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: #76bffc;

    @keyframes auroraAnimation {
        0% { background-position: 100% 0%; }
        25% { background-position: 0% 100%; }
        50% { background-position: 100% 0%; }
        75% { background-position: 0% 100%; }
        100% { background-position: 100% 0%; }
    }
`;

// Formulário com animação de gradiente
export const Form = styled.form`
    background-color: #0868d475;
    background: linear-gradient(135deg, #57bafc, #57bafc, #043d77, #9dd6fc);
    background-size: 300% 300%;
    animation: auroraAnimation 15s ease-in-out infinite;
    display: flex;
    flex-direction: column;
    padding: 40px;
    border-radius: 16px;
    box-shadow: 0 0 15px rgba(255, 255, 255, 0.3);
    width: 100%;
    max-width: 400px;
`;

// Título com fontes e sombras
export const Title = styled.h2`
    font-family: 'Press Start 2P', cursive;
    font-size: 32px;
    color: #00f7ff;
    margin-bottom: 1.5rem;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);

    @media screen and (max-width: 600px) {
        font-size: 26px;
        margin-bottom: 1rem;
    }

    @media screen and (max-width: 768px) {
        font-size: 30px;
    }
`;

// Mensagem de erro com texto centralizado e cor vermelha
export const ErrorMessage = styled.p`
    color: #ff4444;
    font-size: 16px;
    margin-top: 10px;
    text-align: center;
    font-family: 'Press Start 2P', cursive;
    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);

    @media screen and (max-width: 600px) {
        font-size: 14px;
        margin-top: 8px;
    }
`;

// Mensagem de sucesso com cor verde e sombra no texto
export const SuccessMessage = styled.p`
    color: #00ff99;
    font-size: 16px;
    margin-top: 10px;
    text-align: center;
    font-family: 'Press Start 2P', cursive;
    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);

    @media screen and (max-width: 600px) {
        font-size: 14px;
        margin-top: 8px;
    }
`;

// Campo de entrada com estilos customizados
export const Input = styled.input`
    padding: 1rem;
    margin: 0.5rem 0;
    border-radius: 8px;
    border: 1px solid #00f7ff;
    font-size: 16px;
    color: #fff;
    background-color: rgba(0, 0, 50, 0.5);

    &:focus {
        outline: none;
        border-color: #00ff99;
    }

    @media screen and (max-width: 600px) {
        padding: 0.8rem;
        font-size: 14px;
    }
`;

// Botão com efeito de hover
export const Button = styled.button`
    padding: 1rem;
    margin-top: 1rem;
    border: none;
    background-color: #00f7ff;
    color: #000;
    font-size: 18px;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s;

    &:hover {
        background-color: #00ff99;
    }

    @media screen and (max-width: 600px) {
        padding: 0.8rem;
        font-size: 16px;
    }
`;

// Logo com redimensionamento para dispositivos móveis
export const Logo = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    width: 50%;

    img {
        height: 900px;
        width: auto;

        @media screen and (max-width: 768px) {
            height: 80px;
        }
    }
`;