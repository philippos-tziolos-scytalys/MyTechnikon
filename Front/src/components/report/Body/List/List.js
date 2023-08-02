import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/ReportTuple";

const List = () => {
    const [properties, setProperties] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/reports")
        .then(response => response.json())
        .then(data => setProperties(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                properties.map(report => 
                <Tuple
                    id = {report.id}
                    reportType = {report.reportType}
                    reportDate = {report.reportDate}
                    description = {report.reportDescription}
                    user = {report.user.tin}
                />)
            }
        </div>
    );
}

export default List;