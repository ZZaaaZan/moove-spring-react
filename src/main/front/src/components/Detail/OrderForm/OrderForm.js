import "./OrderForm.css"
import React from "react";
import ProductList from "./ProductList"


const OrderForm = () => {

    return (
        <div className={"OrderFormContainer"}>
            <h3>주문서</h3>
            <div>
                <ProductList/>
            </div>
        </div>
    );
};

export default OrderForm;