import styled from 'styled-components';

// Card do Produto
export const Card = styled.div`
  padding: 30px;
  border: 1px solid #CBD5E0;
  background-color: #FFFFFF;
  color: #2D3748;
  border-radius: 12px;
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1); 
  text-align: center;
  transition: transform 0.3s ease, box-shadow 0.3s ease, background-color 0.3s ease;

  &:hover {
    transform: translateY(-8px);
    box-shadow: 0 15px 20px rgba(0, 0, 0, 0.15);
    background-color: #EDF2F7;
  }
`;

export const Image = styled.img`
  width: 100%;
  height: 180px; 
  object-fit: contain;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); 
`;


export const Name = styled.h3`
  font-size: 1.25em; 
  color: #1A202C; 
  font-weight: 600;
  margin: 10px 0;
  transition: color 0.3s ease;

  &:hover {
    color: #3182CE; 
  }
`;


export const Price = styled.p`
  font-size: 1.1em;
  font-weight: 600;
  color: #38A169; 
  margin-bottom: 20px;
`;

export const AddButton = styled.button`
  padding: 12px 24px;
  background-color: #3182CE; 
  color: #FFFFFF;
  font-size: 1em;
  font-weight: 600;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;

  &:hover {
    background-color: #2B6CB0; 
    transform: translateY(-2px); 
  }

  &.active {
    background-color: #3182CE; 
    color: #FFFFFF;
    border-color: #2B6CB0; 
  }
`;

