import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [news, setNews] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/news")
      .then(res => res.json())
      .then(data => setNews(data)) // 👈 IMPORTANT FIX
      .catch(err => console.error(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>AI News Summarizer</h1>

      {news.map((item, index) => (
        <div
          key={index}
          style={{
            marginBottom: "20px",
            padding: "10px",
            border: "1px solid #ccc",
            borderRadius: "8px"
          }}
        >
          <h3>{item.title}</h3>
          <p>{item.summary}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
