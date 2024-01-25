import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App";
import Catalog from "./components/Catalog";
import BookList from "./components/BookList";
import BookInstanceList from "./components/BookInstanceList";
import AuthorList from "./components/AuthorList";
import GenreList from "./components/GenreList";
import GenreDetailPage from "./components/GenreDetailPage";
import BookDetailPage from "./components/BookDetailPage";
import AuthorDetailPage from "./components/AuthorDetailPage";
import BookInstanceDetailPage from "./components/BookInstanceDetailPage";

const Router = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <App />,
      children: [
        {
          path: "/catalog",
          element: <Catalog />,
        },
        {
          path: "/catalog/books",
          element: <BookList />,
        },
        {
          path: "/catalog/bookinstances",
          element: <BookInstanceList />,
        },
        {
          path: "/catalog/authors",
          element: <AuthorList />,
        },
        {
          path: "/catalog/genres",
          element: <GenreList />,
        },
        {
          path: "/catalog/genres/:id",
          element: <GenreDetailPage />,
        },
        {
          path: "/catalog/books/:id",
          element: <BookDetailPage />,
        },
        {
          path: "/catalog/author/:id",
          element: <AuthorDetailPage />,
        },
        {
          path: "/catalog/bookinstance/:id",
          element: <BookInstanceDetailPage />,
        },
      ],
    },
    {
      path: "/new",
      element: <>Building</>,
    },
  ]);

  return <RouterProvider router={router} />;
};

export default Router;
