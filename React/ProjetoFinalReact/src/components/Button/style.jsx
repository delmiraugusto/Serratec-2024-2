import styled from 'styled-components'

export const ButtonComponents = styled.button`
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10px;
  transition: background-color 0.3s, transform 0.2s;

  &:hover {
    background-color: #0056b3;
    transform: scale(1.05);
  }

  @media (min-width: 768px) {
    padding: 12px 24px;
    font-size: 18px;
  }

  @media (min-width: 1024px) {
    padding: 14px 28px;
    font-size: 20px;
  }
`;
