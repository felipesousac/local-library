import { useState } from "react";
import axios from "axios";

const GenreForm = () => {
  const [name, setName] = useState("");

  const createGenre = async (e) => {
    e.preventDefault();

    const headers = {
      headers: {
        "Content-Type": "application/json",
      },
    };

    await axios
      .post("http://localhost:8080/catalog/genres", { name }, headers)
      .then((response) => {
        console.log(response);
        setName("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="pl-2">
      <h1 className="text-4xl mb-4">Create Genre</h1>
      <form className="flex flex-col gap-3" onSubmit={createGenre}>
        <input
          className="border border-gray-400 rounded p-2"
          type="text"
          value={name}
          name="name"
          placeholder="Enter genre name"
          required
          onChange={(e) => setName(e.target.value)}
        />
        <button
          type="submit"
          className="bg-blue-500 transition-colors hover:bg-blue-600 text-white py-2 px-4 rounded"
        >
          Create
        </button>
      </form>
    </div>
  );
};

export default GenreForm;
