
import styled from 'styled-components';

// Container principal, com altura 100vh, centralizando o conteúdo
export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(135deg, #f7f7f7, #e6e6e6); // Gradiente suave de fundo
`;


export const HistoryContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
  max-width: 450px;
  padding: 30px;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1); // Sombra suave
  color: #333;
  backdrop-filter: blur(5px); // Efeito suave de desfoque no fundo
  
 
  border: 1px solid rgba(0, 0, 0, 0.1);
  
  // Ajustando para dispositivos móveis
  @media (max-width: 768px) {
    padding: 20px;
  }
`;


export const Title = styled.h2`
  text-align: center;
  font-family: 'Roboto', sans-serif;
  font-size: 24px;
  font-weight: 500;
  color: #333;
  margin-bottom: 25px;
  letter-spacing: 1px;
  text-transform: uppercase; // Deixa o título mais elegante
  
  
  text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);

  @media (max-width: 768px) {
    font-size: 20px;
  }
`;


export const OrderCard = styled.div`
  padding: 20px;
  margin: 15px 0;
  border: 1px solid #f1f1f1;
  border-radius: 8px;
  background-color: #fafafa;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  
  &:hover {
    transform: translateY(-5px);
    box-shadow: 0 10px 20px rgba(0, 123, 255, 0.2); // Sombra mais forte no hover
  }
  
  
  border-left: 5px solid #007bff;
`;


export const OrderDate = styled.p`
  font-size: 14px;
  color: #555;
  margin: 5px 0;
  font-family: 'Arial', sans-serif;
  letter-spacing: 0.5px;
`;


export const OrderTotal = styled.p`
  font-size: 18px;
  color: #007bff;
  font-weight: 600;
  margin: 10px 0;
  font-family: 'Roboto', sans-serif;
`;

// Botão estilizado com transições suaves
export const Button = styled.button`
  padding: 12px 20px;
  background-color: #007bff;
  color: #ffffff;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  margin-top: 20px;
  transition: background-color 0.3s ease, transform 0.2s ease;

  &:hover {
    background-color: #0056b3;
    transform: translateY(-2px); // Leve elevação no hover
  }

  &:active {
    transform: translateY(0); // Ao clicar, volta ao estado original
  }

  @media (max-width: 768px) {
    padding: 10px 18px;
    font-size: 14px;
  }
`;
export const EmptyMessage = styled.p`
  text-align: center;
  color: #999;
  font-size: 16px;
  font-style: italic;
  margin-top: 20px;
  font-family: 'Roboto', sans-serif;
`;
