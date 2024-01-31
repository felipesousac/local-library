import { useState } from "react";
import axios from "axios";
import { Snackbar, Alert } from "@mui/material";

const GenreForm = () => {
  const [name, setName] = useState("");
  const [open, setOpen] = useState(false);

  const handleClose = (event, reason) => {
    if (reason === "clickaway") {
      return;
    }

    setOpen(false);
  };

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
        setOpen(true);
        setName("");
      })
      .catch((error) => {
        console.log(error.response.data);
      });
  };

  // LOGIC TO REMOVE ITEM FROM LIST - USEFULL
  /*const removeToast = (id) => {
    setToasts((prevToasts) => prevToasts.filter((toast) => toast.id !== id));
  };*/

  return (
    <>
      <div className="pl-2">
        <h1 className="text-4xl mb-4">Create Genre</h1>
        <form className="flex flex-col gap-3" onSubmit={createGenre}>
          <input
            className="border-2 border-gray-400 rounded p-2 focus:border-2 focus:border-blue-600 focus:outline-none "
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
      {open && (
        <Snackbar open={open} autoHideDuration={2000} onClose={handleClose}>
          <Alert
            onClose={handleClose}
            severity="success"
            variant="filled"
            sx={{ width: "100%" }}
          >
            Genre created successfully!
          </Alert>
        </Snackbar>
      )}
    </>
  );
};

export default GenreForm;
