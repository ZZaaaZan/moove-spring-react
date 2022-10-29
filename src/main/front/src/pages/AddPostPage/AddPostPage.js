import React, { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import axios from "axios";
import "./AddPost.css";
import Header from "../../components/Header/Header";

function AddPostPage() {
  const [title, setTitle] = useState("");
  const [writer, setWrite] = useState("");
  const [content, setContent] = useState("");

  const titleHandler = (event) => {
    setTitle(event.target.value);
    console.log(title);
  };

  const writerHandler = (event) => {
    event.preventDefault();
    setWrite(event.target.value);
  };

  const contentHandler = (event) => {
    event.preventDefault();
    setContent(event.target.value);
  };

  const saveHandler = (event) => {
    event.preventDefault();
    console.log(title);
    console.log(writer);
    console.log(content);

    const body = {
      title: title,
      writer: writer,
      content: content,
    };

    console.log("dkdkd");
    console.log(body);
    axios
      .post("http://localhost:8080/api/posts", body)
      .then((res) => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error.response);
      });
    alert("등록완료");
  };

  return (
    <div>
      <Header/>
      <div className="addPostContainer">
      <form onSubmit={saveHandler} className="addPost">
        <input
          type="text"
          value={title}
          onChange={titleHandler}
          placeholder="제목"
        />
        <textarea
          type="text"
          value={content}
          onChange={contentHandler}
          placeholder="내용을 입력하세요"
        ></textarea>
        <input
          type="text"
          value={writer}
          onChange={writerHandler}
          placeholder="작성자를 입력하세요"
        />
        <button type="submit">등록</button>
        <Link to="/"></Link>
        
      </form>
      </div>
    </div>
  );
}

export default AddPostPage;
