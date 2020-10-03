import React from "react";
import "./App.css";
import Row from "./component/Row";
import request from "./api/request";
import Banner from "./component/Banner";
import { Switch, Route, BrowserRouter as Router } from "react-router-dom";
import MovieDetails from "./component/MovieDetails";
import NavbarUp from "./component/Navbar";

function App() {
  return (
    <Router>
      <div className="app">
        <NavbarUp />
        <Switch>
          <Route exact path="/">
            <Banner />
            <Row title="Movies" fetchUrl={request.fetchMovies} />
          </Route>
          <Route exact path="/movie/:id" component={MovieDetails} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
