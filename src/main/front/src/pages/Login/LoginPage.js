import React from 'react';
import NaverLogin from "../../components/NaverLogin";
import GoogleLogin from "../../components/GoogleLogin";
import KakaoLogin from "../../components/KakaoLogin";

function LoginPage(){
    return (
        <div className="App">
            <NaverLogin />
            <GoogleLogin />
            <KakaoLogin />
        </div>
    )
}

export default LoginPage;