import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const Header = styled.div`
  width: 100%;
  background-color: #f8f9fa;
  border-bottom: 2px solid #d1d5db;
  padding: 10px 0;
  position: sticky;
  top: 0;
  z-index: 10;
`;

export const IconButton = styled.button`
  display: flex;
  align-items: center;
  gap: 5px;
  padding: 8px 10px;
  background-color: #1E40AF;
  color: #FFFFFF;
  font-weight: 500;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 0.9em;
  transition: background-color 0.3s ease;

  &:hover {
    background-color: #1D4ED8;
  }
`;

export const CategoryContainer = styled.div`
  display: flex;
  justify-content: center;
  gap: 12px;
  padding: 12px 0;
  background-color: #E5E7EB;
  border-radius: 10px;
  box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.1);
  flex-wrap: wrap;
`;

export const CategoryButton = styled.button`
  padding: 8px 16px;
  border: none;
  background-color: #3B82F6;
  color: #FFFFFF;
  font-size: 0.85em;
  font-weight: 600;
  text-transform: uppercase;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;

  &:hover {
    background-color: #2563EB;
    transform: scale(1.05);
  }

  @media (max-width: 768px) {
    font-size: 0.8em;
    padding: 6px 12px;
  }

  @media (max-width: 480px) {
    font-size: 0.75em;
    padding: 5px 10px;
  }
`;

export const Container = styled.div`
  padding: 30px;
  max-width: 1100px;
  margin: auto;
  background-color: #FFFFFF;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  color: #374151;

  @media (max-width: 768px) {
    padding: 20px;
  }

  @media (max-width: 480px) {
    padding: 15px;
  }
`;

export const SearchInput = styled.input`
  width: 100%;
  max-width: 600px;
  padding: 12px;
  font-size: 1em;
  border: 1px solid #9CA3AF;
  border-radius: 8px;
  background-color: #E5E7EB;
  color: #374151;
  transition: border-color 0.2s;

  &:focus {
    border-color: #4B5563;
    outline: none;
  }

  @media (max-width: 768px) {
    max-width: 90%;
    font-size: 0.9em;
  }
`;

export const ProductsContainer = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 20px;
  padding-top: 15px;

  @media (max-width: 768px) {
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 15px;
  }

  @media (max-width: 480px) {
    grid-template-columns: 1fr;
    gap: 10px;
  }
`;

export const Card = styled.div`
  padding: 18px;
  border: 1px solid #E2E8F0;
  background-color: #FFFFFF;
  color: #1F2937;
  border-radius: 10px;
  text-align: center;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);

  &:hover {
    transform: translateY(-5px);
    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
  }
`;

export const Image = styled.img`
  width: 100%;
  height: 200px;
  object-fit: contain;
  border-radius: 8px;
  margin-bottom: 12px;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.08);

  @media (max-width: 768px) {
    height: 150px;
  }

  @media (max-width: 480px) {
    height: 130px;
  }
`;

export const Name = styled.h3`
  font-size: 1.1em;
  margin: 10px 0;
  color: #1E40AF;
  font-weight: bold;

  @media (max-width: 768px) {
    font-size: 1em;
  }

  @media (max-width: 480px) {
    font-size: 0.95em;
  }
`;

export const Price = styled.p`
  font-size: 1em;
  color: #10B981;
  margin-bottom: 12px;
  font-weight: bold;

  @media (max-width: 768px) {
    font-size: 0.9em;
  }

  @media (max-width: 480px) {
    font-size: 0.85em;
  }
`;

export const AddButton = styled.button`
  padding: 10px 16px;
  background-color: #3B82F6;
  color: #FFFFFF;
  border: none;
  border-radius: 8px;
  font-size: 1em;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;

  &:hover {
    background-color: #2563EB;
    transform: translateY(-2px);
  }

  @media (max-width: 768px) {
    padding: 8px 12px;
  }

  @media (max-width: 480px) {
    padding: 6px 10px;
  }
`;

export const NavBar = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 15px;
  max-width: 1200px;
  margin: 0 auto;

  @media (max-width: 768px) {
    gap: 10px;
  }

  @media (max-width: 480px) {
    gap: 8px;
  }
`;

export const NavButton = styled.button`
  display: flex;
  align-items: center;
  gap: 5px;
  padding: 8px 12px;
  background-color: transparent;
  color: #3182ce;
  font-weight: 500;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 0.9em;
  transition: color 0.3s;

  &:hover {
    color: #0038b2;
  }

  @media (max-width: 768px) {
    font-size: 0.8em;
  }

  @media (max-width: 480px) {
    font-size: 0.75em;
  }
`;

export const StyledLink = styled(Link)`
  color: inherit;
  text-decoration: none;

  &:hover {
    color: #0056b3;
  }
`;

export const SearchContainer = styled.div`
  display: flex;
  justify-content: center;
  padding: 15px 0;
`;

export const Nav = styled.div`
  flex: 1;
  overflow-y: auto;
  padding: 0 50px;
  background-color: #141414;

  @media (max-width: 768px) {
    padding: 0 20px;
  }
`;

export const LogoContainer = styled.div`
  overflow-y: auto;
  padding: 10px 100px;

  @media (max-width: 768px) {
    padding: 0 20px;
  }
`;

export const Logo = styled.img`
  height: 100px;
  width: 100px;

  @media (max-width: 768px) {
    height: 40px;
  }
`;
