

import { View, Text,Image } from 'react-native'
import React from 'react'
import { styles } from './style'

export default function DetalhesCard() {


  return (
    <View style= {styles.container}>
        <View>
            <Image source="" />
            <View>
                <Text>Nome comida</Text>
                <Image source="" />
            </View>
            <View>
                <Text>★★★★★</Text>

            </View>
            <View>
                <Text>Ingredientes</Text>
                <Text>⦁ Ingredientes 1</Text>
                <Text>⦁ Ingredientes 2</Text>
                <Text>⦁ Ingredientes 3</Text>
                <Text>⦁ Ingredientes 4</Text>
                <Text>⦁ Ingredientes 5</Text>
                <Text>⦁ Ingredientes 6</Text>
                <Text>⦁ Ingredientes 7</Text>

            </View>
            <View>
                <Text>PASSO A PASSO DA RECEITA</Text>
            </View>
        </View>
    </View>
  )
}