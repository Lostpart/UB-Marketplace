  import './App.css';
  import sample from './sample.jpeg';
  import Profile from './profile';
  import Home from './home';
  import Login from './login';
  import {Route, Link} from "react-router-dom"
import Register from './register';
function App() {

  return (
      <div className="App">
          <Route exact path="/" component={Home} />
          <Route exact path="/profile" component={Profile} />
          <Route exact path="/login" component={Login} />
          <Route exact path="/register" component={Register} />
      </div>
  );
}

export default App;
