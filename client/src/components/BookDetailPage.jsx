import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const BookDetailPage = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [book, setBook] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    axios.get(`http://localhost:8080/catalog/books/${id}`).then((response) => {
      setBook(response.data.body);
      setIsLoading(false);
    });
  }, []);

  return (
    <>
      {isLoading ? (
        <div>Loading...</div>
      ) : (
        <>
          <div className="pl-2">
            <h1 className="text-4xl mb-2">Title: {book.title}</h1>
            <div className="flex mb-2">
              <p className="mr-2">
                <span className="font-semibold">Author: </span>
                <a href="">{`${book.authorLastName}, ${book.authorFirstName}`}</a>
              </p>
            </div>
            <div className="flex mb-2">
              <p className="mr-2 max-w-5xl">
                <span className="font-semibold">Summary:</span> {book.summary}
              </p>
            </div>
            <div className="flex mb-2">
              <p className="mr-2">
                <span className="font-semibold">ISBN:</span> {book.isbn}
              </p>
            </div>
            <div className="flex mb-2">
              <p className=" mr-2">
                <span className="font-semibold">Genre:</span> {book.genreName}
              </p>
            </div>
          </div>
        </>
      )}
    </>
  );
};

export default BookDetailPage;
