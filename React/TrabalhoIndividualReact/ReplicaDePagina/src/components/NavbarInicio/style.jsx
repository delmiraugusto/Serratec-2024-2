import styled from 'styled-components';

export const NavbarContainer = styled.div`
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 10px 20px;
    background-color: #f1f1f1;
`;

export const Logo = styled.h1`
    font-size: 24px;
    color: #6200ee;
`;

export const SearchInput = styled.input`
    width: 200px;
    padding: 5px;
`;

export const ActionButton = styled.button`
    margin-left: 10px;
    padding: 5px 15px;
    background-color: #6200ee;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
`;