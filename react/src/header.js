import {Link} from "react-router-dom";
function Header() {
    return (
        <Link className="header">
            <p className="title"><Link to="">UB Marketplace</Link></p>
            <div className="dropdown">
                <button className="dropbtn">Profile</button>
                <div className="dropdown-content">
                    <Link to="/login">Login/Register</Link>
                    <Link to="/profile">View Profile</Link>
                </div>
            </div>
        </Link>
    )
}

export default Header