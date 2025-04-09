import React, { useState, useEffect, useContext } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { fetchProductById } from '../../servicesAPI';
import { CartContext } from '../../context/CartContext';
import {
    Container,
    MainSection,
    ImageGallery,
    LargeImage,
    Thumbnails,
    ProductInfo,
    AddToCartButton,
    QuantityInput,
    Divider,
    RecommendedProducts,
    BestSellers,
} from './style';

export const ProductDetails = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const { addToCart } = useContext(CartContext);
    const [product, setProduct] = useState(null);
    const [quantity, setQuantity] = useState(1);
    const [selectedImage, setSelectedImage] = useState('');
    const [zoom, setZoom] = useState(false);
    const [imagePosition, setImagePosition] = useState({ x: '50%', y: '50%' });

    const recommendedProducts = [
        { id: 2, name: 'Cartaz Metropolis de 1927', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/7b5650c8-cc39-4ba8-812f-d1c119edf8dc.jpg', price: 1300000 },
        { id: 4, name: 'Cartucho Sonic (americano)', image: 'https://uploads.jovemnerd.com.br/wp-content/uploads/2021/09/imagem_2021-09-21_175034.png', price: 500000 },
        { id: 1, name: 'Grand Watermelon, 1.000 dólares de 1890', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/a75b3929-dfe2-4a22-848e-a021c469a70c.jpg', price: 17000000 },
        { id: 3, name: 'Tigela Chinesa da Dinastia Song', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/2bb7f8fb-1e0b-423d-9d04-50ca6fbd5fd0.jpg', price: 38000000 },
    ];

    const bestSellers = [
        { id: 4, name: 'Cartucho Sonic (americano)', image: 'https://uploads.jovemnerd.com.br/wp-content/uploads/2021/09/imagem_2021-09-21_175034.png', price: 500000 },
        { id: 1, name: 'Grand Watermelon, 1.000 dólares de 1890', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/a75b3929-dfe2-4a22-848e-a021c469a70c.jpg', price: 17000000 },
        { id: 2, name: 'Cartaz Metropolis de 1927', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/7b5650c8-cc39-4ba8-812f-d1c119edf8dc.jpg', price: 1300000 },
        { id: 3, name: 'Tigela Chinesa da Dinastia Song', image: 'https://img.colleconline.com/imgdescription/06af8fba638441b0921770665abc0915/2bb7f8fb-1e0b-423d-9d04-50ca6fbd5fd0.jpg', price: 38000000 },
    ];

    const fetchProduct = async () => {
        try {
            const data = await fetchProductById(id);
            setProduct(data);
            const firstImage = data.image;
            setSelectedImage(firstImage);
        } catch (error) {
            console.error('Erro ao buscar produto:', error);
        }
    };

    useEffect(() => {
        fetchProduct();
    }, [id]);

    const handleAddToCart = () => {
        if (product) {
            addToCart(product, quantity);
            navigate('/cart');
        }
    };

    const handleMouseEnter = () => {
        setZoom(true);
    };

    const handleMouseLeave = () => {
        setZoom(false);
        setImagePosition({ x: '50%', y: '50%' });
    };

    const handleMouseMove = (e) => {
        if (zoom) {
            const { clientX, clientY, currentTarget } = e;
            const { offsetLeft, offsetTop, clientWidth, clientHeight } = currentTarget;

            const x = ((clientX - offsetLeft) / clientWidth) * 100;
            const y = ((clientY - offsetTop) / clientHeight) * 100;

            setImagePosition({ x: `${x}%`, y: `${y}%` });
        }
    };

    const handleProductClick = (productId) => {
        navigate(`/products/${productId}`);
    };

    return (
        <Container>
            {product ? (
                <>
                    <MainSection>
                        <ImageGallery>
                            <LargeImage
                                style={{
                                    backgroundImage: `url(${selectedImage})`,
                                    backgroundSize: zoom ? '150%' : '100%',
                                    backgroundRepeat: 'no-repeat',
                                    backgroundPosition: `${imagePosition.x} ${imagePosition.y}`,
                                    transition: 'background-size 0.3s ease',
                                }}
                                onMouseEnter={handleMouseEnter}
                                onMouseLeave={handleMouseLeave}
                                onMouseMove={handleMouseMove}
                            />
                            <Thumbnails>
                                <img
                                    src={selectedImage}
                                    alt={`${product.name} thumbnail`}
                                />
                                {product.images?.map((image, index) => (
                                    <img
                                        key={index}
                                        src={image}
                                        alt={`${product.name} thumbnail ${index + 1}`}
                                        onClick={() => setSelectedImage(image)}
                                    />
                                ))}
                            </Thumbnails>
                        </ImageGallery>

                        <ProductInfo>
                            <h1>{product.name}</h1>
                            <p className="price">
                                Preço: R$ {product.price ? parseFloat(product.price).toFixed(2) : 'N/A'}
                            </p>
                            <p className="discount-price">Último lance: R$ 4800000.00</p>
                            <p>{product.description}</p>
                            <p className='rating'>Lances: {product.rating}</p>

                            <QuantityInput
                                type="number"
                                min="1"
                                value={quantity}
                                onChange={(e) => setQuantity(Number(e.target.value))}
                            />
                            <AddToCartButton onClick={handleAddToCart}>Adicionar ao carrinho</AddToCartButton>
                        </ProductInfo>
                    </MainSection>

                    <Divider />

                    <RecommendedProducts>
                        <h3>Produtos Recomendados</h3>
                        <div className="products-list">
                            {recommendedProducts.map((item) => (
                                <div
                                    key={item.id}
                                    className="product-item"
                                    onClick={() => handleProductClick(item.id)}
                                >
                                    <img src={item.image} alt={item.name} />
                                    <p>{item.name}</p>
                                    <p className="price">R$ {item.price.toFixed(2)}</p>
                                </div>
                            ))}
                        </div>
                    </RecommendedProducts>

                    <Divider />

                    <BestSellers>
                        <h3>Produtos Mais Comprados</h3>
                        <div className="products-list">
                            {bestSellers.map((item) => (
                                <div
                                    key={item.id}
                                    className="product-item"
                                    onClick={() => handleProductClick(item.id)} // Redireciona para a página do produto
                                >
                                    <img src={item.image} alt={item.name} />
                                    <p>{item.name}</p>
                                    <p className="price">R$ {item.price.toFixed(2)}</p>
                                </div>
                            ))}
                        </div>
                    </BestSellers>
                </>
            ) : (
                <p>Carregando...</p>
            )}
        </Container>
    );
};
