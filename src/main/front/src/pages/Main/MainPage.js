import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Header from "../../components/Header/Header";
import MainList from "../../components/MainList/MainList";
import AddPostPage from "../AddPostPage/AddPostPage";

import "./MainPage.css";

const MainPage = () => {
  return (
    <div className="course-goals">
      <Header />
      <MainList className={"main-page"} />
      <Link to="/add">
        <button className="addBtn">+</button>
      </Link>
    </div>
  );
};

export default MainPage;
