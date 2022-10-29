import axios from "axios";
import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
// import "./kakaoLogin.css";

const KakaoLogin = () => {
    // 카카오 개발자 앱 키 선언
    const REST_API_KEY = "2935fc05a9ace04a578f5aa55a2be049"; // RestAPI 키
    const REDIRECT_URI = "http://localhost:3000/login/oauth2/code/kakao"; // redirect 주소
    const KAKAO_AUTH_URI = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;
    // 인가코드 받아오기
    const code = new URL(window.location.href).searchParams.get("code");


    return (
        <>
            <div className="KaKaoBtn">
                <a href={KAKAO_AUTH_URI}>카카오로 시작하기</a>
            </div>
        </>
    );
};

export default KakaoLogin;