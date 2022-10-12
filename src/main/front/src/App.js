
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { NaverLogin } from "./components/NaverLogin";
import LoginPage from "./pages/Login/LoginPage";

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/" element={<LoginPage />} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;