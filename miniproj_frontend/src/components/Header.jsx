// src/components/Header.jsx
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <header className="px-4 py-2 bg-gray-100 shadow-md flex justify-between items-center">
      <Link to="/" className="text-xl font-bold">📚 Book Platform</Link>
      <nav className="space-x-4">
        <Link to="/books">책 목록</Link>
        <Link to="/write">글쓰기</Link>
      </nav>
    </header>
  );
};

export default Header;
