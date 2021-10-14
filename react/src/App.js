  import './App.css';
  import sample from './sample.jpeg';
  import Profile from './profile';
  import Home from './home';
  import Login from './login';
  import {Route, Link, BrowserRouter, Switch} from "react-router-dom"
import Register from './register';
function App() {

  return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/profile" component={Profile} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
        </Switch>
      </BrowserRouter>
  );
}

export default App;
