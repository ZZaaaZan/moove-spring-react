import { useEffect } from 'react'

const NaverLogin = ({ setGetToken, setUserInfo }) => {


    const { naver } = window
    const NAVER_CLIENT_ID = "KVo9MWX9IDBmSkP07M1U"
    const NAVER_CALLBACK_URL = "http://localhost:8080/login/oauth2/code/naver"

    const initializeNaverLogin = () => {
        const naverLogin = new naver.LoginWithNaverId({
            clientId: NAVER_CLIENT_ID,
            callbackUrl: NAVER_CALLBACK_URL,
            // 팝업창으로 로그인을 진행할 것인지?
            isPopup: false,
            // 버튼 타입 ( 색상, 타입, 크기 변경 가능 )
            loginButton: { color: 'green', type: 3, height: 58 },
            callbackHandle: true,
        })
        naverLogin.init() // 로그인 설정

        // 선언된 naverLogin 을 이용하여 유저 (사용자) 정보를 불러오는데
        // 함수 내부에서 naverLogin을 선언하였기에 지역변수처리가 되어
        // userinfo 정보를 추출하는 것은 지역변수와 같은 함수에서 진행주어야한다.

        // 아래와 같이 로그인한 유저 ( 사용자 ) 정보를 직접 접근하여 추출가능하다.
        // 이때, 데이터는 첫 연동시 정보 동의한 데이터만 추출 가능하다.

        // 백엔드 개발자가 정보를 전달해준다면 아래 요기! 라고 작성된 부분까지는
        // 코드 생략이 가능하다.

    }

    const userAccessToken = () => {
        window.location.href.includes('access_token') && getToken()
}
    
      const getToken = () => {
    const token = window.location.href.split('=')[1].split('&')[0]
    console.log(token)
         // console.log, alert 창을 통해 토큰이 잘 추출 되는지 확인하자! 
            
         // 이후 로컬 스토리지 또는 state에 저장하여 사용하자!   
            // localStorage.setItem('access_token', token)
            // setGetToken(token)
}



    // 화면 첫 렌더링이후 바로 실행하기 위해 useEffect 를 사용하였다.
    useEffect(() => {
        initializeNaverLogin()
        userAccessToken()
    }, [])


    return (
        <>
        <div id="naverIdLogin" > </div>  {/* 로그인 버튼 */}
        </>
)
};
export default NaverLogin;