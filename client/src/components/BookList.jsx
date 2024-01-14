import axios from "axios";
import { useEffect, useState } from "react";

const BookList = () => {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/catalog/book").then((response) => {
      setBooks(response.data);
    });
  }, []);

  return (
    <div className="pl-2">
      <h1 className="text-4xl mb-2">Book List</h1>
      {books.length ? (
        <ul className="list-disc ml-8">
          {books.map((book) => {
            return (
              <li key={book[0].id} className="hover:text-neutral-600">
                <a href={`/catalog/book/${book[0].id}`}>
                  <span className="font-bold">{book[0].title}</span> by{" "}
                  {book[1].lastname}, {book[1].firstname}
                </a>
              </li>
            );
          })}
        </ul>
      ) : (
        <div className="text-red-500 font-semibold">No books found</div>
      )}
    </div>
  );
};

export default BookList;
