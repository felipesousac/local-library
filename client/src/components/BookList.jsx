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
      <ul className="list-disc ml-8">
        {books.map((book) => {
          const url = `/catalog/book/${book[0].id}`;
          return (
            <li key={book[0].id} className="hover:text-neutral-600">
              <a href={url}>
                <span className="font-bold">{book[0].title}</span> by {book[2]},{" "}
                {book[1]}
              </a>
            </li>
          );
        })}
      </ul>
    </div>
  );
};

export default BookList;
