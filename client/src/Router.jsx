import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App";
import Catalog from "./components/display/Catalog";
import BookList from "./components/display/BookList";
import BookInstanceList from "./components/display/BookInstanceList";
import AuthorList from "./components/display/AuthorList";
import GenreList from "./components/display/GenreList";
import GenreDetailPage from "./components/display/GenreDetailPage";
import BookDetailPage from "./components/display/BookDetailPage";
import AuthorDetailPage from "./components/display/AuthorDetailPage";
import BookInstanceDetailPage from "./components/display/BookInstanceDetailPage";
import GenreForm from "./components/form/GenreForm";

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
          path: "/catalog/genre/create",
          element: <GenreForm />,
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
