import React, {useEffect,useState} from 'react';
import axios from 'axios'
import './listing.css';
import Header from "./header";
import Posts from './posts'
import Pagination from './Pagination'

const Listing = () =>{
    const[posts, setPosts] = useState([]);
    const[loading, setLoading] = useState(false);
    const[currentPage, setCurrentPage] = useState(1);
    const[postPerPage] = useState(8);

    useEffect(()=> {
        const fetchPosts = async () => {
            setLoading(true);
            const res = await axios.get('/api/allitem');
            setPosts(res.data.item);
            setLoading(false);
        }
        fetchPosts();
    }, []);

    const indexOfLastPost = currentPage * postPerPage;
    const indexofFirstPost = indexOfLastPost - postPerPage;
    const currentPosts = posts.slice(indexofFirstPost, indexOfLastPost);
    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    return (
        <div className="listing">
            <Header/>
            <div className="searchBar">
                <input type="text"></input>
                <button name="searchBtn">Search</button>
            </div>
            <Posts posts={currentPosts} loading={loading}/>
            <Pagination postsPerPage={postPerPage} totalPosts={posts.length} paginate={paginate} currentPage={currentPage}/>
        </div>

    );
}


export default Listing;