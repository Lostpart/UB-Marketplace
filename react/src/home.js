import {Link} from "react-router-dom";
import React, {Component} from 'react';
import "./Carousel.css";
import './home.css';
import Carousel from "./Carousel"
import Header from "./header";


class home extends Component{
    constructor(props) {
        super();
        this.state ={
            items:[],
            isLoaded: true,

        }
    }

    componentDidMount() {
        const requestOptions = {
            /*remove 'no-cors' once item insertion function gets finished*/
            // mode: 'no-cors',
            method: "get",
            headers: {
                "Content-Type": "application/json"
            }

        };


        /*actual api fetch function once insert item gets finished*/
        // fetch('/api/allitem',requestOptions)
        //     .then(res=>res.json())
        //     .then(data=>{
        //         this.setState({
        //             isLoaded: true,
        //             items: data})
        //     })




        fetch('http://ubmarketplace-develop.herokuapp.com/api/allitem',requestOptions)
            .then(res=>{
                this.setState({
                    isLoaded: true,
                    //items: res.json
                    items: [{"itemId":"1","name":"Item Name1","owner":{"username":"abc@buffalo.edu","password":"123456"},"description":"This is a book","price":25.0,"imageFilePath":"https://images.unsplash.com/photo-1626885228113-0ac4b52e6cea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80","meetingPlace":"North","createdTime":12345},
                        {"itemId":"2","name":"Item Name2","owner":{"username":"zzhong","displayName":"123456"},"description":"This is a book","price":11.0,"imageFilePath":"https://images.unsplash.com/photo-1593642532973-d31b6557fa68?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1480&q=80","meetingPlace":"North","createdTime":12345},
                        {"itemId":"3","name":"Item Name3","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":12.0,"imageFilePath":"https://images.unsplash.com/photo-1493663284031-b7e3aefcae8e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"4","name":"Item Name4","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":41.0,"imageFilePath":"https://images.unsplash.com/photo-1593642632559-0c6d3fc62b89?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2069&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"5","name":"Item Name5","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":231.0,"imageFilePath":"https://images.unsplash.com/photo-1566813916511-2701d4c96576?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3570&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"6","name":"Item Name6","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":54.0,"imageFilePath":"https://images.unsplash.com/photo-1526738549149-8e07eca6c147?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1925&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"7","name":"Item Name7","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":123.0,"imageFilePath":"https://images.unsplash.com/photo-1627719172031-ab42dc849bc3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"8","name":"Item Name8","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":22.0,"imageFilePath":"https://images.unsplash.com/photo-1518611507436-f9221403cca2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1925&q=80","meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"9","name":"Item Name9","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":5.0,"imageFilePath":"https://images.unsplash.com/photo-1531347520814-e80b3cbe3cba?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1066&q=80","meetingPlace":"South campus","createdTime":114514}]
                })
            })
    }

    render() {
        var{isLoaded, items} = this.state;
        const {name} = (this.props.location && this.props.location.state) || {};
        if(name==null){
            return (
                <div className="home">
                    <Header />

                    <div className="itemList">
                        <Carousel  show={5} infiniteLoop>
                            {items.map(item=>(
                                <div className="itemImg">
                                    {/*link needs to be uuid ex) item.uuid */}
                                    <Link to="/item">
                                    <img src={item.imageFilePath}/></Link>
                                    <p>{item.name}</p>
                                    <p>${item.price}</p>

                                </div>
                            ))}
                        </Carousel>
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
                            <li><Link to="/sell">Sell My Items</Link></li>
                        </ul>
                    </div>
                </div>

            );
        }
        else{
            return (
                <div className="home">
                    <div className="header">
                        <p className="title">UB Marketplace</p>
                        <div className="dropdown">
                            <button className="dropbtn">{name}</button>
                            <div className="dropdown-content">
                                <Link to="/login">Login/Register</Link>
                                <Link to="/profile">View Profile</Link>
                                <Link to="/">Logout</Link>
                            </div>
                        </div>
                    </div>

                    <div className="itemList">
                        <Carousel  show={5} infiniteLoop>
                            {items.map(item=>(
                                <div className="itemImg">
                                    <img src={item.imageFilePath}/>
                                    <p>{item.name}</p>
                                    <p>${item.price}</p>
                                </div>
                            ))}
                        </Carousel>
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

    }

}

export default home;
