// src/routes/Router.jsx
import { Routes, Route } from 'react-router-dom';
import LoginPage from '../pages/LoginPage';
import BookListPage from '../pages/BookListPage';

const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route path="/books" element={<BookListPage />} />
    </Routes>
  );
};

export default Router;
