  import './App.css';
  import sample from './sample.jpeg';
  import Profile from './profile';
  import Home from './home';
  import {Route, Link} from "react-router-dom"
function App() {

  return (
      <div className="App">
          <Route exact path="/" component={Home} />
          <Route exact path="/profile" component={Profile} />
      </div>
  );
}

export default App;
