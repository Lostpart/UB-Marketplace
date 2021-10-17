import './App.css';
import './profile.css';
import profileImg from "./profile.png";
import {Link} from "react-router-dom";

function profile() {
    return (
        <div className="profile">
            <div className="header">
                <p className="title">
                    <Link to ="/">UB Marketplace
                    </Link>
                </p>
                <div className="dropdown">
                    <button className="dropbtn">Profile</button>
                    <div className="dropdown-content">
                        <Link to="/login">Login/Register</Link>
                        <Link to="/profile">View Profile</Link>
                    </div>
                </div>
            </div>
            <div className="content">

                <div className="body-Left">

                    <div className="profile_picture">
                        <img src={profileImg}/>
                    </div>

                </div>

                <div className="body-Right">

                    <div className="profile_info">
                        <form>
                            <label>First Name: </label>
                            <input type="text" name="firsName" value="First Name" /><br/>
                            <label>Last Name: </label>
                            <input type="text" name="lastName" value="Last Name"/><br/>
                            <label>Email: </label>
                            <input type="text" name="email" value="Email Address"/><br/>
                            <label>Username: </label>
                            <input type="text" name="userName" value="Username"/><br/>
                            <label>Password: </label>
                            <input type="text" name="password" value="Password"/><br/>
                            <input className="subBtn" type="submit" value="Edit" /><br/>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    );
}

export default profile;
