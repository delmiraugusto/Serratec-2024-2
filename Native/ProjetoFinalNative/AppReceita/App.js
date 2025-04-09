import Routes from './src/routes/routes';
import { NavigationContainer } from '@react-navigation/native';
import Navbar from './src/components/NavBar/navbar';

export default function App() {
  return (
    <NavigationContainer>
      <Navbar />
      <Routes />
    </NavigationContainer>
  );
}