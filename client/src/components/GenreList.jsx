import axios from "axios";
import { useState, useEffect } from "react";

const GenreList = () => {
  const [genres, setGenres] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/catalog/genre").then((response) => {
      setGenres(response.data);
    });
  }, []);

  return (
    <div className="pl-2">
      <h1 className="text-4xl mb-2">Genre List</h1>
      {genres.length ? (
        <ul className="list-disc ml-8">
          {genres.map((genre) => {
            return (
              <li key={genre.id} className="hover:text-neutral-600">
                <a href={`/catalog/genre/${genre.id}`}>{genre.name}</a>
              </li>
            );
          })}
        </ul>
      ) : (
        <div className="text-red-500 font-semibold">
          No genres found in this library
        </div>
      )}
    </div>
  );
};

export default GenreList;
