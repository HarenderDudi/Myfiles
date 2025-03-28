import './App.css';
import Dashboard from "./components/Dashboard";
import Header from './components/layers/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom"
import AddProject from './components/projects/AddProject';
import { Provider } from 'react-redux';
import store from './store';
import UpdateProject from './components/projects/UpdateProject';


function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header> </Header>
          <Route exact path="/dashboard" component={Dashboard}></Route>
          <Route exact path="/addProject" component={AddProject}></Route>
          <Route exact path="/updateProject/:id" component={UpdateProject}></Route>
        </div>
      </Router>
    </Provider>
    
  );
}

export default App;