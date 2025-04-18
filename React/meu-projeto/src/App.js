import './App.css';
import { Frase } from './components/frase';
import { HelloWorld } from './components/HelloWorld';

function App() {
  const name = "Delmir"

  const newName = name.toUpperCase()

  function sum(a, b) {
    return a + b
  }

  const url = "https://via.placeholder.com/150"

  return (
    <div className="App">
      <h2>Alterando o JSX</h2>
      <p>Olá, {newName}</p>
      <p>Soma: {sum(4, 2)}</p>
      <img src={url} alt="Minha imagem" />
      <HelloWorld />
      <Frase/>

    </div>
  );
}

export default App;
