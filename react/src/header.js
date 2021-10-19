import {Link} from "react-router-dom";

function Header() {
    return (
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
    )
}

export default Header