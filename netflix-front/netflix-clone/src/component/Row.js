import React, { useState, useEffect } from "react";
import axios from "../api/axios";
import "../component/Row.css";
import { useHistory } from "react-router-dom";

function Row({ title, fetchUrl }) {
  const [movies, setMovies] = useState([]);
  const history = useHistory();

  useEffect(() => {
    async function fetchData() {
      const request = await axios.get(fetchUrl);
      setMovies(request.data);
      return request;
    }
    fetchData();
  }, [fetchUrl]);

  function handleClick(params) {
    history.push(`/movie/${params}`);
  }

  return (
    <div className="row">
      <h2>{title}</h2>
      <div className="row__posters">
        {movies.map((item) => (
          <div key={item.id} className="row__poster">
            <img src={item.image} alt={item.name} />
            <h5>{item.name}</h5>
            <button
              type="button"
              value={item.id}
              onClick={(e) => handleClick(e.target.value)}
            >
              Details
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Row;
