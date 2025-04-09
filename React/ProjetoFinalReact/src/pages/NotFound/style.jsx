import styled from 'styled-components';

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f8f9fa;
    text-align: center;
`;

export const Title = styled.h1`
    font-size: 3rem;
    color: #dc3545;
    margin-bottom: 20px;
`;

export const Message = styled.p`
    font-size: 1.5rem;
    color: #6c757d;
    margin-bottom: 30px;
`;

export const HomeButton = styled.button`
    padding: 10px 20px;
    font-size: 1rem;
    color: white;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;

    &:hover {
        background-color: #0056b3;
    }
`;
