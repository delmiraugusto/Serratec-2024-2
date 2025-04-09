import React, { useState } from 'react';
import { View, Text, Alert, Image, TouchableOpacity } from 'react-native';
import { styles } from './style';

export default function Categoria({ navigation }) {
  const [receitas, setReceitas] = useState([]);
  const [categoriaAtual, setCategoriaAtual] = useState('');

  const fetchCategoryData = async (categoria) => {
    try {
      const response = await fetch('https://66fdc9b2699369308956334c.mockapi.io/receitas');
      if (!response.ok) {
        throw new Error('Erro ao buscar dados');
      }
      const data = await response.json();

      const receitasFiltradas = data.filter(receita => receita.categoria === categoria);
      setReceitas(receitasFiltradas);
      setCategoriaAtual(categoria); 

      navigation.navigate('ReceitasPorCategoria', {
        categoria: categoria,
        receitas: receitasFiltradas,
      });
    } catch (error) {
      Alert.alert('Erro', 'Falha ao carregar as receitas');
    }
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.button} onPress={() => fetchCategoryData('Norte')}>
        <Image style={styles.img} source={require('../../../assets/PratoNorteCategoria.jpg')} />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Norte</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={() => fetchCategoryData('Nordeste')}>
        <Image style={styles.img} source={require('../../../assets/PratoNordesteCategoria.jpg')} />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Nordeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={() => fetchCategoryData('Centro-Oeste')}>
        <Image style={styles.img} source={require('../../../assets/PratoCentroOesteCategoria.jpg')} />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Centro-Oeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={() => fetchCategoryData('Sudeste')}>
        <Image style={styles.img} source={require('../../../assets/PratoTipicoSudesteCategoria.jpeg')} />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Sudeste</Text>
        </View>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={() => fetchCategoryData('Sul')}>
        <Image style={styles.img} source={require('../../../assets/PratoSulCategoria.jpg')} />
        <View style={styles.textOverlay}>
          <Text style={styles.textButton}>Sul</Text>
        </View>
      </TouchableOpacity>
    </View>
  );
}
