import React from "react";
import Card from "../../common/Card/Card";
import "./CardModellingData.css";

const CardModellingData = ({ data: { title, url } }) => {
  return (
    <Card className="card cardModellingData">
      <div className="text-justify text-break text-wrap paragraph"> <p>{title}</p></div>
    </Card>
  );
};

export default CardModellingData;
