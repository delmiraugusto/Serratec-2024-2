import React from 'react';
import { View, Text, Alert, Image, TouchableOpacity } from 'react-native';
import { styles } from './style';

export default function Categoria() {
  const fetchCategoryData = async (categoria) => {
    try {
      const response = await fetch(`https://66fdc9b2699369308956334c.mockapi.io/receitas${categoria}`);
      if (!response.ok) {
        throw new Error(`Erro ao buscar dados da categoria ${categoria}`);
      }
      const data = await response.json();
      console.log(data);
      Alert.alert('Sucesso', `Dados da categoria ${categoria} carregados!`);
    } catch (error) {
      console.error(error);
      Alert.alert('Erro', `Falha ao carregar a categoria ${categoria}`);
    }
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity
        style={styles.button}
        onPress={() => fetchCategoryData('Norte')}
      >
        <Image
          style={styles.img}
          source={require('../../../assets/PratoNorteCategoria.jpg')}
        />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Norte</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.button}
        onPress={() => fetchCategoryData('Nordeste')}
      >
        <Image
          style={styles.img}
          source={require('../../../assets/PratoNordesteCategoria.jpg')}
        />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Nordeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.button}
        onPress={() => fetchCategoryData('Centro-oeste')}
      >
        <Image
          style={styles.img}
          source={require('../../../assets/PratoCentroOesteCategoria.jpg')}
        />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Centro-Oeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.button}
        onPress={() => fetchCategoryData('Centro-oeste')}
      >
        <Image
          style={styles.img}
          source={require('../../../assets/PratoTipicoSudesteCategoria.jpeg')}
        />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Sudeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.button}
        onPress={() => fetchCategoryData('Centro-oeste')}
      >
        <Image
          style={styles.img}
          source={require('../../../assets/PratoSulCategoria.jpg')}
        />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Sul</Text>
        </View>
      </TouchableOpacity>
    </View>
  );
}
