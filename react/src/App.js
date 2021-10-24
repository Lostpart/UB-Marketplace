
import './App.css';
import Profile from './profile';
import Home from './home';
import Login from './login';
import Item_Detail from './item_detail';
import {Route, Switch, HashRouter} from "react-router-dom"
import Register from './register';
import Sell from './sell';

function App() {
  return (
      <HashRouter>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/profile" component={Profile} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/sell" component={Sell} />
          <Route path="/item" component={Item_Detail} />
        </Switch>
      </HashRouter>
  );
}

export default App;
