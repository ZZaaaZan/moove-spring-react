import "./PostDetail.css";
import React from "react";

const PostDetail = () => {
  return (
    <div className={"postContainer"}>
      <div className="titleContainer">
        <h2>상품 제목입니다.</h2>
        <div className={"PostMetaData"}>
          <p className={"postMetaDataItem"}>조회수 10</p>
          <p>관심 10</p>
        </div>
      </div>
      <div className="scrollContainer">
        <div className="imgContainer">
          <img
            className="thumbnailImg"
            src="https://i.ytimg.com/vi/nDDzUyGvloE/hq720_live.jpg?sqp=CPyw_44G-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDdagFZtic72KbIq3_g3OVbG8rGFQ"
          />
          <div className={"tagData"}>
            <p>#태그</p>
          </div>
        </div>
        <div className="description">상세 설명 와라라라라라라라라</div>
        <hr></hr>
        <div className="buttonContainer">
          <button className="btnItem">찜</button>
          <button className="btnItem">채팅하기</button>
          <button className="btnItem">신고하기</button>
        </div>
        <div className="sellerInfoContainer">
          <button>
            <img
              className="profileImg"
              src="https://t1.daumcdn.net/cfile/tistory/2513B53E55DB206927"
            ></img>
          </button>
          <div>
            <p className="nickName">nickName</p>
            <p className="sellerInfo">판매자 소개</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PostDetail;
