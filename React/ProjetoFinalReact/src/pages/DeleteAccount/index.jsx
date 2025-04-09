import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import { fetchUsers } from '../../servicesAPI';
import axios from 'axios';

const DeleteAccount = () => {
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);
    const history = useHistory();

    useEffect(() => {
        const getUserData = async () => {
            try {
                const users = await fetchUsers();
                const loggedUser = users.find(u => u.isLoggedIn);
                setUser(loggedUser);
            } catch (err) {
                setError('Erro ao buscar dados do usuário');
            }
        };

        getUserData();
    }, []);

    const handleDeleteAccount = async () => {
        if (user) {
            try {
                await axios.delete(`https://${process.env.VITE_KEY}.mockapi.io/users/${user.id}`);
                alert('Conta deletada com sucesso!');
                history.push('/login');
            } catch (err) {
                setError('Erro ao deletar conta');
            }
        }
    };

    if (!user) {
        return <div>Carregando...</div>;
    }

    return (
        <div>
            <h2>Deletar Conta</h2>
            <p>Tem certeza de que deseja deletar sua conta?</p>
            <button onClick={handleDeleteAccount}>Sim, deletar minha conta</button>
            <button onClick={() => history.push('/')}>Cancelar</button>
            {error && <p>{error}</p>}
        </div>
    );
};

export default DeleteAccount;
