import styled from 'styled-components';

export const Container = styled.div`
    max-width: 1200px;
    margin: auto;
    padding: 30px;
    background-color: #ffffff;
    border-radius: 12px;
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    background: linear-gradient(135deg, #f5f7fa, #e0e7ff);  // Gradiente suave de fundo
`;

export const Title = styled.h1`
    font-size: 36px;
    color: #1E40AF;
    margin-bottom: 30px;
    font-weight: 700;
    text-align: center;
    letter-spacing: 1px;
    text-transform: uppercase;
    text-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

export const ProductList = styled.div`
    display: flex;
    flex-direction: column;
    gap: 25px;
`;

export const ProductItem = styled.div`
    display: flex;
    justify-content: space-between;
    padding: 20px;
    border: 1px solid #E5E7EB;
    border-radius: 12px;
    background-color: #ffffff;
    transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);

    &:hover {
        background-color: #E0F2FE;
        transform: translateY(-5px);
        box-shadow: 0 4px 15px rgba(0, 123, 255, 0.2);
    }
`;

export const ProductImage = styled.img`
    width: 130px;
    height: 130px;
    object-fit: cover;
    margin-right: 20px;
    border-radius: 8px;
    box-shadow: 0px 2px 8px rgba(0, 0, 0, 0.1);
`;

export const ProductInfo = styled.div`
    flex: 1;

    h3 {
        margin: 0 0 10px;
        font-size: 1.2em;
        font-weight: 600;
        color: #1E40AF;
    }

    p {
        margin: 5px 0;
        color: #374151;
        font-size: 14px;
    }
`;

export const ProductQuantity = styled.div`
    display: flex;
    align-items: center;
    margin: 10px 0;

    span {
        margin: 0 10px;
        font-size: 16px;
        color: #374151;
    }

    button {
        background-color: #E0E7FF;
        color: #1E40AF;
        border: none;
        padding: 5px 10px;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;

        &:hover {
            background-color: #3B82F6;
            color: #fff;
        }
    }
`;

export const Price = styled.p`
    font-size: 16px;
    font-weight: 600;
    color: #1E40AF;
    margin-top: 10px;
`;

export const Button = styled.button`
    background-color: #3B82F6;
    color: #fff;
    border: none;
    border-radius: 8px;
    padding: 10px 18px;
    cursor: pointer;
    font-weight: 600;
    font-size: 16px;
    transition: background-color 0.3s, transform 0.3s ease;

    &:hover {
        background-color: #2563EB;
        transform: translateY(-2px);
    }

    &:active {
        transform: translateY(0);
    }
`;

export const TotalContainer = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 30px;
    padding-top: 15px;
    border-top: 2px solid #E5E7EB;
`;

export const Total = styled.h2`
    font-size: 28px;
    color: #1E40AF;
    font-weight: 700;
`;

export const CheckoutButton = styled.button`
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 8px;
    padding: 14px 28px;
    cursor: pointer;
    font-size: 18px;
    font-weight: bold;
    transition: background-color 0.3s, transform 0.3s ease;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);

    &:hover {
        background-color: #45a049;
        transform: translateY(-2px);
    }

    &:active {
        transform: translateY(0);
    }
`;

export const EmptyMessage = styled.p`
    text-align: center;
    color: #666;
    margin-top: 20px;
    font-size: 18px;
    font-weight: 500;
`;

export const CartActions = styled.div`
    display: flex;
    justify-content: flex-end;
    gap: 20px;
    margin-top: 20px;
`;
