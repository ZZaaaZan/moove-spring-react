
import PostDetail from "../../components/Detail/PostDetail/PostDetail";
import OrderForm from "../../components/Detail/OrderForm/OrderForm";

import "./DetailPage.css"
import Header from "../../components/Header/Header";
const DetailPage = () => {

    return (
        <div>
        <Header/>
        <div className={"detailContainer"}>

            <PostDetail/>
            <OrderForm/>
        </div>
        </div>
    );
};

export default DetailPage;