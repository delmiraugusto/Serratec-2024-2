import axios from 'axios';

export const GetProduto = async () => {
    const url = 'https://66fdc9b2699369308956334c.mockapi.io/receitas';

    try {
        const respostaApi = await axios.get(url);
        return respostaApi;
    } catch (error) {
        console.error('Erro ao buscar produtos:', error);
    }
};
