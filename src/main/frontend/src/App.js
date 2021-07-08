import logo from './logo.svg';
import './App.css';
import { Flight } from './Flight.js';
import { SearchForm } from './SearchForm.js'


function App() {
  return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
            <SearchForm  />
            </div>
          </header>
        </div>
  );
}

export default App;