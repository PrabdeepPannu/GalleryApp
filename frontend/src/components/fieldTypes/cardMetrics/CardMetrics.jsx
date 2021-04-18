import React from "react";
import "./CardMetrics.css";

const CardMetrics = (props) => {
  let percentage =
    props.difference < 0 ? (
      <section>
        <i className="bi bi-arrow-down-short red"></i>
        <p id="difference" className="red">
          {props.percentage + " %"}
        </p>
      </section>
    ) : (
      <section>
          <i className="bi bi-arrow-up-short green"></i>
        <p id="difference" className="green">
          {props.percentage + " %"}
        </p>
      </section>
    );
  return (
    <div className="card text-center mt-3 mr-3 ml-3 mb-3">
      <div className="overflow">
        <img src="" alt="" />
      </div>
      <div className="card-body">
        <p id="title">{props.title}</p>
        <p id="amount">{props.amount}</p>
        {percentage}
        <p id="comparison" className="grey">
          {props.daysDiff}
        </p>
      </div>
    </div>
  );
};

export default CardMetrics;
