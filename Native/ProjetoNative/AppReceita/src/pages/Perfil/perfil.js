import React, { useState, useEffect } from 'react';
import { View, Text, TouchableOpacity, Alert, Image, ScrollView } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { styles } from './style';
import Octicons from 'react-native-vector-icons/Octicons'

export default function Perfil({ navigation }) {
    const [user, setUser] = useState(null);
    const [favorites, setFavorites] = useState([]);

    const loadUser = async () => {
        try {
            const storedUser = await AsyncStorage.getItem('@user');
            if (storedUser) {
                setUser(JSON.parse(storedUser));
                loadFavorites();
            } else {
                setUser(null);
                setFavorites([]);
            }
        } catch (error) {
            console.error('Erro ao carregar usuário:', error);
        }
    };

    const loadFavorites = async () => {
        try {
            const storedFavorites = await AsyncStorage.getItem('@favorites');
            setFavorites(storedFavorites ? JSON.parse(storedFavorites) : []);
        } catch (error) {
            console.error('Erro ao carregar os favoritos:', error);
        }
    };

    useEffect(() => {
        const unsubscribe = navigation.addListener('focus', loadUser);
        return unsubscribe;
    }, [navigation]);

    const handleLogout = async () => {
        try {
            await AsyncStorage.removeItem('@user');
            setUser(null);

            await AsyncStorage.removeItem('@favorites');
            setFavorites([]);

            Alert.alert('Sucesso', 'Você saiu da conta.');

            navigation.reset({
                index: 0,
                routes: [{ name: 'Home' }],
            });
        } catch (error) {
            console.error('Erro ao deslogar:', error);
        }
    };

    function filterDesc(desc) {
        if (typeof desc === 'string' && desc.length < 20) {
            return desc;
        }

        return typeof desc === 'string' ? `${desc.substring(0, 20)}...` : '';
    }


    if (!user) {
        return (
            <View style={styles.container}>
                <Text style={styles.title}>Bem-vindo(a)!</Text>
                <Text style={styles.info}>Para acessar seu perfil, faça login ou cadastre-se.</Text>

                <TouchableOpacity
                    style={styles.button}
                    onPress={() => navigation.replace('Login')}
                >
                    <Text style={styles.buttonText}>Fazer Login</Text>
                </TouchableOpacity>

                <TouchableOpacity
                    style={styles.buttonSecondary}
                    onPress={() => navigation.replace('Cadastro')}
                >
                    <Text style={styles.buttonTextSecondary}>Cadastrar-se</Text>
                </TouchableOpacity>
            </View>
        );
    }

    return (
        <ScrollView contentContainerStyle={styles.content}>
            <Image
                source={user.Avatar ? { uri: user.Avatar } : require('../../../assets/User.png')}
                style={styles.userImage}
            />
            <Text style={styles.infoNome}>{user.Nome}</Text>
            <Text style={styles.infoEmail}>{user.Email}</Text>

            <Text style={styles.textFavoritos}>Receitas Favoritas</Text>
            <View style={styles.list}>
                {favorites.length === 0 ? (
                    <Text style={styles.infoNoDescription}>Você ainda não favoritou nenhuma receita.</Text>
                ) : (
                    favorites.map((receita, index) => (
                        <View key={index} style={styles.item}>
                            <TouchableOpacity
                                onPress={() => navigation.navigate("Detalhe", { receita })}
                            >
                                <Image
                                    style={styles.receitaImg}
                                    source={{ uri: receita.imagem }}
                                />
                                <Text style={styles.receitaTitle}>{filterDesc(receita.nome)}</Text>
                            </TouchableOpacity>

                            <View style={styles.containerAvaliacao}>
                                <Octicons
                                    name="star-fill"
                                    size={14}
                                    color={'#e7a74e'}
                                    style={styles.iconeAvaliacao}
                                />

                                <Text style={styles.textoAvaliacao}>
                                    {receita.avaliacao}
                                </Text>
                            </View>
                        </View>
                    ))
                )}
            </View>

            <TouchableOpacity style={styles.buttonLogout} onPress={handleLogout}>
                <Text style={styles.buttonTextLogout}>Sair</Text>
            </TouchableOpacity>
        </ScrollView>
    );
}