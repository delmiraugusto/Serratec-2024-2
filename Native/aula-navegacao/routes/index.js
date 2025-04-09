import { createDrawerNavigator } from "@react-navigation/drawer";
import Home from "../screens/Home";
import Sobre from "../screens/Sobre";
import Contato from "../screens/Contato";
import CustomDrawer from "../components/CustomDrawer";

export default function Routes() {
    const Drawer = createDrawerNavigator();
    return (
        <Drawer.Navigator
            drawerContent={CustomDrawer}
            screenOptions={{
                drawerActiveBackgroundColor: "#0088",
                drawerInactiveBackgroundColor: "gray",
                drawerActiveTintColor: "green",
                drawerInactiveTintColor: "red",
                drawerStyle: {
                    backgroundColor: "#d9d9d9",
                    width: 250,
                },
            }}
        >
            <Drawer.Screen name="Home" component={Home} />
            <Drawer.Screen name="Sobre" component={Sobre} />
            <Drawer.Screen name="Contato" component={Contato} />
        </Drawer.Navigator>
    );
}
