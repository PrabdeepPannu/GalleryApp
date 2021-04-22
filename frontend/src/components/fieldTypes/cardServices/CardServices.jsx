import React from "react";
import "./CardServices.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Card from "../../common/Card/Card";
import { faCogs } from "@fortawesome/free-solid-svg-icons";

const CardService = ({ data: { id, name } }) => {
  return (
    <Card
      className="card-service mt-4"
      minWidth="150px"
      maxWidth="50px"
      height="150px"
    >
      <p className="serice-text">{name}</p>
      <div
        className="circle-icon"
        data-toggle="tooltip"
        data-placement="bottom"
        title={name}
      >
        <FontAwesomeIcon
          size="3x"
          style={{ color: "gainsboro" }}
          icon={faCogs}
        />
      </div>
    </Card>
  );
};

export default CardService;
