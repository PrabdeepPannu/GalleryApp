import React, { useEffect, useState } from "react";
import "./CardMetrics.css";
import { Card } from "../../common";
import axios from "axios";
import { api } from "../../../options.global";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faArrowUp,
  faArrowDown,
  faDollarSign,
} from "@fortawesome/free-solid-svg-icons";

const CardMetrics = ({ data: { id, name, difference } }) => {
  const [graphData, setGraph] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const { data } = await axios.get(`${api}/metric/${id}/data`);
      const maxValue = Math.max.apply(
        Math,
        data.map(function (point) {
          return point.hit;
        })
      );
      let increase = 0;
      let decrease = 0;
      const lastIndex = data[data.length - 1].hit;
      const secondLastIndex = data[data.length - 2].hit;
      if (lastIndex > secondLastIndex) {
        increase = (secondLastIndex / lastIndex) * 100;
      } else {
        decrease = ((secondLastIndex - lastIndex) / secondLastIndex) * 100;
      }
      setGraph({
        data: data,
        increase: Math.round(increase),
        decrease: Math.round(decrease),
        maxValue,
      });
    };
    fetchData();
  }, []);

  let percentage =
    graphData.increase > 0 ? (
      <section>
        <FontAwesomeIcon id="percentage_arrow_green" icon={faArrowUp} />
        <p id="percentage_green">{`${graphData.increase} % `}</p>
      </section>
    ) : (
      <section>
        <FontAwesomeIcon id="percentage_arrow_red" icon={faArrowDown} />
        <p id="percentage_red">
          {graphData.decrease + " %"}
        </p>
      </section>
    );

  return (
    <Card
      className="cardMetrics card"
      minWidth="280px"
      maxWidth="280px"
      height="150px"
    >
      <p>{name}</p>
      <FontAwesomeIcon id="amount_icon" icon={faDollarSign} />
      <p id="amount">{graphData.maxValue}</p>
      <p id="percentage">{percentage}</p>
      <p id="difference">{`vs.previous ${difference} days`}</p>
    </Card>
  );
};

export default CardMetrics;
