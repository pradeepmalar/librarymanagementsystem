import React, { useState, useEffect } from 'react';
import './App.css';

function App() {

  const [books, setBooks] = useState([]);
  const [members, setMembers] = useState([]);
  const [borrows, setBorrows] = useState([]);

  const [bookName, setBookName] = useState('');
  const [author, setAuthor] = useState('');
  const [publishYear, setPublishYear] = useState('');

  const [uName, setUName] = useState('');
  const [uAge, setUAge] = useState('');
  const [uMobile, setUMobile] = useState('');

  const [borrowBookId, setBorrowBookId] = useState('');
  const [borrowUId, setBorrowUId] = useState('');
  const [borrowDate, setBorrowDate] = useState('');

  useEffect(() => {
    fetchAllData();
  }, []);

  const fetchAllData = () => {
    fetch("http://localhost:8080/api/books").then(res => res.json()).then(data => setBooks(data));
    fetch("http://localhost:8080/api/members").then(res => res.json()).then(data => setMembers(data));
    fetch("http://localhost:8080/api/borrows").then(res => res.json()).then(data => setBorrows(data));
  };

  const handleAddBook = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/api/books", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ bookName, author, publishYear: parseInt(publishYear) })
    }).then(() => { fetchAllData(); setBookName(''); setAuthor(''); setPublishYear(''); });
  };

  const handleAddMember = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/api/members", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ uName, uAge: parseInt(uAge), uMobile })
    }).then(() => { fetchAllData(); setUName(''); setUAge(''); setUMobile(''); });
  };

  const handleAddBorrow = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/api/borrows", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ bookId: parseInt(borrowBookId), uId: parseInt(borrowUId), borrowDate, status: "BORROWED" })
    }).then(() => { fetchAllData(); setBorrowBookId(''); setBorrowUId(''); setBorrowDate(''); });
  };

  return (
      <div className = "dashboard-container">
        <h1>Library Management System</h1>
        <p className = "subtitle">Admin Control Panel</p>
        <hr />

        {}
        <h2>1. Books Management</h2>
        <form onSubmit = {handleAddBook} className = "form-inline">
          <input placeholder = "Book Name" value = {bookName} onChange = {e => setBookName(e.target.value)} required />
          <input placeholder = "Author" value = {author} onChange = {e => setAuthor(e.target.value)} required />
          <input placeholder = "Publish Year" type = "number" value = {publishYear} onChange = {e => setPublishYear(e.target.value)} required />
          <button type = "submit">Add Book</button>
        </form>
        <table className = "data-table">
          <thead>
          <tr><th>ID</th><th>Book Name</th><th>Author</th><th>Year</th></tr>
          </thead>
          <tbody>
          {books.map(b => (
              <tr key = {b.book_id}><td>{b.book_id}</td><td>{b.bookName}</td><td>{b.author}</td><td>{b.publishYear}</td></tr>
          ))}
          </tbody>
        </table>

        {}
        <h2>2. Members Management</h2>
        <form onSubmit = {handleAddMember} className = "form-inline">
          <input placeholder = "Member Name" value = {uName} onChange = {e => setUName(e.target.value)} required />
          <input placeholder = "Age" type = "number" value = {uAge} onChange = {e => setUAge(e.target.value)} required />
          <input placeholder = "Mobile (10 digits)" value = {uMobile} onChange = {e => setUMobile(e.target.value)} maxLength = "10" required />
          <button type = "submit">Add Member</button>
        </form>
        <table className = "data-table">
          <thead>
          <tr><th>User ID</th><th>Name</th><th>Age</th><th>Mobile</th></tr>
          </thead>
          <tbody>
          {members.map(m => (
              <tr key = {m.u_id}><td>{m.u_id}</td><td>{m.uName}</td><td>{m.uAge}</td><td>{m.uMobile}</td></tr>
          ))}
          </tbody>
        </table>

        {}
        <h2>3. Borrow Transactions</h2>
        <form onSubmit = {handleAddBorrow} className = "form-inline">
          <input placeholder = "Book ID" type = "number" value = {borrowBookId} onChange = {e => setBorrowBookId(e.target.value)} required />
          <input placeholder = "User ID" type = "number" value = {borrowUId} onChange = {e => setBorrowUId(e.target.value)} required />
          <input type = "date" value = {borrowDate} onChange = {e => setBorrowDate(e.target.value)} required />
          <button type = "submit" style = {{ backgroundColor: '#e67e22' }}>Issue Book</button>
        </form>
        <table className = "data-table">
          <thead>
          <tr><th>Borrow ID</th><th>Book ID</th><th>User ID</th><th>Borrow Date</th><th>Status</th></tr>
          </thead>
          <tbody>
          {borrows.map(br => (
              <tr key = {br.borrow_id}>
                <td>{br.borrow_id}</td>
                <td>{br.bookId}</td>
                <td>{br.uId}</td>
                <td>{br.borrowDate}</td>
                <td><span className = "status-badge">{br.status}</span></td>
              </tr>
          ))}
          </tbody>
        </table>
      </div>
  );
}

export default App;
