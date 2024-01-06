import { useEffect, useState } from "react";
import axios from "axios";

const Catalog = () => {
  const [authorCount, setAuthorCount] = useState(0);
  const [bookCount, setBookCount] = useState(0);
  const [bookInstanceCount, setBookInstanceCount] = useState(0);
  const [bookInstanceAvailableCount, setBookInstanceAvailableCount] =
    useState(0);
  const [genreCount, setGenreCount] = useState(0);

  useEffect(() => {
    axios
      .get("http://localhost:8080/catalog/authors/count")
      .then((response) => {
        setAuthorCount(response.data);
      });

    axios.get("http://localhost:8080/catalog/book/count").then((response) => {
      setBookCount(response.data);
    });

    axios
      .get("http://localhost:8080/catalog/bookinstance/count")
      .then((response) => {
        setBookInstanceCount(response.data);
      });

    axios
      .get("http://localhost:8080/catalog/bookinstance/count/available")
      .then((response) => {
        setBookInstanceAvailableCount(response.data);
      });

    axios.get("http://localhost:8080/catalog/genre/count").then((response) => {
      setGenreCount(response.data);
    });
  }, []);

  return (
    <div className="pl-2">
      <h1 className="text-4xl mb-2">Local Library Home</h1>
      <p className="mb-4">
        Welcome to <em>LocalLibrary</em>, a very basic Express website developed
        as a tutorial example on the Mozilla Developer Network.
      </p>
      <h1 className="text-4xl mb-2">Dynamic content</h1>
      <p>The library has the following record counts:</p>
      <ul className="list-disc ml-8">
        <li>
          <strong>Books: {bookCount}</strong>
        </li>
        <li>
          <strong>Copies: {bookInstanceCount}</strong>
        </li>
        <li>
          <strong>Copies available: {bookInstanceAvailableCount}</strong>
        </li>
        <li>
          <strong>Authors: {authorCount}</strong>
        </li>
        <li>
          <strong>Genres: {genreCount}</strong>
        </li>
      </ul>
    </div>
  );
};

export default Catalog;
