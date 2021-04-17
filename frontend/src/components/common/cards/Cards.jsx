import React from "react";
import { CardMetrics, CardServics, CardModellingData } from "../../fieldTypes";
import "./Cards.css";

class Cards extends React.Component {
  render() {
    let cards = this.props.data.map((val) => {
      if (val.type === "metrics") {
        return <CardMetrics data={val} />;
      } else if (val.type === "service") {
        return <CardServics data={val} />;
      } else if (val.type === "modelling") {
        return <CardModellingData data={val} />;
      }
      return null;
    });
    return (
      <div class="centered">
        <section class="cards">{cards}</section>
      </div>
    );
  }
}

export default Cards;
