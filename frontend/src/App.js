import { Header, Template, Cards } from './components/common';
import { CardServics } from './components/fieldTypes';
import './App.css';
function App() {
  return (
    <div className="App">
      <div className="container-fluid">
        <div className="row">
        <Header />
        </div>
        <div className="row"></div>
        <Template />
        </div>
    </div>
  );
}

export default App;
