import React from "react";
import "./CardServices.css";
import "./facebook.svg";

const CardService = ({ data: { first_name, avatar } }) => {
  return (
    <div className="card card-service mt-3 mr-3 ml-3 mb-3">
      <p className="serice-text">{first_name}</p>
      <div className="card-body">
        <img src={avatar} alt="service name" />
      </div>
    </div>
  );
};

export default CardService;
