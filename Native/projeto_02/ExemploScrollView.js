import {View, Text, ScrollView, StyleSheet} from 'react-native'
import React from 'react'

export default function ExemploScrollView() {
    return (
        <View>
            <ScrollView horizontal style={styles.scroll}>
                <Text style={styles.text}>Exemplo1</Text>
                <Text style={styles.text}>Exemplo2</Text>
                <Text style={styles.text}>Exemplo3</Text>
                <Text style={styles.text}>Exemplo4</Text>
                <Text style={styles.text}>Exemplo5</Text>
            </ScrollView>
        </View>
    )
}

const styles = StyleSheet.create({
    text: {
        color: "red",
        fontSize: 28,
    },

    scroll:{
        backgroundColor: 'white',
        height: 100,
    }
})
