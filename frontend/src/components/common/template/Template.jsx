import React from "react";
import Cards from "../cards";
import "./Template.css";

class Template extends React.Component {
  render() {
    const dataMetrics = [
      { type: "metrics" },
      { type: "metrics" },
      { type: "metrics" },
      { type: "metrics" },
      { type: "metrics" },
      { type: "metrics" },
    ];
    const dataServices = [
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
      { type: "service" },
    ];
    const dataModelling = [{ type: "modelling" }, { type: "modelling" }];
    return (
      <div >
        <div className="row align-items-center">
          <Cards data={dataMetrics} />
        </div>
        <div className="row align-items-center">
          <Cards data={dataServices} />
        </div>
        <div className="row align-items-center">
          <Cards data={dataMetrics} />
        </div>
      </div>
    );
  }
}

export default Template;
