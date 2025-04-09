import styled from 'styled-components';

// Novo estilo para o Container de Categorias
export const CategoryContainer = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 15px;
  background-color: #1a202c; // Fundo escuro
  border-radius: 12px;
  margin: 20px auto;
  max-width: 90%;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
`;

// Novo estilo para o Botão de Categoria
export const CategoryButton = styled.button`
  padding: 10px 15px;
  background-color: #2d3748; // Fundo cinza escuro
  color: #e2e8f0; // Texto cinza claro
  font-size: 0.9em;
  font-weight: 500;
  text-transform: capitalize;
  border-radius: 6px;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;

  &:hover {
    background-color: #4a5568; // Fundo cinza médio ao passar o mouse
    transform: scale(1.05);
  }

  &.active {
    background-color: #63b3ed; // Azul claro quando ativo
    color: #1a202c; // Texto escuro quando ativo
  }
`;
