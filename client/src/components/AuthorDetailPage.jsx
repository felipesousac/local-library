import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const AuthorDetailPage = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [author, setAuthor] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/catalog/authors/${id}`)
      .then((response) => {
        setAuthor(response.data);
        setIsLoading(false);
      });
  }, []);

  // CONTINUE FROM HERE
  return (
    <>
      {isLoading ? (
        <div className="pl-2">Loading...</div>
      ) : (
        <>
          <div className="pl-2">
            <h1 className="text-4xl mb-2">
              Title: {author.lastName}, {author.firstName}
            </h1>
            <p>
              {`Birth: ${author.birthDate}`}
              {author.deathDate ? ` Death: ${author.deathDate}` : ""}
            </p>
            <h4 className="ml-5 mt-4 pb-3 text-2xl border-b">Books</h4>
            {author.books.length ? (
              <>
                {author.books.map((book) => {
                  return (
                    <div key={book._id} className="ml-5">
                      <p className="pt-5">
                        <a
                          href={`/catalog/book/${book._id}`}
                          className="font-semibold text-xl text-blue-500"
                        >
                          {book.title}
                        </a>
                      </p>
                      <p className="text-lg max-w-5xl">{book.summary}</p>
                    </div>
                  );
                })}
              </>
            ) : (
              <div className="text-red-500 font-semibold">
                No copies of this book found in this library.
              </div>
            )}
          </div>
        </>
      )}
    </>
  );
};

export default AuthorDetailPage;
