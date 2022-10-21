import "./MainList.css"
import React, {useEffect, useState} from 'react';
import axios from 'axios';

const MainList = () => {

    const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div className="container">
            <div className="item">
                <div className={"content"}>
                <div className="imgContainer">
                    <img className="thumbnailImg"
                         src="https://i.ytimg.com/vi/nDDzUyGvloE/hq720_live.jpg?sqp=CPyw_44G-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDdagFZtic72KbIq3_g3OVbG8rGFQ"/>
                </div>
                <div className="imgDetailsContainer">
                    <div className="imgMetaDetails">
                        <div className="imgTitle">
                            <h3>상품 내용 어쩌구</h3>
                            <p className="dateText">2022년 7월 28일</p>
                        </div>
                        <div className="imgMetaData">
                            <span className="metaText">판매자명</span>
                        </div>
                    </div>
                </div>
                </div>
            </div>
            <div className="item">item</div>
            <div className="item">item</div>
            <div className="item">item</div>
        </div>
    );
};

export default MainList;