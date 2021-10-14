import './App.css';
import './profile.css';
import sample from "./sample.jpeg";
import {Link} from "react-router-dom";

function home() {
    return (
        <div className="home">
            <div className="header">
                <p className="title">UB Marketplace</p>
                <div className="dropdown">
                    <button className="dropbtn">Profile</button>
                    <div className="dropdown-content">
                        <Link to="/login">Login/Register</Link>
                        <Link to="/profile">View Profile</Link>
                    </div>
                </div>
            </div>

            <div className="itemList">
                <div className="itemImg">
                    <img src={sample}/>
                    <p>Product Name</p>
                    <p>Product Price</p>
                </div>
                <div className="itemImg">
                    <img src={sample}/>
                    <p>Product Name</p>
                    <p>Product Price</p>
                </div>
                <div className="itemImg">
                    <img src={sample}/>
                    <p>Product Name</p>
                    <p>Product Price</p>
                </div>
                <div className="itemImg">
                    <img src={sample}/>
                    <p>Product Name</p>
                    <p>Product Price</p>
                </div>
                <div className="itemImg">
                    <img src={sample}/>
                    <p>Product Name</p>
                    <p>Product Price</p>
                </div>
            </div>

            <div className="categoryList">
                <h2>Category List</h2>
                <ul>
                    <li>Electronics</li>
                    <li>Textbooks</li>
                    <li>Clothings</li>
                    <li>Furnitures</li>
                </ul>
                <ul>
                    <li>Electronics</li>
                    <li>Textbooks</li>
                    <li>Clothings</li>
                    <li>Furnitures</li>
                </ul>
                <ul>
                    <li>Electronics</li>
                    <li>Textbooks</li>
                    <li>Clothings</li>
                    <li>Furnitures</li>
                </ul>
                <ul>
                    <li>Electronics</li>
                    <li>Textbooks</li>
                    <li>Clothings</li>
                    <li>Furnitures</li>
                </ul>
                <ul>
                    <li>See All Items</li>
                    <li>Sell My Items</li>
                </ul>
            </div>
        </div>

    );
}

export default home;
