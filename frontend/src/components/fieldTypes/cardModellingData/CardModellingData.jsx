import React from "react";
import Card from "../../common/Card/Card";
import "./CardModellingData.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDatabase } from "@fortawesome/free-solid-svg-icons";

const CardModellingData = ({ data: { name, url } }) => {
  return (
    <Card className="cardModellingData card" minWidth="280px" maxWidth = "280px" height="100px">
      <p id="title">{name}</p>
      <div className="card-body">
      <FontAwesomeIcon size="3x" style={{ color: 'gainsboro'}} icon={faDatabase} />
      </div>
    </Card>
  );
};

export default CardModellingData;
