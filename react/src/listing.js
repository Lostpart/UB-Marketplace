import {Link} from "react-router-dom";
import React, {Component} from 'react';
import './listing.css';
import Header from "./header";
import {handleAPIError} from "./errors";


class listing extends Component{
    constructor(props) {
        super(props);
        this.state ={
            items:[],
            isLoaded: true,

        }
    }

    componentDidMount() {
        const requestOptions = {
            /*remove 'no-cors' once item insertion function gets finished*/
            method: "get",
            headers: {
                "Content-Type": "application/json"
            }

        };

        fetch("https://ubmarketplace-develop.herokuapp.com/api/allitem",requestOptions)
            .then(response=> {
                if (response.status !== 200) {
                    handleAPIError(response);

                } else {
                    response.json().then(data => {
                        console.log(data);
                        this.setState({
                            isLoaded: true,
                            items: data.item})
                    });
                }
            })



    }

    render() {
        var{isLoaded, items} = this.state;
        const {name} = (this.props.location && this.props.location.state) || {};

        if(isLoaded==true){
            return (
                <div className="listing">
                    <Header/>
                    <div className="searchBar">
                        <input type="text"></input>
                        <button name="searchBtn">Search</button>
                    </div>

                    <div className="row">
                        {items.slice(0,8).map(item=>(
                            <div className="column">
                                <div className="card">
                                    <Link to="/item">
                                        <img src={item.images}/>
                                    </Link>
                                    <p>{item.name}</p>
                                    <p>${item.price}</p>
                                </div>
                            </div>
                        ))}
                    </div>

                    <div className="center">
                        <div className="pagination">

                            <a href="#/listing">&laquo;</a>
                            <a href="#/listing" className="active">1</a>
                            <a href="#/listing">2</a>
                            <a href="#/listing">3</a>
                            <a href="#/listing">4</a>
                            <a href="#/listing">5</a>
                            <a href="#/listing">6</a>
                            <a href="#/listing">7</a>
                            <a href="#/listing">8</a>
                            <a href="#">&raquo;</a>
                        </div>
                    </div>

                </div>

            );
        }


    }

}

export default listing;
