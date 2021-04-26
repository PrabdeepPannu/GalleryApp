import React from "react";
import "./CardMetrics.css";
import Graph from "../graph";
import { Card } from "../../common";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faArrowUp,
  faArrowDown,
  faDollarSign,
} from "@fortawesome/free-solid-svg-icons";

const CardMetrics = ({
  data: { name, difference, graphData: data, maxValue, inflation, positive },
}) => {
  let percentage = positive ? (
    <section>
      <FontAwesomeIcon id="percentage_arrow_green" icon={faArrowUp} />
      <p id="percentage_green">{`${inflation} % `}</p>
    </section>
  ) : (
    <section>
      <FontAwesomeIcon id="percentage_arrow_red" icon={faArrowDown} />
      <p id="percentage_red">{`${inflation} % `}</p>
    </section>
  );

  return (
    <Card
      className="cardMetrics card"
      minWidth="280px"
      maxWidth="280px"
      height="150px"
    >
      <div className="cardBody">
        <p>{name}</p>
        <FontAwesomeIcon id="amount_icon" icon={faDollarSign} />
        <p id="amount">{maxValue}</p>
        <p id="percentage">{percentage}</p>
        <p id="difference">{`vs.previous ${difference} days`}</p>
      </div>
      <div className="graphContainer">
        <Graph data={data} height="70px" />
      </div>
    </Card>
  );
};

export default CardMetrics;
