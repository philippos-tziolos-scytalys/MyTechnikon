import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/PropertyTuple";

const List = () => {
    const [properties, setProperties] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/properties")
        .then(response => response.json())
        .then(data => setProperties(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                properties.map(property => 
                <Tuple
                    id = {property.id}
                    pin = {property.pin}
                    address = {property.address}
                    constructionYear = {property.constructionYear}
                    propertyType = {property.propertyType}
                    propertyPictureUrl = {property.propertyPictureUrl}
                    propertyLongitude = {property.propertyLongitude}
                    propertyLatitude = {property.propertyLatitude}
                    active = {property.active}
                    user = {property.user.id}
                />)
            }
        </div>
        
        
    );
}

export default List;