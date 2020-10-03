import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import axios from "../api/axios";
import requests from "../api/request";
import "../component/Banner.css";

function Banner() {
  const [movie, setmovie] = useState([]);
  const history = useHistory();

  useEffect(() => {
    async function fetchData() {
      const request = await axios.get(requests.fetchMovies);
      setmovie(request.data[Math.floor(Math.random() * request.data.length)]);
      return request;
    }
    fetchData();
  }, []);

  function handleclick(params) {
    history.push(`/movie/${params}`);
  }

  return (
    <header
      className="banner"
      style={{
        backgroundSize: "cover",
        backgroundImage: `url(${movie.image})`,
        backgroundPosition: "center center",
      }}
    >
      <div className="banner__content">
        <h1 className="banner__title">{movie.name}</h1>

        <div className="banner__buttons">
          <button
            className="banner__button"
            value={movie.id}
            onClick={(e) => handleclick(e.target.value)}
          >
            View Details
          </button>
        </div>
      </div>
    </header>
  );
}

export default Banner;
