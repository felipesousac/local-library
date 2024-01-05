import { Outlet } from "react-router-dom";
import "./styles/App.css";
import "./styles/main.css";

function App() {
  return (
    <div className="container flex">
      <div className="flex flex-row text-[#ffffffde]">
        <div className="border-r min-h-screen bg-[#242424]">
          <ul className="mt-2 pb-2 px-2">
            <li>
              <a href="/catalog">Home</a>
            </li>
            <li>
              <a href="/catalog/books">All books</a>
            </li>
            <li>
              <a href="/catalog/authors">All authors</a>
            </li>
            <li>
              <a href="/catalog/genres">All genres</a>
            </li>
            <li className="mb-4">
              <a href="/catalog/bookinstances">All book-instances</a>
            </li>
            <li>
              <hr />
            </li>
            <li className="mt-4">
              <a href="/catalog/author/create">Create new author</a>
            </li>
            <li>
              <a href="/catalog/genre/create">Create new genre</a>
            </li>
            <li>
              <a href="/catalog/book/create">Create new book</a>
            </li>
            <li>
              <a href="/catalog/bookinstance/create">
                Create new book instance (copy)
              </a>
            </li>
          </ul>
        </div>
        <div className="col-sm-10"></div>
      </div>
      <Outlet />
    </div>
  );
}

export default App;
