import Routes from './src/routes/routes';
import { NavigationContainer } from '@react-navigation/native';
import Navbar from './src/components/NavBar/navbar';
import { SplashScreen } from './src/pages/Splash/splashscreen';
import { useState } from 'react';

export default function App() {
  const [splashComplete, setSplashComplete] = useState(false);

  const handleSplashComplete = () => {
    setSplashComplete(true);
  };

  return (
    <NavigationContainer>
      {splashComplete ? (
        <>
          <Navbar />
          <Routes />
        </>
      ) : (
        <SplashScreen onComplete={handleSplashComplete} /> 
      )}
    </NavigationContainer>
  );
}
