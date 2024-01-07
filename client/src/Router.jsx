import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App";
import Catalog from "./components/Catalog";
import BookList from "./components/BookList";

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
