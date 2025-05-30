import logo from './logo.svg';
import './App.css';
import {Routes, Route} from 'react-router-dom'
import Router from './routes/Router';
import Header from './components/Header';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Router />  {/* Router.jsx의 설정을 불러와서 사용 */}
    </BrowserRouter>
    </div>
  );
}

export default App;
