import "./Header.css"

const Header = () => {
    return(
        <header className="header">
            <div className="header-left">
                <div className="logo">Moove:</div>
                <div className="form"><form ><input type="text"/></form></div>
            </div>

            <div className="header-right">
                로그인
            </div>
        </header>
    )
}

export default Header