import styled from 'styled-components';

export const Container = styled.div`
    max-width: 1000px;
    margin: auto;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    border-radius: 8px;

    @media(min-width: 1024px) {
        padding: 20px;
    }

    @media(min-width: 768px) {
        padding: 15px;
    }

    @media(min-width: 480px) {
        padding: 10px;
    }
`;

export const MainSection = styled.div`
    display: flex;
    flex-direction: column;
    gap: 30px;
    justify-content: center;
    align-items: center;
    padding-right: 20px;

    @media(min-width: 768px) {
        flex-direction: row;
        justify-content: flex-start;
        gap: 20px;
    }

    @media(min-width: 1024px) {
        padding-right: 0;
    }
`;

export const ImageGallery = styled.div`
    width: 100%;
    max-width: 500px;
`;

export const LargeImage = styled.div`
    width: 60%;
    height: 400px;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    border-radius: 8px;
    border: 2px solid #e0e0e0;
    transition: transform 0.3s ease, background-position 0.3s ease, box-shadow 0.3s ease;

    &:hover {
        transform: scale(1.3);
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        background-position: 50% center;
    }

    @media(min-width: 768px) {
        height: 300px;
    }

    @media(min-width: 1024px) {
        height: 400px;
    }
`;

export const Thumbnails = styled.div`
    display: flex;
    gap: 12px;
    margin-top: 15px;
    overflow-x: auto;

    img {
        width: 80px;
        height: 80px;
        cursor: pointer;
        border-radius: 8px;
        border: 2px solid #e0e0e0;
        transition: border-color 0.3s, transform 0.3s;

        &:hover {
            border-color: #3a8dff;
            transform: scale(1.05);
        }
    }

    @media(min-width: 768px) {
        gap: 10px;
    }
`;

export const ProductInfo = styled.div`
    flex: 1;
    display: flex;
    flex-direction: column;
    padding-left: 10px;
    padding-right: 10px;
    text-align: left;

    h1 {
        font-size: 28px;
        color: #1e4a7f;
        margin-bottom: 15px;
        font-weight: 600;

        @media(min-width: 768px) {
            font-size: 24px;
        }

        @media(min-width: 1024px) {
            font-size: 28px;
        }
    }

    p {
        font-size: 16px;
        margin: 8px 0;
        color: #555;

        @media(min-width: 768px) {
            font-size: 14px;
        }

        @media(min-width: 1024px) {
            font-size: 16px;
        }
    }

    .price {
        font-size: 20px;
        color: #e01c1c;
        font-weight: 700;
        margin-bottom: -3px;

        @media(min-width: 768px) {
            font-size: 18px;
        }

        @media(min-width: 1024px) {
            font-size: 20px;
        }
    }

    .rating {
        font-size: 14px;
        color: #888;
    }

    .discount-price {
        font-size: 12px;
        color: #888;
        text-decoration: line-through;
        margin-bottom: 15px;
    }
`;

export const AddToCartButton = styled.button`
    background-color: #3a8dff;
    color: #fff;
    font-size: 16px;
    font-weight: bold;
    padding: 12px 18px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    margin-top: 20px;
    transition: background-color 0.3s, transform 0.2s;

    &:hover {
        background-color: #1e4a7f;
        transform: scale(1.05);
    }

    @media(min-width: 768px) {
        font-size: 14px;
        padding: 10px 15px;
    }

    @media(min-width: 1024px) {
        font-size: 16px;
        padding: 12px 18px;
    }
`;

export const QuantityInput = styled.input`
    width: 80px;
    padding: 10px;
    margin-top: 10px;
    font-size: 16px;
    text-align: center;
    border: 2px solid #e0e0e0;
    border-radius: 6px;
    margin-right: 15px;
    transition: border-color 0.3s;

    &:focus {
        border-color: #3a8dff;
        outline: none;
    }

    @media(min-width: 768px) {
        width: 90px;
    }

    @media(min-width: 1024px) {
        width: 100px;
    }
`;

export const Divider = styled.div`
    width: 100%;
    height: 1px;
    background-color: #e0e0e0;
    margin: 30px 0;
`;

export const RecommendedProducts = styled.div`
    margin-top: 40px;

    h3 {
        font-size: 22px;
        color: #1e4a7f;
        margin-bottom: 15px;
        font-weight: 600;
    }

    .products-list {
        display: flex;
        gap: 20px;
        overflow-x: auto;

        .product-item {
            background-color: #f7f7f7;
            padding: 18px;
            width: 180px;
            text-align: center;
            cursor: pointer;
            border-radius: 8px;
            transition: transform 0.3s, box-shadow 0.3s;

            &:hover {
                transform: translateY(-5px);
                box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            }

            img {
                width: 80%;
                height: 140px;
                object-fit: contain;
                border-radius: 6px;
            }

            p {
                margin-top: 12px;
                font-size: 14px;
                color: #333;
            }

            .price {
                font-size: 16px;
                color: #3a8dff;
                font-weight: bold;
            }
        }
    }

    @media(min-width: 768px) {
        .products-list {
            flex-direction: row;
        }
    }

    @media(min-width: 1024px) {
        .products-list {
            flex-direction: row;
        }
    }
`;

export const BestSellers = styled(RecommendedProducts)`
    margin-top: 40px;
`;
