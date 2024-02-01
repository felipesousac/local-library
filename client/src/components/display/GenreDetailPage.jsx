import axios from "axios";
import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";

const GenreDetailPage = () => {
  const [booksByGenre, setBooksByGenre] = useState([]);
  const [title, setTitle] = useState("");
  const { id } = useParams();

  useEffect(() => {
    axios.get(`http://localhost:8080/catalog/genres/${id}`).then((response) => {
      setBooksByGenre(response.data);
      setTitle(response.data[0][1].name);
    });
  }, []);

  return (
    <div className="pl-2">
      <h1 className="text-4xl mb-2">Genre: {title}</h1>
      <h2 className="text-2xl mb-2 ml-3">Books</h2>
      {booksByGenre.length ? (
        <div className="list-disc ml-3">
          {booksByGenre.map((book) => {
            return (
              <div key={book[0].id} className="mb-2">
                <Link
                  className=" text-blue-600 font-semibold hover:text-blue-800"
                  to={`/catalog/books/${book[0].id}`}
                >
                  {book[0].title}
                </Link>
                <p className="max-w-lg">{book[0].summary}</p>
              </div>
            );
          })}
        </div>
      ) : (
        <div className="text-red-500 font-semibold ml-3">
          This genre has no books
        </div>
      )}
    </div>
  );
};

export default GenreDetailPage;
