
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { NaverLogin } from "./components/NaverLogin";
import LoginPage from "./pages/Login/LoginPage";
import MainPage from "./pages/Main/MainPage"
import Post from "./components/Post/Post"
import DetailPage from "./pages/DetailPage/DetailPage";
import AddPostPage from "./pages/AddPostPage/AddPostPage";

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/detail" element={<DetailPage />} />
                    <Route path="/posts/write" element={<AddPostPage />}/>
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;