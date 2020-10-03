import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "../api/axios";
import request from "../api/request";
import { useForm } from "react-hook-form";
import ReactPlayer from "react-player";

function MovieDetails() {
  const { id } = useParams();
  const [movie, setMovie] = useState([]);
  const [recommendation, setRecommendation] = useState([]);
  const { register, handleSubmit } = useForm();

  useEffect(() => {
    async function fetchData() {
      const requestMovie = await axios.get(request.fetchMovies + `/${id}`);
      setMovie(requestMovie.data);
      const requestRecommendation = await axios.get(
        request.fetchRecommendation + `/${id}`
      );

      setRecommendation(requestRecommendation.data);
      return requestRecommendation;
    }

    fetchData();
  }, [id]);

  const onSubmit = (data) => {
    const myObj = {
      comment: data.comment,
      rating: data.rating,
      videoId: `${id}`,
    };
    addRecommendation(myObj);
    window.location.reload();
  };
  console.log(movie);
  return (
    <div>
      <h1>Movie</h1>
      <ul>
        <li>Id {movie.id}</li>
        <li>Title {movie.name}</li>
      </ul>
      <div>
        <ReactPlayer url={movie.url} />
      </div>

      <h2>Recommendation</h2>

      {recommendation.map((item) => (
        <div key={item.id}>
          <ul>
            <li className="">Comment {item.comment}</li>
            <li className="">Rating {item.rating}</li>
          </ul>
        </div>
      ))}
      <h2>Add new recommendation</h2>
      <div className="form">
        <form onSubmit={handleSubmit(onSubmit)}>
          <input
            name="comment"
            ref={register({ required: true, minLength: 3 })}
          />
          <select name="rating" ref={register}>
            <option value="5">5</option>
            <option value="4">4</option>
            <option value="3">3</option>
            <option value="2">2</option>
            <option value="1">1</option>
          </select>
          <button type="submit">Add</button>
        </form>
      </div>
    </div>
  );
}

export default MovieDetails;

async function addRecommendation(params) {
  await axios.post(request.postRecommendation, params);
}
