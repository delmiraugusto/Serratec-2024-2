import axios from 'axios';

const key = import.meta.env.VITE_KEY
const baseURl = `https://${key}.mockapi.io`;

const usersEndpoint = import.meta.env.VITE_URL_USERS;
const productsEndpoint = import.meta.env.VITE_URL_PRODUCTS;


export const fetchUsers = async () => {
    try {
        const response = await axios.get(`${baseURl}${usersEndpoint}`);
        return response.data;
    } catch (error) {
        console.error('Erro ao buscar usuários:', error);
        throw error;
    }
};

export const deleteUser = async (id) => {
    try {
        await axios.delete(`${baseURl}${usersEndpoint}/${id}`);
        console.log("Usuário deletado com sucesso");
    } catch (error) {
        console.error('Erro ao deletar usuário:', error);
        throw error;
    }
};

export const fetchProducts = async () => {

    try {
        const response = await axios.get(`${baseURl}${productsEndpoint}`);
        return response;
    } catch (error) {
        console.error('Erro 1:', error);
        throw error;
    }
}

export const addProduct = async (productData) => {
    try {
        const response = await axios.post(`${baseURl}${productsEndpoint}`, productData);
        return response.data;
    } catch (error) {
        console.error('Erro ao adicionar produto:', error);
        throw error;
    }
};

export const deleteProduct = async (id) => {
    try {
        await axios.delete(`${baseURl}${productsEndpoint}/${id}`);
        console.log("Produto deletado com sucesso")
    } catch (error) {
        console.error('Erro ao deletar produto:', error);
        throw error;
    }
}

export const fetchProductById = async (id) => {
    try {
        const response = await axios.get(`${baseURl}${productsEndpoint}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Erro ao buscar produto:', error);
        throw error;
    }
}