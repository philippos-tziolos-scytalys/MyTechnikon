import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/RepairTuple";

const List = () => {
    const [properties, setProperties] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/repairs")
        .then(response => response.json())
        .then(data => setProperties(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                properties.map(repair => 
                <Tuple
                    id = {repair.id}
                    repairType = {repair.repairType}
                    repairStatus = {repair.repairStatus}
                    description = {repair.description}
                    repairDate = {repair.repairDate}
                    cost = {repair.cost}
                    property = {repair.property.pin}
                    customer = {repair.property.user.tin}
                />)
            }
        </div>
    );
}

export default List;