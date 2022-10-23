import React, { useState } from "react";

function ProductList() {
  const [number, setNumber] = useState(0);
  const [total, setTotal] = useState(0);

  const onIncrease = () => {
    setNumber(number + 1);
  };

  const onDecrease = () => {
    if (number <= 0) {
      setNumber(0);
    } else {
      setNumber(number - 1);
    }
  };

  return (
    <div>
      <ul className="product-list-item">
        <div>
          <p>상품명</p>
          <p>2000원</p>
        </div>
        <span className="count">
          <button onClick={onDecrease}>-</button>
          <p>{number}</p>
          <button onClick={onIncrease}>+</button>
        </span>
        
      </ul>
      <ul className="product-list-item">
        <div>
          <p>상품명</p>
          <p>2000원</p>
        </div>
        <span className="count">
          <button>-</button>
          <p>0</p>
          <button>+</button>
        </span>
      </ul>
      <ul className="product-list-item">
        <div>
          <p>상품명</p>
          <p>2000원</p>
        </div>
        <span className="count">
          <button>-</button>
          <p>0</p>
          <button>+</button>
        </span>
      </ul>
      <ul className="product-list-item">
        <div>
          <p>상품명</p>
          <p>2000원</p>
        </div>
        <span className="count">
          <button>-</button>
          <p>0</p>
          <button>+</button>
        </span>
      </ul>
      <div>
      <p>Total : {2000 * number}</p>
      <button>넘어가기</button>
      </div>
      
    </div>
  );
}

export default ProductList;
