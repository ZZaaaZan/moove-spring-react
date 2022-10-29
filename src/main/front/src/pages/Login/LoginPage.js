import React from 'react';
import NaverLogin from "../../components/NaverLogin";
import KakaoLogin from '../../components/KakaoLogin';
import GoogleLogIn from '../../components/GoogleLogin';

function LoginPage(){
    return (
        <div className="App">
            <NaverLogin />
            <KakaoLogin />
            <GoogleLogIn />
        </div>
    )
}

export default LoginPage;