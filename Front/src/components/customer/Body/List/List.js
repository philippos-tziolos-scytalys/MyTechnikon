import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/CustomerTuple";

const List = () => {
    const [users, setUsers] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/users")
        .then(response => response.json())
        .then(data => setUsers(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                users.map(user => 
                <Tuple
                    id = {user.id}
                    photo = {<img src={require("../assets/plus.svg").default}/>}
                    name = {user.username}
                    email = {user.email}
                    phone = {user.phone}
                    dateCreated = {user.dateCreated}
                    dateEdited = {user.dateEdited}
                />)
            }
        </div>
        
        
    );
}

export default List;