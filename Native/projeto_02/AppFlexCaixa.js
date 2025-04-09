import { View, Text, StyleSheet, LogBox } from "react-native";
import React from "react";

export default function AppFlexCaixa() {
    return(
        <View style={styles.container}>
            <View style={styles.box}>
                <Text>Voltar</Text>
                <Text>Home</Text>
                <Text>Detalhes</Text>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'white',
    },
    box: {
        backgroundColor: 'white',
        width: '100%',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        height: 100,
        fontSize: 15,

        padding: 10
    }
});