import logo from './logo.png';
import './App.css';

import Body from './components/Content';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Cadastro de veículos
        </p>
      </header>
	  <Body/>
    </div>
  );
}

export default App;
