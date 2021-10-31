import {Link} from "react-router-dom";
import React, {Component} from 'react';
import './item_detail.css';


class item_detail extends Component{
    constructor(props) {
        super();
        this.state ={
            items:[],
            isLoaded: true,
            relatedItems:[],
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
                    items: [{"itemId":"1",
                        "name":"Item Name1",
                        "owner":{"username":"abc@buffalo.edu","password":"123456"},
                        "description":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                        "price":25.0,
                        "imageFilePath":"https://images.unsplash.com/photo-1626885228113-0ac4b52e6cea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80",
                        "meetingPlace":["Student Union","Natural Science Complex","Capen Hall", "Lockwood Library", "Commons","Davis Hall","..."],
                        "createdTime":12345}],

                    relatedItems: [{"itemId":"1","name":"Item Name1","owner":{"username":"abc@buffalo.edu","password":"123456"},"description":"This is a book","price":25.0,"imageFilePath":"https://images.unsplash.com/photo-1626885228113-0ac4b52e6cea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80","meetingPlace":"North","createdTime":12345},
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
        var{items,relatedItems} = this.state;
        {/*show only 5 related products to load faster*/}
        relatedItems = relatedItems.slice(0,5)

        return (
            <div className="home">
                <div className="header">
                    <Link to="/">
                        <p className="title">UB Marketplace</p>
                    </Link>
                    <div className="dropdown">
                        <button className="dropbtn"></button>
                        <div className="dropdown-content">
                            <Link to="/login">Login/Register</Link>
                            <Link to="/profile">View Profile</Link>
                            <Link to="/">Logout</Link>
                        </div>
                    </div>
                </div>
                {items.map(item=>(
                    <div className="itemInfo">


                        <div className="itemLeft">
                            <div className="itemThumbnail">
                                <img src={item.imageFilePath}/>
                            </div>
                        </div>


                        <div className="itemRight">
                            <div className="itemName">
                                <h2>{item.name}</h2>
                            </div>
                            <div className="itemPrice">
                                <h3>Price: ${item.price}</h3>
                            </div>
                            <div className="itemLocation">
                                <h3>Available Meetup Locations</h3>
                                {item.meetingPlace.map(place=>(
                                    <button>{place}</button>
                                ))}
                            </div>
                            <h3 className="descriptionTitle">Item Description</h3>
                            <div className="itemDescription">
                                {item.description}
                            </div>
                        </div>


                    </div>
                ))}
                <div className="relatedItems">
                    <h3>Related Items</h3>
                </div>
                <div className="relatedList">

                    {relatedItems.map(item=>(
                        <div className="itemImg">
                            <a href="/#/item">
                                <img src={item.imageFilePath}/>
                            </a>
                            <p>{item.name}</p>
                            <p>${item.price}</p>
                        </div>
                    ))}
                </div>

            </div>



        );

    }

}

export default item_detail;
