import { View, Text, SectionList, StyleSheet } from "react-native";
import React from "react";

export default function Kaito() {
    const DATA = [
        {
            title: "Frutas",
            data: ["Laranja", "Maça", "Abacate"],
        },
        {
            title: "Legumes",
            data: ["Abóbora", "Cenoura", "Rabanete"],
        },
        {
            title: "Carne",
            data: ["Frango", "Porco", "Peixe"],
        },
    ];

    const renderItem = ({ item }) => {
        <View>
            <Text>{item}</Text>
        </View>;
    };

    const renderSectionHeader = ({ section: { title } }) => {
        <View>
            <Text>{title}</Text>
        </View>;
    };

    return (
        <View>
            <SectionList
                data={DATA}
                renderItem={renderItem}
                keyExtractor={(item, index) => item}
                renderSectionHeader={renderSectionHeader}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: 24,
    },

    sectionHeader: {
        backgroundColor: "#F5F5F5",
        padding: 8,
    },

    sectionHeaderText: {
        fontSize: 16,
        fontWeight: "bold",
    },

    item: {
        padding: 10,
        fontSize: 12,
        height: 44,
    },
});
