import {Link} from "react-router-dom";
import React, {Component} from 'react';
import './item_detail.css';
import { handleAPIError } from "./errors";


class Item_Detail extends Component{
    constructor(props) {
        super();
        this.state ={
            item: null,
            relatedItems: null,
            id: null
        }
    }
    componentDidMount() {
        const id = this.props.match.params.id;
        this.setState({
            id: id
        })
        const requestOptions = {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }

        };

        fetch(`/api/getItem/${id}`, requestOptions)
            .then(res=>{
                if (res.status !== 200) {
                    handleAPIError(res);
                    /*
                    this.setState({
                        item: {"itemId":"0",
                        "name":`Item Name ${id}`,
                        "owner":{"username":"abc@buffalo.edu","password":"123456"},
                        "description":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                        "price":25.0,
                        "images":["https://images.unsplash.com/photo-1626885228113-0ac4b52e6cea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80", "https://images.unsplash.com/photo-1593642632559-0c6d3fc62b89?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2069&q=80"],
                        "meetingPlace":"Student Union",
                        "createdTime":12345}
                    })
                    */
                } else {
                    res.json().then(data => {
                        const item = data.item;
                        this.setState({
                            item: item
                        })
                    })
                }
            })

        fetch('/api/allitem',requestOptions)
            .then(res=>{
                if (res.status !== 200) {
                    handleAPIError(res);
                    /*
                    this.setState({
                        relatedItems: [{"itemId":"1","name":"Item Name1","owner":{"username":"abc@buffalo.edu","password":"123456"},"description":"This is a book","price":25.0,"images":["https://images.unsplash.com/photo-1626885228113-0ac4b52e6cea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80"],"meetingPlace":"North","createdTime":12345},
                        {"itemId":"2","name":"Item Name2","owner":{"username":"zzhong","displayName":"123456"},"description":"This is a book","price":11.0,"images":["https://images.unsplash.com/photo-1593642532973-d31b6557fa68?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1480&q=80"],"meetingPlace":"North","createdTime":12345},
                        {"itemId":"3","name":"Item Name3","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":12.0,"images":["https://images.unsplash.com/photo-1493663284031-b7e3aefcae8e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2070&q=80"],"meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"4","name":"Item Name4","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":41.0,"images":["https://images.unsplash.com/photo-1593642632559-0c6d3fc62b89?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2069&q=80"],"meetingPlace":"South campus","createdTime":114514},
                        {"itemId":"5","name":"Item Name5","owner":{"username":"abc@buffalo.edu","displayName":"12345678"},"description":"This is a car","price":231.0,"images":["https://images.unsplash.com/photo-1566813916511-2701d4c96576?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3570&q=80"],"meetingPlace":"South campus","createdTime":114514}]
                    })
                    */
                } else {
                    res.json().then(data => { 
                        const items = data.item;
                        const otherItems = items.filter(item => item.itemId !== id).slice(0,5);
                        this.setState({
                            relatedItems: otherItems
                        }) 
                    });
                }
            });
    }

    render() {
        let{item,relatedItems} = this.state;

        let editLink = `/item/edit/${this.state.itemId}`;

        const related = relatedItems ? relatedItems.map(item=>(
            <div className="itemImg">
                <a href={'#/item/'+item.itemId.toString()} target="_blank">
                    <img src={item.images[0]} alt={item.name} />
                </a>
                <p>{item.name}</p>
                <p>${item.price}</p>
            </div>
        )) : null;

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
                {item ?
                    <div className="itemInfo">
                        <div className="itemLeft">
                            <div className="itemThumbnail">
                                <img src={item.images[0]} alt={item.name} />
                            </div>
                        </div>
                        <div className="itemRight">
                            <div className="itemName">
                                <h2>{item.name} {item.owner.userId === localStorage.getItem("email") ? <Link to={editLink}>Edit Item</Link> : ''}</h2>
                            </div>
                            <div className="itemPrice">
                                <h3>Price: ${item.price}</h3>
                            </div>
                            <div className="itemLocation">
                                <h3>Available Meetup Location</h3>
                                <button>{item.meetingPlace}</button>
                            </div>
                            <h3 className="descriptionTitle">Item Description</h3>
                            <div className="itemDescription">
                                {item.description}
                            </div>
                        </div>
                    </div>
                : 
                    <p>Loading...</p>
                }
                { related ? 
                    <div className="relatedList">
                        <div className="relatedItems">
                            <h3>Related Items</h3>
                        </div>
                        {related}
                    </div>
                : '' }
            </div>
        );
    }
}

export default Item_Detail;
