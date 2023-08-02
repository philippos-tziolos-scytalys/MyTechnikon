import Attribute from "./Attribute/Attribute";
import "./AttributesBar.css";

const AttributesBar = () => {
    return(
        <div className="attributesBar">
            <Attribute attribute = {"User Name"}/>
            <Attribute attribute = {"Email"}/>
            <Attribute attribute = {"Phone"}/>
            <Attribute attribute = {"Date Created"}/>
            <Attribute attribute = {"Last Edited"}/>
            <Attribute attribute = {"Actions"}/>
        </div>
    );
}

export default AttributesBar;