import { useState, useEffect } from "react";
import axios from "axios";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";

const BookForm = () => {
  const [title, setTitle] = useState("");
  const [genres, setGenres] = useState([]);
  const [authors, setAuthors] = useState([]);

  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    formState: { isSubmitting, errors },
  } = useForm();

  useEffect(() => {
    axios.get("http://localhost:8080/catalog/genres").then((response) => {
      setGenres(response.data.content);
    });
    axios.get("http://localhost:8080/catalog/authors").then((response) => {
      setAuthors(response.data.content);
    });
  }, []);

  return (
    <>
      <div className="pl-2">
        <h1 className="text-4xl mb-4">Create Book</h1>
        <form onSubmit={""} className="flex flex-col gap-3 max-w-52">
          <input
            className="border-2 border-gray-400 rounded p-2 focus:border-2 focus:border-blue-600 focus:outline-none "
            type="text"
            value={title}
            placeholder="Enter title"
            {...register("title", {
              onChange: (e) => {
                setTitle(e.target.value);
              },
              pattern: {
                value: /^([^0-9]*)$/,
                message: "Name must be only letters",
              },
              required: { value: true, message: "Title is required" },
              maxLength: {
                value: 100,
                message: "Title must be less than 100 characters",
              },
            })}
          />
          <select
            name="genre"
            className="border-2 border-gray-400 rounded p-2 focus:border-2 focus:border-blue-600 focus:outline-none"
          >
            <option>--Choose a genre--</option>
            {genres.map((genre) => {
              return (
                <option key={genre.id} value={genre.id}>
                  {genre.name}
                </option>
              );
            })}
          </select>
          <select
            name="author"
            className="border-2 border-gray-400 rounded p-2 focus:border-2 focus:border-blue-600 focus:outline-none"
          >
            <option>--Choose an author--</option>
            {authors.map((author) => {
              return (
                <option key={author.id} value={author.id}>
                  {author.lastname}, {author.firstname}
                </option>
              );
            })}
          </select>
        </form>
      </div>
    </>
  );
};

export default BookForm;
