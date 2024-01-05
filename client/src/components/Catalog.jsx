const Catalog = () => {
  return (
    <div className="pl-2">
      <h1 className="text-4xl">Local Library Home</h1>
      <p className="mb-4">
        Welcome to <em>LocalLibrary</em>, a very basic Express website developed
        as a tutorial example on the Mozilla Developer Network.
      </p>
      <h1 className="text-4xl">Dynamic content</h1>
      <p>The library has the following record counts:</p>
      <ul className="list-disc ml-8">
        <li>
          <strong>Books: 1</strong>
        </li>
        <li>
          <strong>Copies: 2</strong>
        </li>
        <li>
          <strong>Copies available: 3</strong>
        </li>
        <li>
          <strong>Authors: 4</strong>
        </li>
        <li>
          <strong>Genres: 5</strong>
        </li>
      </ul>
    </div>
  );
};

export default Catalog;
