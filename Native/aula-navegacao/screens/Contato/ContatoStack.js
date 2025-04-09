import { Button, StyleSheet, Text, View } from "react-native";
import React from "react";
import { StackActions, useNavigation } from "@react-navigation/native";

export default function Contato() {
  const navigation = useNavigation();
  return (
    <View style={styles.container}>
      <Button title="Home" onPress={() => navigation.dispatch(StackActions.popToTop)}></Button>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
  },
});
