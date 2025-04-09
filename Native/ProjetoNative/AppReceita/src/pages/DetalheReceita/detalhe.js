import React, { useState, useEffect } from 'react';
import { View, Text, TouchableOpacity, Image, ScrollView, Alert } from 'react-native';
import AntDesign from 'react-native-vector-icons/AntDesign';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { styles } from './style';
import IconeAvaliacao from '../../components/RatingStar/rating';

export default function Detalhe({ route }) {
    const { receita } = route.params;
    const [isFavorited, setIsFavorited] = useState(false);

    const ingredientesArray = receita.ingredientes.split(',').map((item) => item.trim());

    useEffect(() => {

        const checkIfFavorited = async () => {
            try {
                const storedUser = await AsyncStorage.getItem('@user');
                if (storedUser) {
                    const storedFavorites = await AsyncStorage.getItem('@favorites');
                    const favorites = storedFavorites ? JSON.parse(storedFavorites) : [];

                    setIsFavorited(favorites.some((favorite) => favorite.id === receita.id));
                }
            } catch (error) {
                console.error('Erro ao verificar favoritos:', error);
            }
        };

        checkIfFavorited();
    }, [receita]);

    const toggleFavorite = async () => {
        try {
            const storedUser = await AsyncStorage.getItem('@user');
            if (!storedUser) {
                Alert.alert('Atenção', 'Você precisa estar logado para favoritar uma receita.');
                return;
            }

            const storedFavorites = await AsyncStorage.getItem('@favorites');
            const favorites = storedFavorites ? JSON.parse(storedFavorites) : [];

            if (isFavorited) {
                const updatedFavorites = favorites.filter((favorite) => favorite.id !== receita.id);
                await AsyncStorage.setItem('@favorites', JSON.stringify(updatedFavorites));
                setIsFavorited(false);
            } else {
                favorites.push(receita);
                await AsyncStorage.setItem('@favorites', JSON.stringify(favorites));
                setIsFavorited(true);
            }
        } catch (error) {
            console.error('Erro ao atualizar favoritos:', error);
        }
    };

    return (
        <View style={styles.container}>
            <ScrollView
                showsVerticalScrollIndicator={false}
                contentContainerStyle={{
                    paddingVertical: 10,
                    paddingHorizontal: 20,
                }}
            >
                <Image source={{ uri: receita.imagem }} style={styles.imagem} />


                <TouchableOpacity style={styles.buttonHeart} onPress={toggleFavorite}>
                    <AntDesign
                        name="heart"
                        size={25}
                        color={isFavorited ? 'red' : 'white'}
                    />
                </TouchableOpacity>
                <Text style={styles.titulo}>{receita.nome}</Text>

                <View style={styles.avaliacaoContainer}>
                    <IconeAvaliacao />
                    <Text style={styles.textoAvaliacao}>{receita.avaliacao}</Text>
                </View>

                
                <Text style={styles.subTitulo}>Ingredientes:</Text>
                <View style={styles.ingredientesContainer}>
                    {ingredientesArray.length === 0 ? (
                        <Text style={styles.info}>Nenhum ingrediente disponível.</Text>
                    ) : (
                        ingredientesArray.map((ingrediente, index) => (
                            <Text key={index} style={styles.ingrediente}>
                                • {ingrediente}
                            </Text>
                        ))
                    )}
                </View>

                <View style={styles.footer}>
                    <Text style={styles.subTitulo}>Modo de Preparo:</Text>
                    <Text style={styles.descricao}>{receita.descricao}</Text>
                </View>
            </ScrollView>
        </View>
    );
}
