import {View, Text, StyleSheet, FlatList} from 'react-native'
import React from 'react'

export default function ExemploFlatList() {
    const alunos = [
        {matricula: 123, nome: "Jose"},
        {matricula: 132, nome: "Arthur"},
        {matricula: 323, nome: "Delso"},
        {matricula: 421, nome: "Maria"},
        {matricula: 423, nome: "Miro"},
        {matricula: 424, nome: "Silva"},
        {matricula: 426, nome: "Tana"},
        {matricula: 427, nome: "Tana"},

    ]


    const renderItem = ({item}) => {
        return (
            <View style={styles.item}>
                <Text>{item.nome}</Text>
            </View>
        )
    }

    return (
        <View style={styles.container}>
            <FlatList data={alunos} renderItem={renderItem} keyExtractor={(item) => item.matricula}/>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: 20,
    },
    item:{
     backgroundColor: 'gray',
        padding: 20,
        marginHorizontal: 16,
        marginVertical: 40,
    }
})

