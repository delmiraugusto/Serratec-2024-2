import styled from 'styled-components';

// Container principal, com fundo gradiente e animação
export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(135deg, #57bafc, #043d77, #57bafc, #9dc9ff);
  background-size: 200% 200%;
  animation: auroraAnimation 12s ease-in-out infinite;

  @keyframes auroraAnimation {
    0% { background-position: 0% 50%; }
    50% { background-position: 100% 50%; }
    100% { background-position: 0% 50%; }
  }
`;

// Formulário com fundo semi-transparente, borda e sombra
export const Form = styled.form`
  background-color: rgba(0, 0, 50, 0.75);
  display: flex;
  flex-direction: column;
  padding: 2.5rem;
  border-radius: 16px;
  box-shadow: 0 0 15px rgba(255, 255, 255, 0.3);
  width: 100%;
  max-width: 400px;
  text-align: center;
  backdrop-filter: blur(10px);

  @media screen and (max-width: 600px) {
    max-width: 90%;
    padding: 2rem;
  }

  @media screen and (max-width: 768px) {
    max-width: 80%;
    padding: 2.5rem;
  }
`;

// Título do formulário
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

// Parágrafo do formulário
export const Paragraf = styled.p`
  text-align: center;
  padding: 10px;
  font-size: 16px;
  color: #ffffff;
  font-family: 'Press Start 2P', cursive;
`;

// Mensagem de erro
export const ErrorMessage = styled.span`
  color: #ff4444;
  font-size: 14px;
  margin-bottom: 10px;
  text-align: center;
  font-family: 'Press Start 2P', cursive;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);

  @media screen and (max-width: 600px) {
    font-size: 12px;
  }
`;

// Campo de input
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

// Wrapper que contém o conteúdo, com alinhamento e responsividade
export const ContentWrapper = styled.div`
  display: flex;
  width: 80%;
  max-width: 1200px;
  align-items: center;
  justify-content: space-between;

  @media screen and (max-width: 768px) {
    flex-direction: column;
    align-items: center;
    padding: 1rem;
  }
`;

// Logo do site
export const Logo = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 50%;

  img {
    height: 700px;
    width: auto;

    @media screen and (max-width: 768px) {
      height: 80px;
    }
  }
`;

// Botão do formulário
export const Button = styled.button`
  padding: 1rem;
  margin-top: 1rem;
  border: none;
  background-color: #007bff;
  color: #fff;
  font-size: 18px;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s;

  &:hover {
    background-color: #0056b3;
  }

  @media screen and (max-width: 600px) {
    padding: 0.8rem;
    font-size: 16px;
  }
`;